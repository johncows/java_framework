package Test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import Utils.hiberanateUtil;
import entity.Order;


@SuppressWarnings("unchecked")
public class hql{
	
	//全查询
	//select * from order
	@Test
	public void select1() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("from Order");
		List<Order> list = query.list();
		list.forEach(s->System.out.println(s));
	}
	
	//条件查询
	//select * from order where oid = ''
	@Test
	public void select2() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("from Order where oid=?");
		query.setParameter(0,1);
		List<Order> list = query.list();
		list.forEach(s->System.out.println(s));
	}
	
	//模糊查询
	//select * from order where oname like _李
	@Test
	public void select3() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("from Order where oname like ?");
		query.setParameter(0, "_李");
		//query.setParameter(0, "%李");
		List<Order> list = query.list();
		list.forEach(s->System.out.println(s));
	}
	
	//排序查询 desc为逆序 
	//select * from order order by oid desc
	@Test
	public void select4() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("from Order order by oid desc");
		List<Order> list = query.list();
		list.forEach(s->System.out.println(s));
	}
	
	// 分页查询 
	//select * from order limit 1,2
	@Test
	public void select5() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("from Order order ");
		//起始点
		query.setFirstResult(1);
		//查询的最大条数
		query.setMaxResults(2);
		List<Order> list = query.list();
		list.forEach(s->System.out.println(s));
	}
	
	@Test
	//投影查询
	public void select6() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("Select oname from Order");
		List<Object> list = query.list();
		list.forEach(s->System.out.println(s));
	}
	
	@Test
	//聚集函数
	public void select7() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("Select Count(*) from Order");
		Object uniqueResult = query.uniqueResult();
		Long num = (Long) uniqueResult;
		System.out.println(num.intValue());
	}
	
	@Test
	//内连接 返回的是数组形式
	public void select8() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("from Order o inner join o.productSet");
		List<Object[]> list = query.list();
		list.forEach(e->System.out.println(Arrays.toString(e)));
	}
	
	@Test
	//迫切内连接 返回的是from后面实体类的类型
	public void select9() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("from Order o inner join fetch o.productSet");
		List<Order> list = query.list();
		list.forEach(e->System.out.println(e));
	}
	
	@Test
	/*
		 * 左外连接 返回的是数组形式
		 *  在该段代码中 返回的是一个list集合的object数组，
		 *  该数组中包含着2个Object 一个是order 一个是product
	 */
	public void select10() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("from Order o left outer join o.productSet");
		List<Object[]> list = query.list();
		Object object[] = list.get(0);
		System.out.println(object[0]);
	}
	
	
	/*
	 *  迫切外链接 和迫 内连接相同 区别在于 左连接除了显示原本的关系表之外 
	 *  额外的显示 自己左表的全部数据 
	 */
	@Test
	public void select11() {
		Session session = hiberanateUtil.getSession();
		Query query = session.createQuery("from Order o left outer join fetch o.productSet");
		List<Order> list = query.list();
		System.out.println(list);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
