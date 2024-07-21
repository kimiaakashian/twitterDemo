package ir.group_3_and_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "ir.group_3_and_4.repository")
public class TwitterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterDemoApplication.class, args);
	}

}
