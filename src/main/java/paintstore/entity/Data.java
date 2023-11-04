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
	
	public Data() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}
}
