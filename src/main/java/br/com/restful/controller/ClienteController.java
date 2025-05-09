package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.CustomerDAO;
import br.com.restful.model.Customer;

public class CustomerController {

    public ArrayList<Customer> getAllCustomers() {
        System.out.println("Controller: getAllCustomers");
        return CustomerDAO.getInstance().getAll();
    }

    public Customer getCustomerById(long id) {
        System.out.println("Controller: getCustomerById - " + id);
        CustomerDAO dao = new CustomerDAO();
        Customer customer = dao.getById(id);
        return customer;
    }

    public boolean saveCustomer(Customer customer) {
        System.out.println("Controller: saveCustomer " + customer.getName());
        return new CustomerDAO().insert(customer);
    }

    public boolean updateCustomer(Customer customer) {
        System.out.println("Controller: updateCustomer " + customer.getName());
        return CustomerDAO.getInstance().update(customer);
    }

    public boolean deleteCustomer(Customer customer) {
        System.out.println("Controller: deleteCustomer " + customer.getName());
        return CustomerDAO.getInstance().delete(customer);
    }
}
