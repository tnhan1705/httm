
package paintstore.controller.user;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.dto.MyUser;
import paintstore.entity.Account;
import paintstore.entity.Product;
import paintstore.entity.Seri;
import paintstore.entity.User;
import paintstore.repository.user.UserHomeCategoryRepositoy;
import paintstore.service.AccountService;
import paintstore.service.UserService;
import paintstore.service.user.UserProductsService;
import paintstore.service.user.UserSeriService;
import paintstore.service.user.Impl.UserHomeServiceImpl;
import paintstore.service.user.Impl.UserProductsServiceImpl;
import paintstore.service.user.Impl.UserSeriServiceImpl;

import java.net.URLEncoder;

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
	
	@Autowired
	UserSeriServiceImpl userSeriServiceImpl; 

	
	@RequestMapping("home")
	public ModelAndView home(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("user/user-home");
		mav.addObject("slide", userHomeServiceImpl.getProductSlide());
		mav.addObject("category", userHomeServiceImpl.getCategory());
		mav.addObject("product", userProductsServiceImpl.getProducts());
		return mav;
	}
	 

	@GetMapping("home")
	public ModelAndView paging(@RequestParam("p") Optional<Integer> p) {
		int pageNumber = p.orElse(0);
		Pageable pageable = new PageRequest(pageNumber, 5);
		ModelAndView mav = new ModelAndView("user/user-home");
		List<Product> productList = userProductsServiceImpl.getProducts();
		List<Product> productsOnPage = getProductListForPage(productList, pageable);
		Page<Product> page = new PageImpl<>(productsOnPage, pageable, productList.size());
		mav.addObject("slide", userHomeServiceImpl.getProductSlide());
		mav.addObject("product", page);
		mav.addObject("category", userHomeServiceImpl.getCategory());
		return mav;
	}
	
	private List<Product> getProductListForPage(List<Product> allProducts, Pageable pageable) {
	    int start = (int) pageable.getOffset();
	    int end = Math.min((start + pageable.getPageSize()), allProducts.size());
	    return allProducts.subList(start, end);
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
	
	// Advise
	@GetMapping("/advise")
	public ModelAndView advise(@RequestParam(name = "keyword") String keyword, Model model) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("user/user-products");
		RestTemplate restTemplate = new RestTemplate();
        String pythonServiceUrl = "http://localhost:5000/GetAdvise"; // Replace with the actual Python service URL
        // Encode the keyword as UTF-8
        byte[] keywordBytes = keyword.getBytes("UTF-8");
        String result = restTemplate.postForObject(pythonServiceUrl, keywordBytes, String.class);
        byte[] utf8Bytes = result.getBytes("UTF-8");
        String decodedText = new String(utf8Bytes, StandardCharsets.UTF_8);
        mav.addObject("ResultAdvise", decodedText);
        List<Seri> listSeri = userSeriServiceImpl.getAllSeriByColor(decodedText);
        // Sử dụng HashSet để loại bỏ các MSP trùng nhau
        HashSet<String> seenMSP = new HashSet<>();
        List<Seri> uniqueList = new ArrayList<>();
        
        for (Seri obj : listSeri) {
            if (seenMSP.add(obj.getProduct().getId())) {
                uniqueList.add(obj);
            }
        }
        List<Product> listProduct = new ArrayList<Product>();
        for (Seri seri : uniqueList) {
			listProduct.addAll(userProductsServiceImpl.getProductsByMSP(seri.getProduct().getId()));
		}
        mav.addObject("product", listProduct);
		return mav;
	}

	// Sort
	/*
	 * @GetMapping("/price") public ModelAndView
	 * getProductsBySortType(@RequestParam("sortType") String sortType, Model model)
	 * { List<Product> products = new ArrayList<>(); if
	 * (sortType.equals("price-asc")) { products =
	 * userProductsServiceImpl.getProductsOrderByPriceAsc(); } else if
	 * (sortType.equals("price-desc")) { products =
	 * userProductsServiceImpl.getProductsOrderByPriceDesc(); } else if
	 * (sortType.equals("name-asc")) { products =
	 * userProductsServiceImpl.getProductsOrderByNameAsc(); } else if
	 * (sortType.equals("name-desc")) { products =
	 * userProductsServiceImpl.getProductsOrderByNameDesc(); }
	 * 
	 * ModelAndView mv = new ModelAndView("user/product"); mv.addObject("product",
	 * products); return mv; }
	 */

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
