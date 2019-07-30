package com.xmedia.springstart.response.Customer;

import com.xmedia.springstart.model.Customers;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerResponseObject extends BaseResponse {

    private Customers customer;

    public CustomerResponseObject() {

    }

    public CustomerResponseObject(String message, int code, Customers customer) {
        this.setMessage(message);
        this.setCode(code);
        this.customer = customer;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
}
