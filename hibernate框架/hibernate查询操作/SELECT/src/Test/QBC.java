package Test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import Utils.hiberanateUtil;
import entity.Product;

@SuppressWarnings("unchecked")
public class QBC {
	
	@Test
	//查询所有
	public void Select1(){
		Session session = hiberanateUtil.getSession();
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> list = criteria.list();
		//	注意查询product 只是单独查询product表 
		// 而当我们引用order时 再进行查询！！！ product为持久态 
		System.out.println(list.get(0));
	}
	
	@Test
	//条件查询 
	public void Select2(){
		Session session = hiberanateUtil.getSession();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.eq("pname", "金坷垃"));
		List<Product> list = criteria.list();
		System.out.println(list.get(0));
	}
	
	
}
