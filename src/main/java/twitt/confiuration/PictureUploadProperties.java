package twitt.confiuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:config.properties")
@ConfigurationProperties(prefix = "upload.pictures")
public class PictureUploadProperties {

	private Resource uploadPath;
	private Resource anonymousPicture;
	
	public Resource getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = new DefaultResourceLoader().getResource(uploadPath);
	}
	public Resource getAnonymousPicture() {
		return anonymousPicture;
	}
	public void setAnonymousPicture(String anonymousPicture) {
		this.anonymousPicture = new DefaultResourceLoader().getResource(anonymousPicture);
	}
	
	
}
	
