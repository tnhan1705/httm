package paintstore.service;

import java.util.List;

import paintstore.entity.ReceiptDetail;

public interface ReceiptDetailService {
	List<ReceiptDetail> findAllById_Receipt(String idr);
}
