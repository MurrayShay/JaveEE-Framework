package murray.shay.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import murray.shay.rest2.RestServiceConfig;

/**
 * SpringBootServletInitializer用于替代传统mvc模式中的web.xml。
 * 如果你要使用外部的servlet容器，例如tomcat，就需要继承该类并重写configure方法。
 * 
 * 解說:@SpringBootApplication(exclude= {DispatcherServletAutoConfiguration.class,ErrorMvcAutoConfiguration.class})
 * 以上這行可以關閉自動配置的 DispatcherServlet /
 * 可參考 https://stackoverflow.com/questions/30670327/spring-boot-with-multiple-dispatcherservlet-each-having-their-own-controllers
 * 
 * 解說:@EnableWebMvc，感覺起來相當於以前的springmvc-config.xml，全面佔領且application.yaml的spring.mvc以下都失效。
 * @author murray.
 */

@ComponentScan
@SpringBootApplication
@ComponentScan(basePackages = "murray.shay.restful")  //自動配置DispatcherServlet用的。
@ServletComponentScan(basePackages = "murray.shay.servlet")
public class Application extends SpringBootServletInitializer {

	/**
	 * Spring boot main.
	 * 
	 * @param args args.
	 */
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	/**
	 * 自定義的Dispatcher.
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<DispatcherServlet> restService() {
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(RestServiceConfig.class);
		dispatcherServlet.setApplicationContext(applicationContext);
		ServletRegistrationBean<DispatcherServlet> servletRegistrationBean = new ServletRegistrationBean<DispatcherServlet>(dispatcherServlet, "/service/*");
		servletRegistrationBean.setName("customerSerive");
		servletRegistrationBean.setLoadOnStartup(0);
		return servletRegistrationBean;
	}

}
