package Hibernate.DAO;

import Hibernate.Entity.Department;
import Hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Макс on 07.10.2017.
 */
public class DepartmentDAO {
    public void addDepartment(Department department) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("addDepartment Exception");
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public List<Department> getAllDepartment() {
        Session session = null;
        List list = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            list = session.createSQLQuery("select* from department").addEntity(Department.class).list();
        } catch (Exception e) {
            System.out.println("getAllDepartment Exception");
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return list;
    }

    public Department getDepartmentById(int i) {
        Session session = null;
        Department department = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            department = (Department) session.load(Department.class, i);
        } catch (Exception e) {
            System.out.println("getDepartmentById Exception");
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
        return department;
    }

    public void updateDepartment(Department department) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("updateDepartment Exception");
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }

    public void deleteDepartment(Department department) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("deleteDepartment Exception");
        } finally {
            if (session != null && session.isOpen()) session.close();
        }
    }
}
