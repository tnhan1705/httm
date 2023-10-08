
package paintstore.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.dto.MyUser;
import paintstore.entity.Account;
import paintstore.entity.Product;
import paintstore.entity.User;
import paintstore.repository.user.UserHomeCategoryRepositoy;
import paintstore.service.AccountService;
import paintstore.service.UserService;
import paintstore.service.user.UserProductsService;
import paintstore.service.user.Impl.UserHomeServiceImpl;
import paintstore.service.user.Impl.UserProductsServiceImpl;

@Controller
@RequestMapping("/user/")
public class UserHomeController {

	@Autowired
	UserHomeServiceImpl userHomeServiceImpl;

	@Autowired
	UserProductsServiceImpl userProductsServiceImpl;

	@Autowired
	AccountService accountService;

	@Autowired
	UserService userService;

	@Autowired
	UserProductsService userProductsService;

	@RequestMapping("home")
	public ModelAndView home(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("user/user-home");
		mav.addObject("slide", userHomeServiceImpl.getProductSlide());
		mav.addObject("category", userHomeServiceImpl.getCategory());
		mav.addObject("product", userProductsServiceImpl.getProducts());
		return mav;
	}

	// Search
	@GetMapping("/search")
	public ModelAndView search(@RequestParam("keyword") String keyword, Model model) {
		ModelAndView mav = new ModelAndView("user/user-products");
		List<Product> productList = userProductsService.searchProductByName(keyword);
		mav.addObject("product", productList);
		mav.addObject("category", userHomeServiceImpl.getCategory());
		return mav;
	}

	// Sort
	@GetMapping("/price")
	public ModelAndView getProductsBySortType(@RequestParam("sortType") String sortType, Model model) {
		List<Product> products = new ArrayList<>();
		if (sortType.equals("price-asc")) {
			products = userProductsServiceImpl.getProductsOrderByPriceAsc();
		} else if (sortType.equals("price-desc")) {
			products = userProductsServiceImpl.getProductsOrderByPriceDesc();
		} else if (sortType.equals("name-asc")) {
			products = userProductsServiceImpl.getProductsOrderByNameAsc();
		} else if (sortType.equals("name-desc")) {
			products = userProductsServiceImpl.getProductsOrderByNameDesc();
		}

		ModelAndView mv = new ModelAndView("user/product");
		mv.addObject("product", products);
		return mv;
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
