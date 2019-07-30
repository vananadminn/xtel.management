package com.xmedia.springstart.response.BaseResponse;

import org.springframework.stereotype.Component;

@Component
public class CodeResponse {

    public final int CODE_ADD_SUCCESS = 200;
    public final String GET_ADD_SUCCESS = "Add success";

    public final int CODE_ADD_FAIL = -200;
    public final String GET_ADD_FAIL = "Add fail";

    public final int CODE_GET_LIST_SUCCESS = 199;
    public final String GET_LIST_SUCCESS = "Get success: ";

    public final int CODE_GET_LIST_FAIL = -199;
    public final String GET_LIST_FAIL = "Get fail";


    public final int CODE_UPDATE_SUCCESS = 299;
    public final String GET_UPDATE_SUCCESS = "Update success id: ";

    public final int CODE_UPDATE_FAIL = -299;
    public final String GET_UPDATE_FAIL = "Update fail id: ";

    public final int CODE_LIST_EMPTY = 255;
    public final String GET_LIST_EMPTY = "List is empty ";

    public final int CODE_DUPLICATE_NAME = 399;
    public final String GET_DUPLICATE_NAME = "Duplicate the: ";

    public final int CODE_DUPLICATE_ID = -399;
    public final String GET_DUPLICATE_ID = "ID doesn't exits: ";

    public final int CODE_DELETE_FAIL = -499;
    public final String GET_DELETE_FAIL = "Delete fail ";

    public final int CODE_DELETE_SUCCESS = 499;
    public final String GET_DELETE_SUCCESS = "Delete success ";

    public final int CODE_CHECK_EMAIL = -599;
    public final String GET_CHECK_EMAIL = "Email exits";

    public final int CODE_CHECK_PHONE = -699;
    public final String GET_CHECK_PHONE = "Phone number exits";

    public final int CODE_DUPLICATE_ID_CUSTOMER = -799;
    public final String GET_ID_CUSTOMER_NOT_EXITS = "Customer Id not found: ";

    public final int CODE_TIME_NOTFOUND = 799;
    public final String GET_TIME_NOT_FOUND = "Not found employee ";

    public final String GET_NAME_NOT_EXIST = "The name does't exist";
    public final int CODE_GET_NAME_NOT_EXIST = -899;
}
