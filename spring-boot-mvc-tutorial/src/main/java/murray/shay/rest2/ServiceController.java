package murray.shay.rest2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/servicecontorller")
public class ServiceController {
	@RequestMapping(value = "/servicehello")
	public String serviceHello() {
		return "Hello I am Service Controller";
	}
	
	@RequestMapping(value="/servicehello2")
	public ModelAndView servicehello2() {
		return new ModelAndView("hello");
	}
}
