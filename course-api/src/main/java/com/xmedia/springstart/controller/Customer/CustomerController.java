package com.xmedia.springstart.controller.Customer;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.response.BaseResponse.CodeResponse;
import com.xmedia.springstart.response.Customer.CustomerResponseList;
import com.xmedia.springstart.response.Customer.CustomerResponseObject;
import com.xmedia.springstart.model.Customer.Customers;
import com.xmedia.springstart.service.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("api/customer")
public class CustomerController extends CodeResponse {

    @Autowired
    private BaseResponse baseResponse;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/read")
    @ResponseBody
    public BaseResponse readAllCustomer() {
        List<Customers> customerList = customerService.getListCus();
        int count = customerList.size();
        if (count == 0) {
            return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
        } else {
            return new CustomerResponseList(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, customerList);
        }
    }

    @PostMapping(value = "create")
    @ResponseBody
    public BaseResponse addCustomer(@RequestBody Customers model) {
        String checkHotLine = customerService.checkHotLine(model.getHotline());
        if (checkHotLine != null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_NAME + checkHotLine, this.CODE_DUPLICATE_NAME);
        } else {
            try {
                Customers cusModel = setModel(model);
                customerService.addCus(cusModel);
                return new CustomerResponseObject(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, cusModel);
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_ADD_FAIL, this.CODE_ADD_FAIL);
            }
        }
        return baseResponse;
    }

    @PostMapping(value = "update/{id}")
    @ResponseBody
    public BaseResponse updateCustomer(@PathVariable("id") int id, @RequestBody Customers model) {
        if (customerService.checkId(id) == null) {
            return new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
        } else {
            try {
                Customers modelCustomer = updateModel(model, id);
                customerService.updateCus(id, modelCustomer);
                return new CustomerResponseObject(this.GET_UPDATE_SUCCESS + id, this.CODE_UPDATE_SUCCESS, modelCustomer);
            } catch (Exception e) {
                return new BaseResponse(this.GET_UPDATE_FAIL, this.CODE_UPDATE_FAIL);
            }
        }
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public BaseResponse deleteCustomer(@PathVariable("id") int cusId) {
        if (customerService.checkId(cusId) == null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
            return baseResponse;
        } else {
            try {
                customerService.deleteCus(cusId);
                baseResponse = new BaseResponse(this.GET_DELETE_SUCCESS, this.CODE_DELETE_FAIL);
                return baseResponse;
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_DELETE_FAIL, this.CODE_DELETE_FAIL);
                return baseResponse;
            }
        }
    }

    public Customers setModel(Customers model) {
        Date date = new Date();
        model.setName(model.getName());
        model.setAddress(model.getAddress());
        model.setHotline(model.getHotline());
        model.setDescription(model.getDescription());
        model.setCreatedDate(date);
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }

    public Customers updateModel(Customers model, int id) {
        Date date = new Date();
        model.setId(id);
        model.setName(model.getName());
        model.setAddress(model.getAddress());
        model.setHotline(model.getHotline());
        model.setDescription(model.getDescription());
        model.setCreatedDate(date);
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }
}
