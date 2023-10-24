package paintstore.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import paintstore.service.user.Impl.UserHomeServiceImpl;

@Controller
@RequestMapping("/user/")
public class UserDeliveryController {
	
	@Autowired
	UserHomeServiceImpl userHomeServiceImpl;
	
	@RequestMapping("delivery")
	public ModelAndView delivery(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("user/user-delivery");
		mav.addObject("category", userHomeServiceImpl.getCategory());
		return mav;
	}
}

