package scs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpUpdate {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Object o = s.get(Emp.class, new Integer(1001));
		Emp e = (Emp)o; // downcasting
		e.setEmpid(1001);
		e.setEmpname("Ravish Kumar");
		e.setJob("PO");
		e.setSalary(85000);
		s.update(e);
		tx.commit();
		s.close();

	}

}
