package com.ccbjb.common.domain;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusProject implements Serializable {
    @Id
    private Long id;
    private String projName;
    private Date startDate;
    private Date endDate;
    private Integer devLanguage;
    private Integer operateSys;
    private Integer devTool;
    private Integer devDatabase;
    private Integer devAppServer;
    private Integer devFramework;
    private Integer serviceCustomer;
    private Integer busType;
    private BigDecimal contractCount;
    private BigDecimal putCount;
    private Long parentId;
    @Transient
    private List<BusProject> projectItems = new ArrayList<>();

    @Transient
    private List<SysDic> devLanguageList = new ArrayList<>();
    @Transient
    private List<SysDic> operateSysList = new ArrayList<>();
    @Transient
    private List<SysDic> devToolList = new ArrayList<>();
    @Transient
    private List<SysDic> devDatabaseList = new ArrayList<>();
    @Transient
    private List<SysDic> devAppServerList = new ArrayList<>();
    @Transient
    private List<SysDic> devFrameworkList = new ArrayList<>();
    @Transient
    private List<SysDic> serviceCustomerList = new ArrayList<>();
    @Transient
    private List<SysDic> busTypeList = new ArrayList<>();


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

    public Integer getDevLanguage() {
        return devLanguage;
    }

    public void setDevLanguage(Integer devLanguage) {
        this.devLanguage = devLanguage;
    }

    public Integer getOperateSys() {
        return operateSys;
    }

    public void setOperateSys(Integer operateSys) {
        this.operateSys = operateSys;
    }

    public Integer getDevTool() {
        return devTool;
    }

    public void setDevTool(Integer devTool) {
        this.devTool = devTool;
    }

    public Integer getDevDatabase() {
        return devDatabase;
    }

    public void setDevDatabase(Integer devDatabase) {
        this.devDatabase = devDatabase;
    }

    public Integer getDevAppServer() {
        return devAppServer;
    }

    public void setDevAppServer(Integer devAppServer) {
        this.devAppServer = devAppServer;
    }

    public Integer getDevFramework() {
        return devFramework;
    }

    public void setDevFramework(Integer devFramework) {
        this.devFramework = devFramework;
    }

    public Integer getServiceCustomer() {
        return serviceCustomer;
    }

    public void setServiceCustomer(Integer serviceCustomer) {
        this.serviceCustomer = serviceCustomer;
    }

    public Integer getBusType() {
        return busType;
    }

    public void setBusType(Integer busType) {
        this.busType = busType;
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

    public List<SysDic> getDevLanguageList() {
        return devLanguageList;
    }

    public void setDevLanguageList(List<SysDic> devLanguageList) {
        this.devLanguageList = devLanguageList;
    }

    public List<SysDic> getOperateSysList() {
        return operateSysList;
    }

    public void setOperateSysList(List<SysDic> operateSysList) {
        this.operateSysList = operateSysList;
    }

    public List<SysDic> getDevToolList() {
        return devToolList;
    }

    public void setDevToolList(List<SysDic> devToolList) {
        this.devToolList = devToolList;
    }

    public List<SysDic> getDevDatabaseList() {
        return devDatabaseList;
    }

    public void setDevDatabaseList(List<SysDic> devDatabaseList) {
        this.devDatabaseList = devDatabaseList;
    }

    public List<SysDic> getDevAppServerList() {
        return devAppServerList;
    }

    public void setDevAppServerList(List<SysDic> devAppServerList) {
        this.devAppServerList = devAppServerList;
    }

    public List<SysDic> getDevFrameworkList() {
        return devFrameworkList;
    }

    public void setDevFrameworkList(List<SysDic> devFrameworkList) {
        this.devFrameworkList = devFrameworkList;
    }

    public List<SysDic> getServiceCustomerList() {
        return serviceCustomerList;
    }

    public void setServiceCustomerList(List<SysDic> serviceCustomerList) {
        this.serviceCustomerList = serviceCustomerList;
    }

    public List<SysDic> getBusTypeList() {
        return busTypeList;
    }

    public void setBusTypeList(List<SysDic> busTypeList) {
        this.busTypeList = busTypeList;
    }

    public List<BusProject> getProjectItems() {
        return projectItems;
    }

    public void setProjectItems(List<BusProject> projectItems) {
        this.projectItems = projectItems;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
