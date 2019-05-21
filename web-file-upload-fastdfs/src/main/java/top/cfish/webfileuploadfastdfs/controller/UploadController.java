package top.cfish.webfileuploadfastdfs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.cfish.webfileuploadfastdfs.util.FastDFSClient;
import top.cfish.webfileuploadfastdfs.util.FastDFSFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: isisiwish
 * @date: 2019/5/21
 * @time: 10:25
 */
@Slf4j
@Controller
public class UploadController
{
	private static String UPLOADED_FOLDER = "E:\\D\\spring-boot-study\\web-file-upload\\src\\main\\resources\\file_upload\\";
	
	@GetMapping("/upload")
	public String index()
	{
		return "upload";
	}
	
	@GetMapping("/uploadResult")
	public String uploadStatus()
	{
		return "uploadresult";
	}
	
	@PostMapping("/file_upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
	{
		if (file.isEmpty())
		{
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadResult";
		}
		try
		{
			String path = saveFile(file);
			redirectAttributes.addFlashAttribute("message", "Successfully uploaded '" + file.getOriginalFilename() + "'");
			redirectAttributes.addFlashAttribute("path", "file path url : " + path);
		}
		catch (Exception e)
		{
			log.error("upload file failed", e);
		}
		return "redirect:/uploadResult";
	}
	
	private String saveFile(MultipartFile multipartFile) throws IOException
	{
		String[] fileAbsolutePath = {};
		String fileName = multipartFile.getOriginalFilename();
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		byte[] file_buff = null;
		InputStream inputStream = multipartFile.getInputStream();
		if (inputStream != null)
		{
			int len1 = inputStream.available();
			file_buff = new byte[len1];
			inputStream.read(file_buff);
		}
		inputStream.close();
		FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
		try
		{
			// upload to fastdfs
			fileAbsolutePath = FastDFSClient.upload(file);
		}
		catch (Exception e)
		{
			log.error("upload file Exception", e);
		}
		if (fileAbsolutePath == null)
		{
			log.error("upload file failed, please upload again");
		}
		String path = FastDFSClient.getTrackerUrl() + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
		return path;
	}
}
