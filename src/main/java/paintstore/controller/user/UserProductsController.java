package paintstore.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	
	@RequestMapping(value = { "products/{id}" }) public ModelAndView
	 products(@PathVariable String id) { ModelAndView mav = new
	 ModelAndView("user/user-products"); mav.addObject("product",
	 userProductsServiceImpl.getProductsByMDM(id)); mav.addObject("category",
	 userHomeServiceImpl.getCategory()); 
	 return mav; 
	 }
	 
	 
	
	@GetMapping("products/{id}")
	public ModelAndView paging(@PathVariable String id, @RequestParam("p") Optional<Integer> p) {
		int pageNumber = p.orElse(0);
		Pageable pageable = new PageRequest(pageNumber, 6);
		ModelAndView mav = new ModelAndView("user/user-products");
		List<Product> productList = userProductsServiceImpl.getProductsByMDM(id);
		List<Product> productsOnPage = getProductListForPage(productList, pageable);
		Page<Product> page = new PageImpl<>(productsOnPage, pageable, productList.size());
		mav.addObject("product", page);
		mav.addObject("id", id);
		mav.addObject("category", userHomeServiceImpl.getCategory());
		return mav;
	}
	
	@RequestMapping("products")
	public ModelAndView products(@RequestParam("sortType") Optional<String> sortType, @RequestParam("p") Optional<Integer> p) {
	    int pageNumber = p.orElse(0);
	    Pageable pageable = new PageRequest(pageNumber, 6);
	    
	    String sort = sortType.orElse("name-asc"); // Mặc định sắp xếp theo tên A-Z

	    ModelAndView mav = new ModelAndView("user/user-products");
	    Page<Product> page;

	    if (sort.equals("price-asc")) {
	        page = userProductsServiceImpl.getProductsOrderByPriceAsc(pageable);
	    } else if (sort.equals("price-desc")) {
	        page = userProductsServiceImpl.getProductsOrderByPriceDesc(pageable);
	    } else if (sort.equals("name-asc")) {
	        page = userProductsServiceImpl.getProductsOrderByNameAsc(pageable);
	    } else if (sort.equals("name-desc")) {
	        page = userProductsServiceImpl.getProductsOrderByNameDesc(pageable);
	    } else {
	        // Xử lý mặc định nếu giá trị sortType không hợp lệ
	    	List<Product> productList = userProductsServiceImpl.getProducts();
			List<Product> productsOnPage = getProductListForPage(productList, pageable);
			page = new PageImpl<>(productsOnPage, pageable, productList.size());
	    }

	    mav.addObject("product", page);
	    mav.addObject("category", userHomeServiceImpl.getCategory());

	    return mav;
	}
	
	private List<Product> getProductListForPage(List<Product> allProducts, Pageable pageable) {
	    int start = (int) pageable.getOffset();
	    int end = Math.min((start + pageable.getPageSize()), allProducts.size());
	    return allProducts.subList(start, end);
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
