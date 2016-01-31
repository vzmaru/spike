package com.fmr.papr.poc.domain;

import java.util.List;

/**
 * Created by vishal on 1/18/16.
 */
public class Composite {
    private String compositeId;
    private List<Account> accounts;
    private Double mrktVal;
    private Double perfVal;

    public String getCompositeId() {
        return compositeId;
    }

    public void setCompositeId(String compositeId) {
        this.compositeId = compositeId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
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
