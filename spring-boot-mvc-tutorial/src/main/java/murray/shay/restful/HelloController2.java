package murray.shay.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 解說：@Controller預設是返回視圖用的，如果要返回Body要加上@ResponseBody。
 * 
 * @author murray.
 */
@Controller
@RequestMapping(value = "/contorller2")
public class HelloController2 {

	@RequestMapping(value = "/hello2")
	public @ResponseBody String hello2() {
		return "Hellow I am Controller2";
	}

	@RequestMapping(value = "/hello3")
	public String helloJsp() {
		return "hello";
	}

}
