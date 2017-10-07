package Hibernate.DAO;

import Hibernate.Entity.Employee;
import Hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Макс on 07.10.2017.
 */
public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("addEmployee Exception");
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public List<Employee> getAllEmployees() {
        Session session = null;
        List list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            list = session.createSQLQuery("select* from groups").addEntity(Employee.class).list();
        } catch (Exception e) {
            System.out.println("getAllEmployees Exception");
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return list;
    }

    public Employee getEmployeeById(int i) {
        Session session = null;
        Employee employee = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            employee = (Employee) session.load(Employee.class, i);
        } catch (Exception e) {
            System.out.println("getEmployeeById Exception");
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return employee;
    }

    public void updateEmployee(Employee employee) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("updateEmployee Exception");
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public void deleteEmployee(Employee employee) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("deleteEmployee Exception");
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }
}
