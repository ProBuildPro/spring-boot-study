package top.cfish.mail.service;

/**
 * @author: isisiwish
 * @date: 2019/5/20
 * @time: 11:38
 */
public interface MailService
{
	void sendSimpleMail(String to, String subject, String content);
	
	void sendHtmlMail(String to, String subject, String content);
	
	void sendAttachmentsMail(String to, String subject, String content, String filePath);
	
	void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
