package com.xmedia.springstart.service.Customer;

import com.xmedia.springstart.model.Customers;

import java.util.List;

public interface CustomerServiceImpl {
    List<Customers> getListCus();

    Customers getCusId(int cusId);

    Customers addCus(Customers customer);

    void deleteCus(Integer cusId);

    void updateCus(int cusId, Customers customer);
}
