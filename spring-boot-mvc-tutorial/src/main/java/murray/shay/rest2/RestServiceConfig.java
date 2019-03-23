package murray.shay.rest2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages="murray.shay.rest2")
@EnableWebMvc //全面接管
public class RestServiceConfig {

}
