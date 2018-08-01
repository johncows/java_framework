package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hiberanateUtil {
	static Configuration cfg=null;
	static SessionFactory buildSessionFactory = null;
		
	/*
	 * 通过静态方法来引用 
	 */
	static {
		cfg = new Configuration();
		cfg.configure();
		buildSessionFactory = cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		return buildSessionFactory.openSession();
	}
	
	public static void closeSessionFatory() {
		buildSessionFactory.close();
	}
	
}
