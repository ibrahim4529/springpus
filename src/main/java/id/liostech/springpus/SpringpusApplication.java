package id.liostech.springpus;

import id.liostech.springpus.config.StorageProperties;
import id.liostech.springpus.services.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringpusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringpusApplication.class, args);
	}

	@Bean
	CommandLineRunner init(FileService fileService) {
		return (args) -> {
			fileService.init();
		};
	}
}
