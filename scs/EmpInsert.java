package scs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpInsert {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Emp e = new Emp();
		e.setEmpid(1002);
		e.setEmpname("RAMESH KUMAR");
		e.setJob("Manager");
		e.setSalary(85000);
		s.save(e);
		tx.commit();
		s.close();
		

	}

}
