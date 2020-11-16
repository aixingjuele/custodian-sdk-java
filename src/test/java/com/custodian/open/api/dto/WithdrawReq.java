package com.custodian.open.api.dto;


import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;


public class WithdrawReq implements Serializable {
    private static final long serialVersionUID = 19816245324673206L;
    //币种代号、提现地址、提现数额

    private String request_id;

    private String coin_type;

    private String to_address;

    private String tx_amount;

    private String note;


    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public void setCoin_type(String coin_type) {
        this.coin_type = coin_type;
    }

    public void setTo_address(String to_address) {
        this.to_address = to_address;
    }

    public void setTx_amount(String tx_amount) {
        this.tx_amount = tx_amount;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRequest_id() {
        return request_id;
    }

    public String getCoin_type() {
        return coin_type;
    }

    public String getTo_address() {
        return to_address;
    }

    public String getTx_amount() {
        return tx_amount;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
