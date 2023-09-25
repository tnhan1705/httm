package paintstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import paintstore.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, String>{

}
