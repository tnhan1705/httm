package paintstore.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETDONHANG")
public class OrderDetail {
	@EmbeddedId
	private OrderDetailPk id;
	
	@ManyToOne
	@MapsId("order")
	@JoinColumn(name = "MAPHIEUDAT")
	private Order order;
	
	@ManyToOne
	@MapsId("product")
	@JoinColumn(name = "MASANPHAM")
	private Product product;
	
	@Column(name = "SOLUONG")
	private int quantity;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetailPk getId() {
		return id;
	}

	public void setId(OrderDetailPk id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
// aaaaaaaaaaaa