
package paintstore.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import paintstore.entity.Account;
import paintstore.entity.User;
import paintstore.service.Impl.AccountServiceImpl;
import paintstore.service.user.Impl.UserHomeServiceImpl;
import paintstore.service.user.Impl.UserProductsServiceImpl;

@Controller

@RequestMapping("/user/")
public class UserLoginController {
	
	@Autowired
	private AccountServiceImpl accountImpl;

	@Autowired
	UserHomeServiceImpl userHomeServiceImpl;
	
	@RequestMapping(value = "login-register", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("user/user-login-register");
		mav.addObject("userAccount", new Account());
		mav.addObject("category", userHomeServiceImpl.getCategory());
		return mav;
	}

	/*
	 * @RequestMapping(value = "register", method = RequestMethod.GET) public
	 * ModelAndView register() { ModelAndView mav = new
	 * ModelAndView("user/user-register"); mav.addObject("userInfor", new User());
	 * mav.addObject("category", userHomeServiceImpl.getCategory()); return mav; }
	 */
	
	@RequestMapping(value = "login-register", method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("userAccount") Account account, @RequestParam("passwordConfirm") String paswordCf,BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView("user/user-login-register");
		
		mav.addObject("check", true);
		String message ="";
		
		if (account.getEmail() == "") {
			message = "Email không được để trống";
			mav.addObject("errorem", message);
			return mav;
		}
		
		if (account.getUserName() == "") {
			message = "Tài khoản không được để trống";
			mav.addObject("errorun", message);
			return mav;
		}
		
		if (account.getPassWord()== "") {
			message = "Mật khẩu không được để trống";
			mav.addObject("errorpw", message);
			return mav;
		}
		if (bindingResult.hasErrors()) {
	        message = "Đăng kí thất bại";
	        mav.addObject("message", message);

	        return mav;
	    }
		if ( !paswordCf.equals(account.getPassWord())) {
			mav.addObject("checkPassword", true);
			mav.addObject("error", "Xác thực mật khẩu thất bại");
			message = "Đăng kí thất bại";
			mav.addObject("message", message);
			return mav;
		}
		 message = "Đăng kí thành công";
		 mav.addObject("message", message);
		 
		 accountImpl.save(account);
			/*
			 * List<Account> accounts = new ArrayList<>(); accounts.add(account);
			 */
		 User user = new User();
		 user.setAccount(account);
		 
		 // lấy userRepository lưu user lại
		
		return mav;
	}
	
	/*
	 * @RequestMapping(value = "register", method = RequestMethod.POST) public
	 * ModelAndView creatIfor(@ModelAttribute("userInfor") User user) { ModelAndView
	 * mav = new ModelAndView("user/user-register"); return mav; }
	 */
}
