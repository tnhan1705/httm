package paintstore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.entity.Account;
import paintstore.entity.Staffs;
import paintstore.service.AccountService;
import paintstore.service.StaffService;



@Controller
@RequestMapping("/admin/")
public class HomeController {
	
	
	@GetMapping("home")
	public ModelAndView home(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("admin/admin-home");
		return mav;
	}
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private AccountService accountService;
	
	@ModelAttribute("staff")
	public Staffs getStaff() {
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staff = staffService.findOneByAccount(account);
		return staff;
	}
}
