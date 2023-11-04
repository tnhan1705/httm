package paintstore.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import aj.org.objectweb.asm.Type;
import paintstore.Utils.RandomStringGenerator;
import paintstore.Utils.SecurityUtils;
import paintstore.entity.Account;
import paintstore.entity.Product;
import paintstore.entity.Receipt;
import paintstore.entity.ReceiptDetail;
import paintstore.entity.Seri;
import paintstore.entity.Staffs;
import paintstore.repository.ProductPepository;
import paintstore.repository.ReceiptDetailRepository;
import paintstore.repository.ReceiptRepository;
import paintstore.service.AccountService;
import paintstore.service.ProductService;
import paintstore.service.ReceiptService;
import paintstore.service.SeriService;
import paintstore.service.StaffService;

@Controller
@RequestMapping("/admin/")
public class AdminReceiptDetailController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReceiptService receiptService;
	
	@Autowired
	private ReceiptDetailRepository receiptDetailRepository;
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired 
	private ProductPepository productPepository;
	
	@Autowired
	private SeriService seriService;
	
	@GetMapping("receipt-detail/list")
	public ModelAndView getListReceiptDetail(@RequestParam("idr") String idr) {
		
		ModelAndView mav = new ModelAndView();
		List<ReceiptDetail> listReceiptDetail = receiptDetailRepository.findAllById_Receipt(idr);
		mav.addObject("listReceiptDetail", listReceiptDetail);
		float sum = 0;
		for (ReceiptDetail receiptDetail : listReceiptDetail) {
			sum += receiptDetail.getQuantity() * receiptDetail.getPrice();
		}
		mav.addObject("sum", sum);
		Receipt receipt = receiptService.findById(idr);
		mav.addObject("receipt", receipt);
		
		
		
		
		for (ReceiptDetail receiptDetail : listReceiptDetail) {
			List<Seri> seris = seriService.findAllByReceipt_IdAndProduct_Id(idr, receiptDetail.getProduct().getId());
					
			Map<String, Integer> mp = new HashMap<>();
			for (Seri seri : seris) {
				String color = seri.getColor();
				mp.put(color,mp.getOrDefault(color, 0)+ 1);
				
			}
			mav.addObject("ColorAndQuantity"+receiptDetail.getProduct().getId(), mp);
			
		}
		
		mav.setViewName("admin/receipt/receipt-detail/list-receiptdetail");
		return mav;
		
	}
	
	@GetMapping("receipt-detail/confirmz")
	public ModelAndView confirmReceiptDetail(@RequestParam("idr") String idr , @RequestParam(value = "status",required = false) String status) {
		ModelAndView mav = new ModelAndView();
		
		Receipt receipt = receiptService.findById(idr);
		if (status == null) {
			receipt.setStatus(1);// 1 đã xác nhận
		}
		else
		{
			receipt.setStatus(2);// 2 đã hủy
		}
		
		receiptRepository.save(receipt);
		
		mav.setViewName("redirect:/admin/receipt/list");
		return mav;
	}
	
	@GetMapping("receipt-detail/quantity")
	public ModelAndView getQuantityRcDl(@RequestParam("idr") String idr) {
		ModelAndView mav = new ModelAndView("/admin/receipt/quantityRcDl");
		mav.addObject("idr", idr);
		return mav;
	}
	
	@PostMapping("receipt-detail/quantity")
	public ModelAndView setUpQuantityRcDl(@RequestParam("idr") String idr,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/receipt/quantityRcDl");
		String quantityRcDl = request.getParameter("quantityRcDl");
		mav.addObject("idr", idr);
		int quantity = Integer.valueOf(quantityRcDl);
		if (quantity < 0) {
			mav.setViewName("/admin/receipt/quantityRcDl");
		}else {
			Receipt receipt = new Receipt();
			List<ReceiptDetail> listReceiptDetail = new ArrayList<>();
			mav.setViewName("/admin/receipt/receipt-detail/create-receiptdetail");
			for (int i = 0; i<quantity ; i++) {
				ReceiptDetail receiptDetail = new ReceiptDetail();
				receiptDetail.setPrice(0);
				receiptDetail.setQuantity(0);
				listReceiptDetail.add(receiptDetail);
			}
			
			receipt.setListReceiptDetail(listReceiptDetail);
			receipt.setId(idr);
			mav.addObject("chiTietPhieuNhap", receipt);
			
		}
		return mav;
		
	}
	
	@PostMapping("receipt-detail/create")
	public ModelAndView viewCreateReceiptDetail(@ModelAttribute("chiTietPhieuNhap") Receipt receipt ,@RequestParam("idr") 
	String idr) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/receipt/receipt-detail/create-receiptdetail");
		receipt.setId(idr);
		receiptService.save(receipt);
		
		List<ReceiptDetail> receiptDetails = receipt.getListReceiptDetail();
		
		float sum = 0;
		for (ReceiptDetail receiptDetail : receiptDetails) {
			sum += receiptDetail.getQuantity() * receiptDetail.getPrice();
		}
		mav.addObject("sum", sum);
		return mav;
	}
	
	@GetMapping("receipt-detail/addSeri")
	public ModelAndView addSeri(@RequestParam("idp") String idp,@RequestParam("idr") String idr) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/receipt/receipt-detail/add-seri");
		Product product = productService.getProductById(idp);
		ReceiptDetail receiptDetail = receiptDetailRepository.findOneById_ReceiptAndId_Product(idr, idp);
		List<Seri> listSeri = new ArrayList<>();
		for (int i = 0; i < receiptDetail.getQuantity(); i++) {
			Seri seri = new Seri();
			seri.setId(RandomStringGenerator.generateRandomString(10));
			listSeri.add(seri);
		}
		product.setListSeri(listSeri);
		mav.addObject("listSeri", listSeri);
		mav.addObject("product", product);
		mav.addObject("idp", idp);
		mav.addObject("idr", idr);
		return mav;
	}
	
	@PostMapping("receipt-detail/addSeri")
	public ModelAndView addSeri_save(@ModelAttribute("product") Product product,@RequestParam("idp") String idp,@RequestParam(value = "seriIds",required = false ) List<String> seriIds,@RequestParam("idr") String idr ) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/receipt/receipt-detail/add-seri");
		Product product1 = productService.getProductById(idp);
		Receipt receipt = receiptService.findById(idr);
		List<Seri> seris = new ArrayList<>();
		int index =0;
		for (String seriId : seriIds) {
			Seri seri = new Seri();
			seri.setId(seriId);
			seri.setProduct(product1);
			seri.setReceipt(receipt);
			seri.setStatus(true);
			seri.setColor(product.getListSeri().get(index).getColor());
			index = index +1;
			seris.add(seri);
	    }
		product1.setListSeri(seris);
		productPepository.save(product1);
		
		return mav;
	}
	
	@ModelAttribute("products")
	public List<Product> getlistProduct(){
		List<Product> listProduct = productService.getListProduct();
		return listProduct;
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
