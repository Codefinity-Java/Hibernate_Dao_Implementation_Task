package codefinity.service.impl;

import codefinity.dao.EmployeeDao;
import codefinity.dao.impl.EmployeeDaoImpl;
import codefinity.model.Employee;
import codefinity.service.EmployeeService;

import java.util.NoSuchElementException;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public Employee add(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public Employee getById(int id) {
        Employee employee = employeeDao.getById(id);
        if (employee != null) {
            return employeeDao.getById(id);
        } else {
            throw new NoSuchElementException("Can't get employee by ID " + id);
        }
    }

    @Override
    public String getEmployeeNameById(int id) {
        Employee employee = getById(id);
        String employeeName = employee.getName();
        if (employeeName != null) {
            return employeeName;
        } else {
            throw new NullPointerException("The employee's name is null, " +
                    "or there is no name for an employee with ID " + id);
        }
    }
}
