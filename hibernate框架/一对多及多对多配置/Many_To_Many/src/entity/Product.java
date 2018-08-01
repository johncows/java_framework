package entity;

import java.util.HashSet;
import java.util.Set;

public class Product {
	/*
	 * 	 环境设定: Product为主表 order_item为从表
	 * 	主表的主键为pid 自动增长
	 *     注意 多对多表在配置时 不会显式的出现第三张表
	 */
	
	private Integer pid;
	private String pname;
	private Set<Order> orderSet = new HashSet<>();
	
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

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", orderSet=" + orderSet + "]";
	}
}
