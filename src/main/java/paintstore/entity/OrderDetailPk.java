package paintstore.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailPk implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "MAPHIEUDAT",length = 10)
    private String order;

    @Column(name = "MASANPHAM",length = 10)
    private String product;

	public OrderDetailPk() {
		
	}

	public OrderDetailPk(String order, String product) {
		super();
		this.order = order;
		this.product = product;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailPk other = (OrderDetailPk) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
    
	
    
}
