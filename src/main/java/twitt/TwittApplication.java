package twitt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;

import twitt.confiuration.PictureUploadProperties;


@SpringBootApplication
@EnableConfigurationProperties({PictureUploadProperties.class})
@EnableCaching
public class TwittApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwittApplication.class, args);
	}
}
