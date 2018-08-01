package entity;

import java.util.HashSet;
import java.util.Set;

public class Category {
	/*
	 * 环境设定: Category是主表  cid为主键 设定为自增
	 * productSet作用是 将外键为cid的product放入表中 做多表查询
	 * 
	 */
	private Integer cid;
	private String cname;
	private Set<Product> productSet = new HashSet<>();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Product> getProductSet() {
		return productSet;
	}
	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", productSet=" + productSet + "]";
	}
	

}
