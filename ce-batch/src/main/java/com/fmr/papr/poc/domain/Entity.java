package com.fmr.papr.poc.domain;

/**
 * Created by vishal on 1/18/16.
 */
public class Entity {
    private String entityId;
    private Double mrktVal;
    private Double perfVal;

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
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
