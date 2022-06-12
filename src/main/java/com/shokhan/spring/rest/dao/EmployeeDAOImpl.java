package com.shokhan.spring.rest.dao;

import com.shokhan.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private final SessionFactory factory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Session session = factory.getCurrentSession();
        List<Employee> allEmployes = session.createQuery("FROM Employee",
                        Employee.class).getResultList();


        return allEmployes;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = factory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {

        Session session = factory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);
        return  employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = factory.getCurrentSession();
//        session.delete(id);
        Query<Employee> query = session.createQuery(
                "DELETE FROM Employee WHERE id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }

}
