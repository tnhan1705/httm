package paintstore.controller.user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.entity.Account;
import paintstore.entity.Order;
import paintstore.entity.OrderDetail;
import paintstore.entity.OrderDetailPk;
import paintstore.entity.Product;
import paintstore.entity.User;
import paintstore.repository.OrderDetailRepository;
import paintstore.repository.OrderRepository;
import paintstore.service.AccountService;
import paintstore.service.OrderDetailService;
import paintstore.service.OrderService;
import paintstore.service.UserService;
import paintstore.service.Impl.AccountServiceImpl;
import paintstore.service.Impl.ProductServiceImpt;
import paintstore.service.user.Impl.UserHomeServiceImpl;

@Controller
@RequestMapping("/user/")
public class UserOrderController {

	Date currentDate = new Date();

	@Autowired
	UserHomeServiceImpl userHomeServiceImpl;
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductServiceImpt productServiceImpt;
	
	@Autowired
	OrderDetailService orderDetailService; 
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	private String newOrderId;
	private String username;
	
	// Hiển thị ra giỏ hàng
	@RequestMapping("cart")
	public ModelAndView showOrder(HttpSession session) {
		ModelAndView mv = new ModelAndView("user/user-cart");
		mv.addObject("category", userHomeServiceImpl.getCategory());
		
		Account account = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication.getName().equals("anonymousUser"))) {
			account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		}
		
		if (account != null) {
			username = account.getUserName();
			Account account1 = accountServiceImpl.getAccountById(username);
			List<Order> lo = orderService.getOrderByUser(account1.getUser());
			
			int size = lo.size();
			String newOrderIdTemp = "0";
			Order order = new Order();
			User user = account1.getUser();
			// không có đơn đặt thì tạo mới
			if (size == 0) {
				User user1 = userService.getUserById(account1.getUser().getId());
				Long orderCount = orderRepository.countCartById();
				Long newCount = orderCount + 1;
		        String count = newCount.toString();
		        order.setId(count);
		        order.setUser(user1);
		        order.setDate(currentDate);
		        order.setAddress(account1.getUser().getAddress());
		        order.setStatus("Đang đặt hàng");
		        orderRepository.save(order);
		        newOrderId = count;
			}
			/*
			 * else if(newOrderId !=null) { newOrderIdTemp = newOrderId; }
			 */
			else {
				/*
				 * for(int k = 0; k<lo.size();k++) { Order foundOrder = lo.get(k); String idcart
				 * = foundOrder.getId(); if(k==lo.size()-1) { newOrderIdTemp = idcart; } }
				 */
				order = orderService.findOrderByStatus("Đang đặt hàng");
				if (order == null) {
					order = new Order();
					User user1 = userService.getUserById(user.getId());
					Long orderCount = orderRepository.countCartById();
					Long newCount = orderCount + 1;
			        String count = newCount.toString();
			        order.setId(count);
					order.setDate(currentDate); 
			        order.setAddress(user.getAddress());
			        order.setUser(user1);
			        order.setStatus("Đang đặt hàng");
			        orderRepository.save(order);
			        newOrderIdTemp = count;
				}
				else {
					newOrderIdTemp = order.getId();
				}
				newOrderId = newOrderIdTemp;
			}

		    mv.addObject("order", order);
			List<OrderDetail> listOrderDetail = orderDetailRepository.findByOrderId(newOrderIdTemp);
		    mv.addObject("listOrder", listOrderDetail);
		}
		else {
			return new ModelAndView("redirect:/login");
		}
		return mv;
	}
	
	@RequestMapping("/addProduct")
	public ModelAndView addOrder(HttpSession session, @RequestParam(name ="productId") String id
			, @RequestParam(name = "number") int number, @RequestParam(name = "selectedColor") String selectedColor) {
	    ModelAndView mv = new ModelAndView("user/user-cart");
	    mv.addObject("category", userHomeServiceImpl.getCategory());
	    Account account = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication.getName().equals("anonymousUser"))) {
			account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());

		}
		// Kiểm tra đã đăng nhập chưa. Nếu chưa thì chuyển sang đăng nhập
		if (account != null) {
			Account account1 = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		    Account account2 = accountServiceImpl.getAccountById(account1.getUserName());
		    User user = account2.getUser();
		    Order order;
		    List<Order> orders = orderService.getOrderByUser(user);
		    // Nếu chưa có order nào thì tạo mới
		    if (orders.isEmpty()) {
				order = new Order();
				User user1 = userService.getUserById(user.getId());
				Long orderCount = orderRepository.countCartById();
				Long newCount = orderCount + 1;
		        String count = newCount.toString();
		        order.setId(count);
		        order.setUser(user1);
		        order.setDate(currentDate);
		        order.setAddress(user.getAddress());
		        order.setStatus("Đang đặt hàng");
		        orderRepository.save(order);
		        newOrderId = count;
			} else {
				// Kiểm tra trạng thái của order có phải là Đang đặt hàng không
				order = orderService.findOrderByStatus("Đang đặt hàng");
				if (order == null) {
					order = new Order();
					User user1 = userService.getUserById(user.getId());
					Long orderCount = orderRepository.countCartById();
					Long newCount = orderCount + 1;
			        String count = newCount.toString();
			        order.setId(count);
					order.setDate(currentDate); 
			        order.setAddress(user.getAddress());
			        order.setUser(user1);
			        order.setStatus("Đang đặt hàng");
			        orderRepository.save(order);
			        newOrderId = count;
				}
				else {
					newOrderId = order.getId();
				}
			}
		    
		    username = account.getUserName();
		    Product product = productServiceImpt.getProductById(id);
		    mv.addObject("order", order);
		    
		    // Thêm vào orderDetail
		    OrderDetailPk ids = new OrderDetailPk(order.getId(), product.getId());
		    int productCount = 1;
		    
		    OrderDetail existingOrderProduct = orderDetailService.getOrderDetailById(ids);
		    if (existingOrderProduct != null) {
		        String message = "Sản phẩm đã tồn tại trong giỏ hàng.";
		        mv.addObject("message", message);
		    } else {
		        OrderDetail orderDetail = new OrderDetail(ids, number, selectedColor, product, order);
		        orderDetailService.save(orderDetail);
		    }
		    List<OrderDetail> listOrderDetail = orderDetailRepository.findByOrderId(order.getId());
		    mv.addObject("listOrder", listOrderDetail);
	    }
	    else 
	    {
	    	return new ModelAndView("redirect:/login");
	    }
	    return mv;
	}
	
	@RequestMapping("/orderDetermination")
	public ModelAndView orderDetermination(HttpSession session, @RequestParam(name ="orderId") String id) {
		ModelAndView mv = new ModelAndView("user/user-cart");
		mv.addObject("category", userHomeServiceImpl.getCategory());
		List<OrderDetail> listOrderDetail = orderDetailRepository.findByOrderId(id);
		if (listOrderDetail.size() == 0) {
			mv.addObject("message", "Chưa thêm sản phẩm vào giỏ hàng!");
		}
		else {
			Order order = orderRepository.findOneById(id);
			order.setStatus("chờ duyệt");
			orderRepository.save(order);
		}
		return mv;
	}
	
	@PostMapping("/removeProduct")
	public ModelAndView removeOrderDetail(@RequestParam("orderDetailId") String cartDetailId,
	                                      @RequestParam("productId") String productId) {

		Account account = accountServiceImpl.getAccountById(username);
		Order order = orderService.getOrderByUserAndIdOrder(account.getUser(),newOrderId);
		orderDetailService.deleteByProductIdAndCartId(productId, cartDetailId);
	    ModelAndView mv = new ModelAndView();
	    List<OrderDetail> listOrder = orderDetailRepository.findByOrderId(order.getId());
	    mv.addObject("listOrder", listOrder);
	    mv.setViewName("user/user-cart");
	    mv.addObject("category", userHomeServiceImpl.getCategory());
	    return mv;
	}
	
	@RequestMapping("historyCart")
	public ModelAndView historyCart() {
		ModelAndView mv = new ModelAndView("user/user-cart-history");
		mv.addObject("category", userHomeServiceImpl.getCategory());
		Account account = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication.getName().equals("anonymousUser"))) {
			account = accountService.getAccountById(SecurityUtils.getPrincipal().getUsername());
		}
		User user= account.getUser();
		List<Order> orderList = orderRepository.findAllByUser(user);
		mv.addObject("orderList", orderList);
		return mv;
	}
	
	@RequestMapping("cancelOrder")
	public ModelAndView cancelOrder(@RequestParam("orderId") String id) {
		ModelAndView mv = new ModelAndView("redirect:historyCart");
		mv.addObject("category", userHomeServiceImpl.getCategory());
		List<OrderDetail> listOrderDetail = orderDetailRepository.findByOrderId(id);
		if (listOrderDetail.size() == 0) {
			mv.addObject("message", "Chưa thêm sản phẩm vào giỏ hàng!");
		}
		else {
			Order order = orderRepository.findOneById(id);
			order.setStatus("đã huỷ");
			orderRepository.save(order);
		}
		return mv;
	}
	
	@RequestMapping("historyCartDetail")
	public ModelAndView historyCartDetail(@RequestParam("orderId") String id) {
		ModelAndView mv = new ModelAndView("user/user-cart-history-detail");
		mv.addObject("category", userHomeServiceImpl.getCategory());
		List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(id);
		mv.addObject("listOrder", orderDetailList);
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