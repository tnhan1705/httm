package paintstore.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.entity.Account;
import paintstore.service.AccountService;
import paintstore.service.user.Impl.UserHomeServiceImpl;

@Controller
@RequestMapping("/user/")
public class UserContactController {
	
	@Autowired
	UserHomeServiceImpl userHomeServiceImpl;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping("contact")
	public ModelAndView contact(ModelMap model) {
		ModelAndView mav = new ModelAndView("user/user-contact");
		mav.addObject("category", userHomeServiceImpl.getCategory());
		return mav;
	}
	
	@ModelAttribute("checkLogin")
	public Account showAccount() {
		Account account = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication.getName().equals("anonymousUser"))) {
			account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
			
		}
		return account;
	}
}
