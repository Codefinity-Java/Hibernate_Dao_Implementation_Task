package codefinity.integration;

import codefinity.dao.EmployeeDao;
import codefinity.model.Employee;
import codefinity.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    @Override
    public Employee add(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw new RuntimeException("Can't add new Employee", e);
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return employee;
    }
    @Override
    public Employee getById(int id) {
        Session session = null;
        Employee employee = null;
        try {
            session = sessionFactory.openSession();
            employee = session.get(Employee.class, id);
        } catch (Exception e) {
            throw new HibernateException("Can't get Employee by ID " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return employee;
    }
}
