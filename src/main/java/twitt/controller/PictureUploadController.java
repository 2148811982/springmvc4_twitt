package twitt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.NestedServletException;
import org.springframework.web.util.WebUtils;

import twitt.confiuration.PictureUploadProperties;

@Controller
@RequestMapping("picture")
@SessionAttributes("picturePath")
public class PictureUploadController {

	private static final Resource PICTURES_DIR = new FileSystemResource("./pictures");
	private final MessageSource messageSource;
	
	private final Resource pictureDir;
	private final Resource anonymousPicture;
	
	@Autowired
	public PictureUploadController(PictureUploadProperties pro, MessageSource messageSource) {
		pictureDir = pro.getUploadPath();
		anonymousPicture = pro.getAnonymousPicture();
		this.messageSource = messageSource;
	}

	@RequestMapping("upload")
	public String uploadPage() {
		return "profile/uploadPage";
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String onUpload(MultipartFile file, RedirectAttributes redirectAttributes, Model model) throws IOException {
		
//		throw new IOException("test exception");
		
		
		if(file.isEmpty() || !isImageFile(file)) {
			redirectAttributes.addFlashAttribute("error","Incorrect file.Please upload a picture");
			return "redirect:/picture/upload";
		}
		
		Resource picturePath = copyFileToPictures(file);
		model.addAttribute("picturePath", picturePath);
		
		return "profile/uploadPage";
	}
	
	@RequestMapping("uploadedPicture")
	public void getUploadedPicture(HttpServletResponse res, @ModelAttribute("picturePath") Resource anonymousPicture) throws IOException {
//		ClassPathResource cpr = new ClassPathResource("/images/springboot.jpg");
		res.setHeader("Content-Type", URLConnection.guessContentTypeFromName(anonymousPicture.getFilename()));
		IOUtils.copy(anonymousPicture.getInputStream(), res.getOutputStream());
//		Files.copy(picturePath, res.getOutputStream());
	}
	
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(/*FileUploadException exception*/ Locale locale) {
		ModelAndView mav = new ModelAndView("profile/uploadPage");
//		mav.addObject("error",exception.getMessage());
		mav.addObject("error", messageSource.getMessage("upload.io.exception", null,locale));
		return mav;
	}
	
	@RequestMapping("uploadError")
	public ModelAndView onUploadError(/*HttpServletRequest req*/ Locale locale) {
		ModelAndView mav = new ModelAndView("profile/uploadPage");
//		mav.addObject("error",req.getAttribute(WebUtils.ERROR_MESSAGE_ATTRIBUTE));
		mav.addObject("erorr", messageSource.getMessage("upload.file.too.big",null, locale));
		return mav;
	}
	
	@ModelAttribute("picturePath")
	public Resource picturePath() {
		return anonymousPicture;
	}
	
	
	private String getFileExtention(String name) {
		return name.substring(name.lastIndexOf("."));
	}
	
	private boolean isImageFile(MultipartFile file) {
		return file.getContentType().startsWith("image");
	}
	
	/**
	 * 将浏览器选择的文件上传至./pictures
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private Resource copyFileToPictures(MultipartFile file) throws IOException {
		String fileExtension = getFileExtention(file.getOriginalFilename());
		File tempFile = File.createTempFile("pic", fileExtension, pictureDir.getFile());
		try (InputStream in = file.getInputStream();OutputStream out = new FileOutputStream(tempFile)) {
			IOUtils.copy(in, out);
		}
		
		return new FileSystemResource(tempFile);
	}
}
