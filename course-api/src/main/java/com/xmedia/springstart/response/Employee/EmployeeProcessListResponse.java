package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.data_query_model.Employee.EmployeeProcessList;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import java.util.List;

public class EmployeeProcessListResponse extends BaseResponse {

    private List<EmployeeProcessList> list;

    public EmployeeProcessListResponse() {

    }

    public EmployeeProcessListResponse(List<EmployeeProcessList> list) {
        this.list = list;
    }

    public EmployeeProcessListResponse(String message, int code, List<EmployeeProcessList> list) {
        super(message, code);
        this.list = list;
    }

    public List<EmployeeProcessList> getList() {
        return list;
    }

    public void setList(List<EmployeeProcessList> list) {
        this.list = list;
    }
}
