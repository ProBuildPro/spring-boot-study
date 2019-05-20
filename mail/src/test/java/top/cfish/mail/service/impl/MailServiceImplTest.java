package top.cfish.mail.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import top.cfish.mail.MailApplicationTests;
import top.cfish.mail.service.MailService;

import static org.junit.Assert.*;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 11:50
 */
public class MailServiceImplTest extends MailApplicationTests
{
	@Autowired
	private MailService mailService;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Test
	public void sendSimpleMail()
	{
		mailService.sendSimpleMail("i.fish@qq.com", "简单邮件", "Hello World");
	}
	
	@Test
	public void sendHtmlMail()
	{
		String content = "<html>\n" + "<body>\n" + "    <h3>Hello World</h3>\n" + "</body>\n" + "</html>";
		mailService.sendHtmlMail("i.fish@qq.com", "含HTML邮件", content);
	}
	
	@Test
	public void sendAttachmentsMail()
	{
		String filePath = "D:\\Tools\\ShadowsocksNew\\pac.txt";
		mailService.sendAttachmentsMail("i.fish@qq.com", "含附件邮件", "请查收附件", filePath);
	}
	
	@Test
	public void sendInlineResourceMail()
	{
		String rscId = "psb";
		String content = "<html><body><img src=\'cid:" + rscId + "\' ></body></html>";
		String imgPath = "C:\\Users\\isisiwish\\Pictures\\psb.jpg";
		
		mailService.sendInlineResourceMail("i.fish@qq.com", "含图片邮件", content, imgPath, rscId);
	}
	
	@Test
	public void sendTemplateMail()
	{
		// 创建邮件正文
		Context context = new Context();
		context.setVariable("id", "001");
		String emailContent = templateEngine.process("emailTemplate", context);
		
		mailService.sendHtmlMail("i.fish@qq.com", "模板邮件", emailContent);
	}
}


