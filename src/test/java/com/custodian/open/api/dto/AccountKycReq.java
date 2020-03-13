package com.custodian.open.api.dto;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class AccountKycReq {

    private String acct_name;
    private String acct_no;
    private String address;
    private String back_doc;
    private String bank_id;
    private Date birthday;
    private String city;
    private String country;
    private String country_code;
    private String doc_no;
    private String doc_type;
    private String first_name;
    private String front_doc;
    private String gender;
    private String kyc_info;
    private String last_name;
    private String maiden_name;
    private String mail;
    private String mail_token;
    private String mail_verification_code;
    private String mix_doc;
    private String mobile;
    private String nationality;
    private String state;
    private String zipcode;

    public void setAcct_name(String acct_name) {
        this.acct_name = acct_name;
    }

    public void setAcct_no(String acct_no) {
        this.acct_no = acct_no;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBack_doc(String back_doc) {
        this.back_doc = back_doc;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setDoc_no(String doc_no) {
        this.doc_no = doc_no;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setFront_doc(String front_doc) {
        this.front_doc = front_doc;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setKyc_info(String kyc_info) {
        this.kyc_info = kyc_info;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMaiden_name(String maiden_name) {
        this.maiden_name = maiden_name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMail_token(String mail_token) {
        this.mail_token = mail_token;
    }

    public void setMail_verification_code(String mail_verification_code) {
        this.mail_verification_code = mail_verification_code;
    }

    public void setMix_doc(String mix_doc) {
        this.mix_doc = mix_doc;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAcct_name() {
        return acct_name;
    }

    public String getAcct_no() {
        return acct_no;
    }

    public String getAddress() {
        return address;
    }

    public String getBack_doc() {
        return back_doc;
    }

    public String getBank_id() {
        return bank_id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getDoc_no() {
        return doc_no;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getFront_doc() {
        return front_doc;
    }

    public String getGender() {
        return gender;
    }

    public String getKyc_info() {
        return kyc_info;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMaiden_name() {
        return maiden_name;
    }

    public String getMail() {
        return mail;
    }

    public String getMail_token() {
        return mail_token;
    }

    public String getMail_verification_code() {
        return mail_verification_code;
    }

    public String getMix_doc() {
        return mix_doc;
    }

    public String getMobile() {
        return mobile;
    }

    public String getNationality() {
        return nationality;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
