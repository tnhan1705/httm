package paintstore.controller.admin;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import paintstore.service.AccountService;
import paintstore.service.OrderDetailService;
import paintstore.service.OrderService;
import paintstore.service.ProductService;
import paintstore.service.SeriService;
import paintstore.service.StaffService;
import paintstore.Utils.SecurityUtils;
import paintstore.entity.*;
import paintstore.repository.OrderRepository;
import paintstore.repository.ProductPepository;


@Controller

@RequestMapping("/admin")

public class AdminOrderController {	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private StaffService staffService ;
	
	@Autowired
	private OrderRepository oderRepository;
	
	@Autowired
	private ProductPepository productRepository;
	
	@Autowired
	private SeriService seriService;
	
	@RequestMapping("order/list")
	public ModelAndView listOrder() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/order/list-order");
		List<Order> listOrder = orderService.getListOrder();
		mav.addObject("listOrder", listOrder);
		return mav;
	}
	
	@RequestMapping("order/detail")
	public ModelAndView orderDetail(@RequestParam("idc") String idc) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/order/detail-order");
		
		List<OrderDetail> listOrderDetail = orderDetailService.getOrderDetailsByOrderId(idc);
		mav.addObject("listOrderDetail", listOrderDetail);
		
		Order order = orderService.getOrderById(idc);
		mav.addObject("order", order);
		return mav;
	}
	@GetMapping("order/delete")
	public ModelAndView deteleOrder(@RequestParam("ido") String ido) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/admin/order/list");
		
		Order order = orderService.getOrderById(ido);
		order.setStatus("Đã hủy");
		oderRepository.save(order);
		return mav;
	}
	@GetMapping("order/confirm")
	public ModelAndView confirmOrder(@RequestParam("ido") String ido) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/admin/order/list");
		Order order = orderService.getOrderById(ido);
		order.setStatus("Đã Xác Nhận");
		List<OrderDetail> listOrderDetail = orderDetailService.getOrderDetailsByOrderId(ido);
		for (OrderDetail orderDetail : listOrderDetail) {
            Product product = orderDetail.getProduct();
            int orderedQuantity = orderDetail.getQuantity();
            int currentInventory = product.getNumber();
            
            for(int i =0;i<orderedQuantity;i++) {
            	Seri seri= seriService.findOneByProduct_IdAndColorAndStatus(product.getId(), orderDetail.getColor(),true);    
            	seri.setStatus(false);
            	seriService.save(seri);
            }
            
            if (currentInventory >= orderedQuantity) {
                int newInventory = currentInventory - orderedQuantity;
                product.setNumber(newInventory);
                productRepository.save(product);
            } else {
                // Handle insufficient inventory here (e.g., throw an exception)
            }
        }
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staffs = staffService.findOneByAccount(account);
		order.setStaff(staffs);
		oderRepository.save(order);
		return mav;
	}
	
//	@RequestMapping("order/confirm")
//	public ModelAndView confirmDetail(@RequestParam("ido") String ido ,@RequestParam(value = "status",required = false) String status) {
//		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
//	
//		Staffs staff = staffService.findOneByAccount(account);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:/admin/order/list");
//		Long number = Long.valueOf(ido);
//		Order order = orderService.findOneById(number);
	
//		if (status!=null) {
//			order.setStatus("Đã Bị Hủy");
//		}
//		else
//		{
//			order.setStatus("Đã Xác Nhận");
//		}
		
//		order.setStaff(staff);
//		orderService.save(order);
//		return mav;
	//}
	
//	@RequestMapping("order/ship")
//	public ModelAndView orrderShip(@RequestParam("ido") String ido) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:/admin/order/list");
//		Long number = Long.valueOf(ido);
//		Order order = orderService.findOneById(number);
		
//		order.setStatus("Đã Giao Cho Đơn Vị Vận Chuyển");
		
//		orderService.save(order);
//		return mav;
//	}
	
	
	
//	@ModelAttribute("staff")
//	public Staffs getStaff() {
//		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
//		Staffs staff = staffService.findOneByAccount(account);
//		return staff;
//	}
}
