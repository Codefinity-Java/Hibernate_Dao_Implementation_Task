# Hibernate_Dao_Implementation_Task

Let's move on to **practice**. In the previous chapter, we implemented the **DAO layer** as well as the **Service layer** for the `Employee` entity. In this task, **you need to do everything similarly** for the `Department` entity.
Interfaces such as `DepartmentDao` and `DepartmentService` have already been created for you. In this task, **you should work in implementation classes**, such as `DepartmentDaoImpl` and `DepartmentServiceImpl`.
You need to implement the interfaces and implement all the methods from there.

Here's the workflow for the task:

1. Set up the database connection in `hibernate.cfg.xml`;
2. Implement the interfaces in the implementation classes;
3. Implement the necessary methods in the implementation classes;
4. You can implement them similarly to how we did it in the previous chapter. It's not difficult. You just need to change the entity names;
5. Don't forget to use `HibernateUtil`;
6. Run the **integration tests** to check your solution.

>Note
>
>To ensure that the integration tests work correctly, you need to **execute the following command** in the MySQL Workbench query. This command will grant permission to delete data from the table for the tests to run correctly. Don't worry. **This database is a test database;** later, when we test all the necessary methods and are ready to complete the project, **we will create another database** that will no longer be a test one.

Command:

```sql
SET SQL_SAFE_UPDATES = 0;
```
