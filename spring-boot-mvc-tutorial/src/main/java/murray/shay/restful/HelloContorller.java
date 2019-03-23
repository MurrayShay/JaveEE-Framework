package murray.shay.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 解說：@RestController ＝ .@Contorller + .@ResponseBody，預設是用來回覆json/xml。
 * 如果要返回JSP試圖需要使用ModelAndView。
 *  
 * @author murray.
 */
@RestController
@RequestMapping(value="/contorller")
public class HelloContorller {

	@RequestMapping(value="/hello")
	public String hello() {
		return "Hellow I am Controller";
	}
	
	@RequestMapping(value="/hello4")
	public ModelAndView hello4() {
		return new ModelAndView("hello");
	}
}
