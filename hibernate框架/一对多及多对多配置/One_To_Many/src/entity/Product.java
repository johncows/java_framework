package entity;

public class Product {
	/*
	 * 环境设定: Product是主表  pid为主键 设定为自增  cid为外键
	 * Category作用是 将主键为cid的category放入表中 
	 * 
	 */
	private Integer pid;
	private String pname;
	private Category category;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + "]";
	}
	

}
