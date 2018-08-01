package Test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.hiberanateUtil;
import entity.Category;
@SuppressWarnings("unchecked")
public class selectTest {
	/*
	 * 	三种查询方式 进行全表查询 
	 * 	第一种需要写一半sql语句 返回是已经封装好的对象
	 * 	第二种直接填写实体类 进行映射封装
	 * 	第三种填写底层sql语句 但返回的是数组对象 即未封装 
	 * 
	 */
	
	
	
	
	@Test
	public void select1() {
		Session session = hiberanateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Category");
		
		List<Category> list = query.list();
		list.forEach(cate -> System.out.println(cate));
		transaction.commit();
	}

	@Test
	public void select2() {
		Session session = hiberanateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Category.class);
		List<Category> list = criteria.list();
		list.forEach(cate -> System.out.println(cate));
		transaction.commit();
	}

	@Test
	public void select3() {
		Session session = hiberanateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from Category");
		List<Object[]> list = query.list();
		list.forEach(cate -> System.out.println(Arrays.toString(cate)));
		transaction.commit();
	}

}
