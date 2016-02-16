package com.fmr.papr.poc.domain;

import java.util.List;

/**
 * Created by vishal on 1/18/16.
 */
public class Composite {
    private String compositeId;
    private String compositeName;
    private List<Entity> entities;
    private Double mrktVal;
    private Double perfVal;

    public String getCompositeId() {
        return compositeId;
    }

    public void setCompositeId(String compositeId) {
        this.compositeId = compositeId;
    }

    public String getCompositeName() {
        return compositeName;
    }

    public void setCompositeName(String compositeName) {
        this.compositeName = compositeName;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
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
