
package paintstore.controller.user;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.dto.MyUser;
import paintstore.entity.Account;
import paintstore.entity.User;
import paintstore.service.AccountService;
import paintstore.service.UserService;
import paintstore.service.user.Impl.UserHomeServiceImpl;

@Controller
@RequestMapping("user/")
public class UserProfileController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	UserHomeServiceImpl userHomeServiceImpl;
	
	@Autowired
	UserService userService;

	@GetMapping("profile")
	public ModelAndView profile(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("user/user-profile");
		mav.addObject("category", userHomeServiceImpl.getCategory());
		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		
		mav.addObject("account", account);
		mav.addObject("userInfor", account.getUser());
		return mav;
	}
	
	@PostMapping("updateProfile")
	public ModelAndView updateProfile(@ModelAttribute("userInfor") User user, @RequestParam(name ="userId") String ids) {
		ModelAndView mav = new ModelAndView();
		System.out.println(ids);
		user.setId(ids);
		Account account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		user.setAccount(account);
		
		userService.updateUser(user);

		String message = "";
		
		
		mav.addObject("userInfor", account.getUser());

		mav.addObject("account", account);
		
		mav.setViewName("redirect:/user/profile");
		mav.addObject("mess","Cập nhật thành công");
		
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
