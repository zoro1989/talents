package com.ccbjb.model.project;

import com.ccbjb.common.domain.BusProject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusProjectModel implements Serializable {
    private Long id;
    private String projName;
    private Date startDate;
    private Date endDate;
    private String serviceCustomer;
    private BigDecimal contractCount;
    private BigDecimal putCount;

    List<BusProjectModel> projectItems = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getServiceCustomer() {
        return serviceCustomer;
    }

    public void setServiceCustomer(String serviceCustomer) {
        this.serviceCustomer = serviceCustomer;
    }

    public BigDecimal getContractCount() {
        return contractCount;
    }

    public void setContractCount(BigDecimal contractCount) {
        this.contractCount = contractCount;
    }

    public BigDecimal getPutCount() {
        return putCount;
    }

    public void setPutCount(BigDecimal putCount) {
        this.putCount = putCount;
    }

    public List<BusProjectModel> getProjectItems() {
        return projectItems;
    }

    public void setProjectItems(List<BusProjectModel> projectItems) {
        this.projectItems = projectItems;
    }
}
