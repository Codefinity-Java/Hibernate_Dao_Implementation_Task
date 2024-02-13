package codefinity.service;

import codefinity.model.Employee;

public interface EmployeeService {
    Employee add(Employee employee);

    Employee getById(int id);

    String getEmployeeNameById(int id);
}
