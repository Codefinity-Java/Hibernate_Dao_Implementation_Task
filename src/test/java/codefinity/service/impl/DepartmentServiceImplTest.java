package codefinity.service.impl;

import codefinity.model.Department;
import codefinity.service.DepartmentService;
import codefinity.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceImplTest {
    public static final String TEST_NAME = "TestName";
    public static final String TEST_LOCATION = "TestLocation";
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private Session session;
    private Transaction transaction;

    private final DepartmentService departmentService = new DepartmentServiceImpl();

    @BeforeEach
    public void setSessionFactory() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @Test
    void addCorrectValueTest() {
        Department department = new Department();
        department.setName(TEST_NAME);
        department.setLocation(TEST_LOCATION);
        departmentService.add(department);
        transaction.commit();
        boolean isDBContainsDepartment = false;
        String sql = "SELECT * from departments";
        List<Department> departments = session.createNativeQuery(sql, Department.class).stream().toList();
        if (departments.contains(department)) {
            isDBContainsDepartment = true;
        }
        assertTrue(isDBContainsDepartment, "The element wasn't added; the method is not functioning correctly." +
                " Try testing the method in the Main class.");
    }

    @Test
    void getByIdTest() {
        Department department = new Department();
        department.setName(TEST_NAME);
        department.setLocation(TEST_LOCATION);
        departmentService.add(department);
        transaction.commit();
        Department expected = session.find(Department.class, department.getId());
        Department actual = departmentService.getById(department.getId());
        if (expected == null) {
            fail("The object is null, double check your solution");
        }
        int id = expected.getId();
        System.out.println(id);
        assertEquals(expected, actual,
                "The objects don't match; double-check the correctness of the written code.");
    }

    @Test
    void getDepartmentNameByIdTest() {
        Department department = new Department();
        department.setName(TEST_NAME);
        department.setLocation(TEST_LOCATION);
        departmentService.add(department);
        transaction.commit();
        Department byId = departmentService.getById(department.getId());
        if (byId == null) {
            fail("The object is null, double check your solution");
        }
        String actual = byId.getName();
        assertEquals(TEST_NAME, actual,
                "The names don't match; double-check the correctness of the written code.");
    }

    @AfterEach
    public void tearDown() {
        if (transaction.isActive()) {
            transaction.commit();
        }
        if (session.isOpen()) {
            session.close();
        }

    }

    @AfterAll
    public static void deleteTestValues() {
        Session tempSession = sessionFactory.openSession();
        Transaction tempTransaction = tempSession.beginTransaction();
        String sql = "DELETE from departments where name = :name";
        tempSession.createNativeQuery(sql, Department.class)
                .setParameter("name", TEST_NAME)
                .executeUpdate();

        tempTransaction.commit();
    }
}
