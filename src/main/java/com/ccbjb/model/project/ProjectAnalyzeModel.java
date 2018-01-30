package com.ccbjb.model.project;

import com.ccbjb.common.domain.SysDic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectAnalyzeModel implements Serializable {
    private String personalTarget;
    private String techTarget;
    private String projectTarget;
    private List<SysDic> personalDicList = new ArrayList<>();
    private List<SysDic> techDicList = new ArrayList<>();
    private List<SysDic> projectDicList = new ArrayList<>();

    public String getPersonalTarget() {
        return personalTarget;
    }

    public void setPersonalTarget(String personalTarget) {
        this.personalTarget = personalTarget;
    }

    public String getTechTarget() {
        return techTarget;
    }

    public void setTechTarget(String techTarget) {
        this.techTarget = techTarget;
    }

    public String getProjectTarget() {
        return projectTarget;
    }

    public void setProjectTarget(String projectTarget) {
        this.projectTarget = projectTarget;
    }

    public List<SysDic> getPersonalDicList() {
        return personalDicList;
    }

    public void setPersonalDicList(List<SysDic> personalDicList) {
        this.personalDicList = personalDicList;
    }

    public List<SysDic> getTechDicList() {
        return techDicList;
    }

    public void setTechDicList(List<SysDic> techDicList) {
        this.techDicList = techDicList;
    }

    public List<SysDic> getProjectDicList() {
        return projectDicList;
    }

    public void setProjectDicList(List<SysDic> projectDicList) {
        this.projectDicList = projectDicList;
    }
}
