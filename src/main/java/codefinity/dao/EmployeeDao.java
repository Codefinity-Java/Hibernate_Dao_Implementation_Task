package codefinity.dao;

import codefinity.model.Employee;

public interface EmployeeDao {
    Employee add(Employee employee);

    Employee getById(int id);
}
