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

	@Column(name = "MAU", length=45)
	private String color;
	
	public OrderDetail() {
		super();
	}
	
	public OrderDetail(OrderDetailPk id, int quantity, String color, Product product, Order order) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.order = order;
		this.color = color;
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
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
// aaaaaaaaaaaa