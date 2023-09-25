package paintstore.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "KHACHHANG")
public class User {
	@Id
	@Column(name = "MAKHACHHANG",length = 50)
	private String id; 
	
	@Column(name = "TEN",length = 20)
	private String name;
	
	@Column(name ="HO", length = 20)
	private String surname;
	
	@Column(name = "SDT",length = 11)
	private String phone;
	
	@Column(name = "DIACHI",length = 200)
	private String address;
	
	@Column(name = "NGAYSINH", length = 20)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dayOfBirth;
	
	@Column(name = "ANHDAIDIEN", length = 20)
	private String image;
	
	@Column(name = "GIOITINH",length = 10)
	private String gender;
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private List<Account> listAccount;
	
	@OneToMany(mappedBy = "user")
	private List<Order> listOrder;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}

	public List<Order> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}
	
	
}
