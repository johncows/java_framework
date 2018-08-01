package Test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.hiberanateUtil;
import entity.Category;
import entity.Product;

public class crud {

	@Test
	public void initialize() {
		// 创建sessionFactory时就已经创建好表了 具体不赘述
		@SuppressWarnings("unused")
		Session session = hiberanateUtil.getSession();
	}

	@Test
	public void add() {
		/*
		 * 正常操作下 如果没有先创建主表 从表是无法加入新值的 因此当我们配置了cascade的属性 save-update 时就会进行级联操作
		 * 相当于hibernate 先添加了主表的值后再添加从表的值
		 */

		Session session = hiberanateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Category category = new Category();
		category.setCname("汽车配饰");
		Product product = new Product();
		product.setPname("车衣");
		category.getProductSet().add(product);
		session.save(category);
		transaction.commit();
	}

	@Test
	public void delete() {
		/*
		 * 数据库删除主表数据时 必须保证在从表字段没有被引用 在hibernate中 先删除从表 再删除主表
		 */
		Session session = hiberanateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Category category = session.get(Category.class, 6);
		session.delete(category);
		transaction.commit();
	}

}
