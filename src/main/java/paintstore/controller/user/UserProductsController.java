package paintstore.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.dto.MyUser;
import paintstore.entity.Account;
import paintstore.entity.Product;
import paintstore.service.AccountService;
import paintstore.service.user.UserProductsService;
import paintstore.service.user.Impl.UserHomeServiceImpl;
import paintstore.service.user.Impl.UserProductsServiceImpl;

@Controller
@RequestMapping("/user/")
public class UserProductsController {
	
	@Autowired
	UserHomeServiceImpl userHomeServiceImpl;
	
	@Autowired
	UserProductsServiceImpl userProductsServiceImpl;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = {"products/{id}"})
	public ModelAndView products(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("user/user-products");
		mav.addObject("product", userProductsServiceImpl.getProductsByMDM(id));
		mav.addObject("category", userHomeServiceImpl.getCategory());
		return mav;
	}
	
	@RequestMapping("products/sort")
	public ModelAndView productsSort(@RequestParam("sortType") String sortType) {
		ModelAndView mav = new ModelAndView("user/user-products");
		mav.addObject("category", userHomeServiceImpl.getCategory());
		
		String mess = "NO";
		System.out.println("aaaaa");
		List<Product> product = new ArrayList<>();
		if (sortType.equals("price-asc")) {
			mess = "Oke";
			product = userProductsServiceImpl.getProductsOrderByPriceAsc();
		} else if (sortType.equals("price-desc")) {
			mess = "Oke";
			product = userProductsServiceImpl.getProductsOrderByPriceDesc();
		} else if (sortType.equals("name-asc")) {
			mess = "Oke";
			product = userProductsServiceImpl.getProductsOrderByNameAsc();
		} else if (sortType.equals("name-desc")) {
			mess = "Oke";
			product = userProductsServiceImpl.getProductsOrderByNameDesc();
		}
		mav.addObject("mess", mess);
		mav.addObject("product", product);
		
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
