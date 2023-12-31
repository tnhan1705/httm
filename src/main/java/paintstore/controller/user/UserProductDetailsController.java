package paintstore.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.dto.MyUser;
import paintstore.entity.Account;
import paintstore.entity.Seri;
import paintstore.service.AccountService;
import paintstore.service.user.UserSeriService;
import paintstore.service.user.Impl.UserHomeServiceImpl;
import paintstore.service.user.Impl.UserProductDetailsServiceImpl;
import paintstore.service.user.Impl.UserSeriServiceImpl;

@Controller
@RequestMapping("/user/")
public class UserProductDetailsController {

	@Autowired
	UserHomeServiceImpl userHomeServiceImpl;

	@Autowired
	UserProductDetailsServiceImpl userProductDetailsServiceImpl;

	@Autowired
	UserSeriServiceImpl userSeriServiceImpl;

	@Autowired
	AccountService accountService;

	@RequestMapping("product-details/{id}")
	public ModelAndView productDetails(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("user/user-product-details");
		mav.addObject("productDetails", userProductDetailsServiceImpl.getProductDetails(id));
		mav.addObject("productSeries", userSeriServiceImpl.getAllSeriByProduct(id));
		mav.addObject("category", userHomeServiceImpl.getCategory());
		
		List<Seri> listSeri = userSeriServiceImpl.findAllByProduct_IdAndStatus(id, true);
		Map<String, Integer> mp= new HashMap<>();
		for (Seri seri : listSeri) {
			String color = seri.getColor();
			mp.put(color,mp.getOrDefault(color, 0)+ 1);
		}
		mav.addObject("numberAndQuantity", mp);
		mav.addObject("initialQuantity", listSeri.size());
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
