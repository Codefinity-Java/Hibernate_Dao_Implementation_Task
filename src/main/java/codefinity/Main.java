package codefinity;

import codefinity.model.Employee;
import codefinity.service.EmployeeService;
import codefinity.service.impl.EmployeeServiceImpl;


import java.util.Date;

public class Main {
    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeServiceImpl();

        Employee employee = new Employee();
        employee.setName("Daniel");
        employee.setPosition("Developer");
        employee.setHireDate(new Date());
        employee.setSalary(75000);

        employeeService.add(employee);

        System.out.println(employeeService.getById(1));

        System.out.println(employeeService.getEmployeeNameById(1));

        // You can test your solution here
    }
}
