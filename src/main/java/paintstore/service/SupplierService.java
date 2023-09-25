package paintstore.service;

import java.util.List;

import paintstore.entity.Supplier;

public interface SupplierService {
	void save(Supplier supplier);
	Supplier findById(String id);
	void update(Supplier supplier, String id);
	List<Supplier> getListSupplier();
	List<Supplier> getListSupplierByStatus(boolean b);
}
