package com.custodian.open.api.dto;


import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;


public class AddHdAddressReq implements Serializable {

    private static final long serialVersionUID = -4122712151100145273L;

    private String address;


    private Integer count;


    private List<String> remarks;


    public String getAddress() {
        return address;
    }

    public Integer getCount() {
        return count;
    }

    public List<String> getRemarks() {
        return remarks;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setRemarks(List<String> remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
