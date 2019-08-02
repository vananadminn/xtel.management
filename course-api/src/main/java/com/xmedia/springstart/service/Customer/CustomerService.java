package com.xmedia.springstart.service.Customer;


import com.xmedia.springstart.model.Customer.Customers;
import com.xmedia.springstart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService implements CustomerServiceImpl {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customers> getListCus() {
        return customerRepository.findAll();
    }

    @Override
    public Customers getCusId(int cusId) {
        return customerRepository.findOne(cusId);
    }

    @Override
    public Customers addCus(Customers customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCus(Integer cusId) {
        customerRepository.delete(cusId);
    }

    @Override
    public void updateCus(int cusId, Customers customer) {
        customerRepository.save(customer);
    }

    public String checkHotLine(String hotLine) {
        return customerRepository.checkHotLine(hotLine);
    }

    public Integer checkId(int id) {
        return customerRepository.checkId(id);
    }
}
