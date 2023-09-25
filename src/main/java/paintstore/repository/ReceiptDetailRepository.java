package paintstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.ReceiptDetail;
import paintstore.entity.ReceiptDetailPk;

public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, ReceiptDetailPk> {
	List<ReceiptDetail> findAllById_Receipt(String idr);
	void deleteById_Receipt(String idr);
}
