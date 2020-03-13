package com.custodian.open.api.dto;


import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class SetHdAddressReq implements Serializable {

    private static final long serialVersionUID = -1671965223160908479L;
    private String address;
    private String remark;

    public String getAddress() {
        return address;
    }

    public String getRemark() {
        return remark;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
