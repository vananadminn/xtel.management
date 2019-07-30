package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeExperienceTest extends EmployeeExperienceResponse {

    private List<EmployeeExperienceResponse> list;

    public EmployeeExperienceTest() {

    }

    public EmployeeExperienceTest(String message, int code, List<EmployeeExperienceResponse> list) {
        this.setMessage(message);
        this.setCode(code);
        this.list = list;
    }
}
