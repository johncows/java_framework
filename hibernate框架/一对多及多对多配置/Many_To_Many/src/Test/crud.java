package Test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.hiberanateUtil;
import entity.Order;
import entity.Product;

public class crud{
	/*
	 *  其他操作也基本和一对多查询相吻合！！
	 * 
	 */
	
	

	@Test
	public void initialize() {
		// 创建sessionFactory时就已经创建好表了 具体不赘述
		@SuppressWarnings("unused")
		Session session = hiberanateUtil.getSession();
	}
	
	
	@Test
	public void add() {
		/*
		 * 在添加某个新的主表和从表关联数据时 set只需要add一个就行了 不需要双向add
		 */
		
		Session session = hiberanateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Product pro = new Product();
		pro.setPname("大元丹");
		Order order = new Order();
		order.setOname("灵丹妙药");
		pro.getOrderSet().add(order);
		session.save(pro);
		transaction.commit();
	}
	
	
	@Test
	public void delete() {

		Session session = hiberanateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Product product = session.get(Product.class, 6);
		System.out.println(product);
		session.delete(product);
		transaction.commit();
	}
}
