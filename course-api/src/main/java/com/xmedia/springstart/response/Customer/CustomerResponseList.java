package com.xmedia.springstart.response.Customer;

import com.xmedia.springstart.model.Customers;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerResponseList extends BaseResponse {
    List<Customers> customersList;

    public CustomerResponseList() {

    }

    public CustomerResponseList(String message, int code, List<Customers> customerList) {
        this.setMessage(message);
        this.setCode(code);
        this.customersList = customerList;
    }

    public List<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customers> customersList) {
        this.customersList = customersList;
    }
}
