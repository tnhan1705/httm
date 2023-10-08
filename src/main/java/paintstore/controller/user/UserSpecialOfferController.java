package paintstore.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.dto.MyUser;
import paintstore.service.user.Impl.UserHomeServiceImpl;

@Controller
@RequestMapping("/user/")
public class UserSpecialOfferController {
	
	@Autowired
	UserHomeServiceImpl userHomeServiceImpl;
	
	@RequestMapping("special-offer")
	public ModelAndView specialOffer(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("user/user-special-offer");
		mav.addObject("category", userHomeServiceImpl.getCategory());
		return mav;
	}
}
