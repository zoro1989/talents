package com.ccbjb.model.staff;

import java.io.Serializable;
import java.math.BigDecimal;

public class BusStaffModel implements Serializable {
    private Long id;
    private String staffNo;
    private String name;
    private String nameKana;
    private String duty;
    private String jpLevel;
    private BigDecimal workAge;
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameKana() {
        return nameKana;
    }

    public void setNameKana(String nameKana) {
        this.nameKana = nameKana;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getJpLevel() {
        return jpLevel;
    }

    public void setJpLevel(String jpLevel) {
        this.jpLevel = jpLevel;
    }

    public BigDecimal getWorkAge() {
        return workAge;
    }

    public void setWorkAge(BigDecimal workAge) {
        this.workAge = workAge;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
