package com.xtel.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xtel.entity.employee;
import com.xtel.interfaces.employees_interface;

@Repository
public class dao_employee implements employees_interface<employee> {

	@Autowired
	SessionFactory sessionFactory = new Configuration().configure("/com/xtel/hibernate/utils/hibernate.cfg.xml")
			.buildSessionFactory();

	@SuppressWarnings("unchecked")
	public ArrayList<employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		List<employee> list = new ArrayList<employee>();
		try {
			session.getTransaction().begin();
			list = session.createQuery("FROM employee").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return (ArrayList<employee>) list;
	}

	public void insert(employee emp) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.save(emp);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void update(employee emp) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(emp);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void delete(String id) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			employee idEmp = session.get(employee.class, id);
			session.delete(idEmp);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public employee find(String id) {
		Session session = sessionFactory.openSession();
		employee emp = null;
		try {
			session.getTransaction().begin();
			emp = session.get(employee.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return emp;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<employee> searchByName(String name) {
		Session session = sessionFactory.openSession();
		List<employee> list = new ArrayList<employee>();
		try {
			session.getTransaction().begin();
			String hql = "FROM employee WHERE name like '%" + name + "%' " + " ORDER BY id ASC";
			list = session.createQuery(hql).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return (ArrayList<employee>) list;
	}

//	public static void main(String[] args) {
//		dao_employee dao = new dao_employee();
//		employee emp = new employee();
//		emp.setId("testDao");
//		emp.setName("an");
//		emp.setPhone("25616");
//		emp.setAge(22);
//		emp.setAddress("gegeg");
//		emp.setEmail("gewgers@gmail.com");
//		emp.setId_card("12312");
//		emp.setUsername("vanan");
//		emp.setPassword("asekgmesm");
//		emp.setDate_start_work("gege");
//		emp.setDate_start_work("gege");
//		emp.setDate_start_work("gege");
//		emp.setStatus(true);
//		emp.setPosition("gg");
//		dao.insert(emp);
//	}
}
