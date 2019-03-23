package murray.shay.directexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "murray.shay.directexchange", "murray.shay.fanoutexchange",
		"murray.shay.topicexchange" })
@SpringBootApplication
public class Application {

	/**
	 * Spring boot main. s
	 * 
	 * @param args args.
	 */
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
