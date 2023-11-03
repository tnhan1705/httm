package paintstore.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.entity.Account;
import paintstore.entity.Staffs;
import paintstore.entity.User;
import paintstore.service.AccountService;
import paintstore.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired 
	AccountService accountService;
	
	@Autowired 
	UserService userService;
	
	@RequestMapping("/users/list")
	public ModelAndView listStaff() {
		ModelAndView mav = new ModelAndView();
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		
		mav.setViewName("/admin/users/list_user");
		List<User> users = userService.findAllByStatus(true);
		mav.addObject("listUser", users);
		
		return mav;
	}
	
	@RequestMapping("/users/delete")
	public ModelAndView deleteUser(@RequestParam("usernameac") String username) {
		ModelAndView mav = new ModelAndView();
		userService.deleteUser(username);
		mav.setViewName("redirect:/admin/staff/list");
		return mav;
	}
}
