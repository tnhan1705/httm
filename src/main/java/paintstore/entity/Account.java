package paintstore.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="TAIKHOAN")
public class Account {
	@Id
	@Column(name="TENTAIKHOAN",length = 50)
	private String userName;
	
	@Column(name="MATKHAU",length = 5000)
	private String passWord;
	
	@Column(name="TrangThai")
	private Boolean status;
	
	@Column(name="EMAIL",length = 50)
	private String email;
	
	@OneToOne(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Staffs staff;
	
	@ManyToOne
	@JoinColumn(name = "MACHUCVU")
	private Position position;
	
	@OneToOne(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private User user;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Staffs getStaff() {
		return staff;
	}

	public void setStaff(Staffs staff) {
		this.staff = staff;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	
	
	
	
}
