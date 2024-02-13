package codefinity.dao;

import codefinity.model.Department;

public interface DepartmentDao {
    Department add(Department department);

    Department getById(int id);
}
