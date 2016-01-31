package com.fmr.papr.poc.domain;

/**
 * Created by vishal on 1/18/16.
 */
public class Account {
    private String accNum;
    private Double mrktVal;
    private Double perfVal;

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public Double getMrktVal() {
        return mrktVal;
    }

    public void setMrktVal(Double mrktVal) {
        this.mrktVal = mrktVal;
    }

    public Double getPerfVal() {
        return perfVal;
    }

    public void setPerfVal(Double perfVal) {
        this.perfVal = perfVal;
    }

}
