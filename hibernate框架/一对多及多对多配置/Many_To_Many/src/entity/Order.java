package entity;

import java.util.HashSet;
import java.util.Set;

public class Order {
	/*
	 * 主表 order表 主键为oid
	 *  从表也为order_item
	 * 
	 */
	private Integer oid;
	private String oname;
	
	//相互包含！！！！
	private Set<Product> productSet = new HashSet<>();

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", oname=" + oname + "]";
	}
	
	
	
	
	


}
