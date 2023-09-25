package paintstore.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import paintstore.Utils.SecurityUtils;
import paintstore.entity.Account;
import paintstore.entity.Product;
import paintstore.entity.Receipt;
import paintstore.entity.ReceiptDetail;
import paintstore.entity.Staffs;
import paintstore.entity.Supplier;
import paintstore.repository.ProductPepository;
import paintstore.repository.ReceiptRepository;
import paintstore.service.AccountService;
import paintstore.service.ProductService;
import paintstore.service.ReceiptService;
import paintstore.service.StaffService;
import paintstore.service.SupplierService;


@Controller
@RequestMapping("/admin/")
public class AdminReceiptController {
	@Autowired
	private SupplierService supplierServicel;
	
	@Autowired
	private ReceiptService receiptService;
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private ProductPepository pepository;
	
	@RequestMapping("receipt/list")
	public ModelAndView listReceipt() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/receipt/list-receipt");
		List<Receipt> listRc = receiptService.getListReceipt();
		
		mav.addObject("listReceipt", listRc);
		return mav;
	}
	
	@GetMapping("receipt/add")
	public ModelAndView viewAddReceipt() {
		ModelAndView mav = new ModelAndView("admin/receipt/add-receipt");
		Receipt receipt = new Receipt();
		mav.addObject("addreceipt", receipt);
		return mav;
				
	}
	
	@PostMapping("receipt/add")
	public ModelAndView addReceipt(@ModelAttribute("addreceipt") Receipt receipt) {
		ModelAndView mav = new ModelAndView("admin/receipt/add-receipt");
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staffs = staffService.findOneByAccount(account);
		receipt.setStaff(staffs);
		receipt.setStatus(0); // status = 0 vừa lập phiếu
		receiptService.save(receipt);
		return mav;
				
	}
	
	@GetMapping("receipt/success")
	public ModelAndView successReceipt(@RequestParam("idr") String idr) {
		ModelAndView mav = new ModelAndView();
		Receipt receipt = receiptService.findById(idr);
		receipt.setStatus(3); // 3 đã hoàn thành phiếu nhập
		
		List<ReceiptDetail> receiptDetails = receipt.getListReceiptDetail();
		
		for (ReceiptDetail receiptDetail : receiptDetails) {
			Product product = productService.getProductById(receiptDetail.getProduct().getId());
			product.setNumber(receiptDetail.getQuantity()+receiptDetail.getProduct().getNumber());
			pepository.save(product);
		}
		receiptRepository.save(receipt);
		mav.setViewName("redirect:/admin/receipt/list");
		return mav;
	}
	
	@GetMapping("receipt/delete")
	public ModelAndView deleteReceipt(@RequestParam("idr") String idr) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/admin/receipt/list");
		Receipt receipt = receiptService.findById(idr);
		receiptService.delete(receipt);
		return mav;
}
	
	@ModelAttribute("suppliers")
	public List<Supplier> listSupplier(){
		List<Supplier> list = new ArrayList<Supplier>() ;
		list.addAll(supplierServicel.getListSupplier());
		return list;
	}
	
	@Autowired
	private StaffService staffService;
	
	
	@ModelAttribute("staff")
	public Staffs getStaff() {
		Account account = accountService.findByUsername(SecurityUtils.getPrincipal().getUsername());
		Staffs staff = staffService.findOneByAccount(account);
		return staff;
	}
}
