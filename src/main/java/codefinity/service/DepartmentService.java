package codefinity.service;

import codefinity.model.Department;

public interface DepartmentService {
    Department add(Department department);

    Department getById(int id);

    String getDepartmentNameById(int id);
}
