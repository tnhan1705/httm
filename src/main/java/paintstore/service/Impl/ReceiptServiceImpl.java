package paintstore.service.Impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paintstore.entity.Product;
import paintstore.entity.Receipt;
import paintstore.entity.ReceiptDetail;
import paintstore.entity.ReceiptDetailPk;
import paintstore.repository.ProductPepository;
import paintstore.repository.ReceiptDetailRepository;
import paintstore.repository.ReceiptRepository;
import paintstore.service.ReceiptService;



@Service
public class ReceiptServiceImpl implements ReceiptService{

	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private ReceiptDetailRepository detailRepository;
	
	@Autowired
	private ProductPepository productPepository;
	
	@Override
	public void save(Receipt receipt) {
		if (receipt.getListReceiptDetail() == null) {
			receiptRepository.save(receipt);
		}
		else {
			Receipt receiptOld = receiptRepository.findOne(receipt.getId());
			for (ReceiptDetail rd : receipt.getListReceiptDetail()) {
				
				Product product = productPepository.findOne(rd.getProduct().getId()) ;
				ReceiptDetailPk receiptDetailPk = new ReceiptDetailPk();
				receiptDetailPk.setProduct(product.getId());
				receiptDetailPk.setReceipt(receipt.getId());
				ReceiptDetail receiptDetail = new ReceiptDetail();
				receiptDetail=rd;
				receiptDetail.setReceipt(receipt);
				receiptDetail.setId(receiptDetailPk);
				detailRepository.save(receiptDetail);
			}
			receiptRepository.save(receiptOld);
		}
		
	}

	@Override
	public List<Receipt> getListReceipt() {
		return receiptRepository.findAll();
	}

	@Override
	public Receipt findById(String id) {
		
		return receiptRepository.findOne(id);
	}

	@Override
	public void delete(Receipt receipt) {
		if (receipt.getListReceiptDetail().isEmpty()) {
			receiptRepository.delete(receipt.getId());
			System.out.println("hahaha");
		}
		else {
			List<ReceiptDetail> receiptDetails = receipt.getListReceiptDetail();
			detailRepository.deleteInBatch(receiptDetails);
			receiptRepository.delete(receipt.getId());
			
		}
		
	}

}
