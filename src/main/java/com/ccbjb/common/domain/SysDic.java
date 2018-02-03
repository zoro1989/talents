package com.ccbjb.common.domain;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysDic implements Serializable{
    @Id
    private Long id;
    private String dicValue;
    private String dicLabel;
    private Long parentId;
    private String type;
    @Transient
    private List<SysDic> dicParents = new ArrayList<>();
    @Transient
    private List<SysDic> dicItems = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public String getDicLabel() {
        return dicLabel;
    }

    public void setDicLabel(String dicLabel) {
        this.dicLabel = dicLabel;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<SysDic> getDicParents() {
        return dicParents;
    }

    public void setDicParents(List<SysDic> dicParents) {
        this.dicParents = dicParents;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<SysDic> getDicItems() {
        return dicItems;
    }

    public void setDicItems(List<SysDic> dicItems) {
        this.dicItems = dicItems;
    }
}
