package co.jers.base.backendproyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BackendproyectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendproyectApplication.class, args);
	}

}
