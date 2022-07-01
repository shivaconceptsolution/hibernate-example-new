package scs;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpOpeartion {
	Configuration cfg;
	SessionFactory sf;
	Session s;
	void configureHiber()
	{
		cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	    sf = cfg.buildSessionFactory();
		s = sf.openSession();
	}
	void insertHiber(int empid,String empname,String job,int sal)
	{
		Transaction tx = s.beginTransaction();
		Emp e = new Emp();
		e.setEmpid(empid);
		e.setEmpname(empname);
		e.setJob(job);
		e.setSalary(sal);
		s.save(e);
		tx.commit();
	}
	void updateHiber()
	{
		Transaction tx = s.beginTransaction();
		Object o = s.get(Emp.class, new Integer(1001));
		Emp e = (Emp)o; // downcasting
		e.setEmpid(1001);
		e.setEmpname("Ravish Kumar");
		e.setJob("PO");
		e.setSalary(85000);
		s.update(e);
		tx.commit();
	}
	void deleteHiber()
	{
		Transaction tx = s.beginTransaction();
		Object o = s.get(Emp.class, new Integer(1001));
		Emp e = (Emp)o; // downcasting
		s.delete(e);
		tx.commit();
	}
	void displayHiber()
	{
		Query q = s.createQuery("from Emp obj");
		List lst = q.list();
		Iterator it = lst.iterator();
		while(it.hasNext())
		{
	Emp o = (Emp)it.next();
	System.out.println(o.getEmpid() + " "+ o.getEmpname() + " "+o.getJob() + " " + o.getSalary());
		}
		
	}
	void closeConfiguration()
	{
		s.close();
	}
	public static void main(String[] args) {
		EmpOpeartion obj = new EmpOpeartion();
		obj.configureHiber();
		System.out.println("Press1 for insert,2 for update, 3 for delete");
		switch(1)
		{
		    case 1:
			obj.insertHiber(1005,"ravi","cleark",89000);
			obj.displayHiber();
			break;
		    case 2:
			obj.updateHiber();
			obj.displayHiber();
			break;
		}
		
		obj.closeConfiguration();

	}

}
