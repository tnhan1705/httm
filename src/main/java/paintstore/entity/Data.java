package paintstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DATA")
public class Data {
	@Id
	@Column(name = "MADULIEU",length = 50)
	private String id; 
	
	@Column(name = "NOIDUNG",length = 500)
	private String content;
	
	@Column(name = "LUACHON",length = 50)
	private String select;
}
