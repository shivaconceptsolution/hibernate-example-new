package scs;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpSelect {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Emp obj");
		List lst = q.list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
	Emp o = (Emp)it.next();
	System.out.println(o.getEmpid() + " "+ o.getEmpname() + " "+o.getJob() + " " + o.getSalary());
		}
		
		s.close();

	}

}
