package com.ccbjb.common.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusStaff implements Serializable {
    @Id
    private Long id;
    private String staffNo;
    private String name;
    private String nameSpell;
    private String nameKana;
    private String nameJp;
    private Integer sex;
    private Date birthday;
    private Date joinDay;
    @Transient
    private String joinDayStart;
    @Transient
    private String joinDayEnd;
    private Date practiceStartDate;
    @Transient
    private String practiceStartDateStart;
    @Transient
    private String practiceStartDateEnd;
    private Date practiceEndDate;
    @Transient
    private String practiceEndDateStart;
    @Transient
    private String practiceEndDateEnd;
    private Date trialStartDate;
    @Transient
    private String trialStartDateStart;
    @Transient
    private String trialStartDateEnd;
    private Date trialEndDate;
    @Transient
    private String trialEndDateStart;
    @Transient
    private String trialEndDateEnd;
    private Integer trialResult;
    private Date formalDate;
    @Transient
    private String formalDateStart;
    @Transient
    private String formalDateEnd;
    private Integer jobStatus;
    private BigDecimal befworkAge;
    @Transient
    private BigDecimal befworkAgeStart;
    @Transient
    private BigDecimal befworkAgeEnd;
    private BigDecimal aftworkAge;
    @Transient
    private BigDecimal aftworkAgeStart;
    @Transient
    private BigDecimal aftworkAgeEnd;
    @Transient
    private BigDecimal workAgeStart;
    @Transient
    private BigDecimal workAgeEnd;
    private BigDecimal workAge;
    @Transient
    private String workDateStart;
    @Transient
    private String workDateEnd;
    private Date workDate;
    private Date graduateDate;
    @Transient
    private String graduateDateStart;
    @Transient
    private String graduateDateEnd;
    private String graduateSchool;
    private Integer education;
    private Integer trainingMode;
    private String major;
    private Integer degree;
    private String email;
    private String tel;
    private String urgencyCnt;
    private String urgencyTel;
    private String homeAddr;
    private String addr;
    private String registerAddr;
    private Integer registerType;
    private Integer jpLevel;
    private Integer enLevel;
    private String salaryCard;
    private String idCard;
    private String professional;
    private String doorNo;
    private String checkNo;
    private Integer nation;
    private Integer country;
    private Integer ismarried;
    private Integer hasbaby;
    private String docManageMode;
    private String docNo;
    private Integer docFee;
    private String docRemark;
    private Integer ispartied;
    private Date partiedDate;
    private String partiedRls;
    private String partiedRls1;
    private String passportNo;
    private Integer salaryStatus;
    private String docBoxNo;
    private BigDecimal practiceFee;
    private BigDecimal trialFee;
    private BigDecimal formalFeeBottom;
    private BigDecimal formalFeeTop;
    private BigDecimal formalFee;
    private Integer department;
    private Date leaveDate;
    private Integer duty;
    private BigDecimal cmpbefworkAge;
    @Transient
    private BigDecimal cmpbefworkAgeStart;
    @Transient
    private BigDecimal cmpbefworkAgeEnd;
    private Integer tLevel;
    private Integer studentLine;
    @Transient
    private List<SysDic> sexList = new ArrayList<>();
    @Transient
    private List<SysDic> jobStatusList = new ArrayList<>();
    @Transient
    private List<SysDic> yesNoList = new ArrayList<>();
    @Transient
    private List<SysDic> educationList = new ArrayList<>();
    @Transient
    private List<SysDic> degreeList = new ArrayList<>();
    @Transient
    private List<SysDic> trainingModeList = new ArrayList<>();
    @Transient
    private List<SysDic> registerTypeList = new ArrayList<>();
    @Transient
    private List<SysDic> jpLevelList = new ArrayList<>();
    @Transient
    private List<SysDic> enLevelList = new ArrayList<>();
    @Transient
    private List<SysDic> nationList = new ArrayList<>();
    @Transient
    private List<SysDic> countryList = new ArrayList<>();

    @Transient
    private List<SysDic> ismarriedList = new ArrayList<>();
    @Transient
    private List<SysDic> hasbabyList = new ArrayList<>();
    @Transient
    private List<SysDic> ispartiedList = new ArrayList<>();

    @Transient
    private List<SysDic> validList = new ArrayList<>();
    @Transient
    private List<SysDic> departmentList = new ArrayList<>();
    @Transient
    private List<SysDic> dutyList = new ArrayList<>();
    @Transient
    private List<SysDic> tLevelList = new ArrayList<>();
    @Transient
    private List<SysDic> studentLineList = new ArrayList<>();

    @Transient
    private List<String> sexIdList = new ArrayList<>();
    @Transient
    private List<String> jobStatusIdList = new ArrayList<>();
    @Transient
    private List<String> yesNoIdList = new ArrayList<>();
    @Transient
    private List<String> educationIdList = new ArrayList<>();
    @Transient
    private List<String> degreeIdList = new ArrayList<>();
    @Transient
    private List<String> trainingModeIdList = new ArrayList<>();
    @Transient
    private List<String> registerTypeIdList = new ArrayList<>();
    @Transient
    private List<String> jpLevelIdList = new ArrayList<>();
    @Transient
    private List<String> enLevelIdList = new ArrayList<>();
    @Transient
    private List<String> nationIdList = new ArrayList<>();
    @Transient
    private List<String> countryIdList = new ArrayList<>();

    @Transient
    private List<String> ismarriedIdList = new ArrayList<>();
    @Transient
    private List<String> hasbabyIdList = new ArrayList<>();
    @Transient
    private List<String> ispartiedIdList = new ArrayList<>();

    @Transient
    private List<String> validIdList = new ArrayList<>();
    @Transient
    private List<String> departmentIdList = new ArrayList<>();
    @Transient
    private List<String> dutyIdList = new ArrayList<>();
    @Transient
    private List<String> tLevelIdList = new ArrayList<>();
    @Transient
    private List<String> studentLineIdList = new ArrayList<>();

    @Transient
    private List<BusProject> busProjectList = new ArrayList<>();
    @Transient
    private List<BusProjectExp> busProjectExpList = new ArrayList<>();
    @Transient
    private List<BusJpExp> busJpExpList = new ArrayList<>();

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

    @Transient
    private List<String> devLanguageIdList = new ArrayList<>();
    @Transient
    private List<String> operateSysIdList = new ArrayList<>();
    @Transient
    private List<String> devToolIdList = new ArrayList<>();
    @Transient
    private List<String> devDatabaseIdList = new ArrayList<>();
    @Transient
    private List<String> devAppServerIdList = new ArrayList<>();
    @Transient
    private List<String> devFrameworkIdList = new ArrayList<>();
    @Transient
    private List<String> serviceCustomerIdList = new ArrayList<>();
    @Transient
    private List<String> busTypeIdList = new ArrayList<>();

    @Transient
    private String selectedProjectId;

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

    public String getNameSpell() {
        return nameSpell;
    }

    public void setNameSpell(String nameSpell) {
        this.nameSpell = nameSpell;
    }

    public String getNameKana() {
        return nameKana;
    }

    public void setNameKana(String nameKana) {
        this.nameKana = nameKana;
    }

    public String getNameJp() {
        return nameJp;
    }

    public void setNameJp(String nameJp) {
        this.nameJp = nameJp;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getJoinDay() {
        return joinDay;
    }

    public void setJoinDay(Date joinDay) {
        this.joinDay = joinDay;
    }

    public String getJoinDayStart() {
        return joinDayStart;
    }

    public void setJoinDayStart(String joinDayStart) {
        this.joinDayStart = joinDayStart;
    }

    public String getJoinDayEnd() {
        return joinDayEnd;
    }

    public void setJoinDayEnd(String joinDayEnd) {
        this.joinDayEnd = joinDayEnd;
    }

    public Date getPracticeStartDate() {
        return practiceStartDate;
    }

    public void setPracticeStartDate(Date practiceStartDate) {
        this.practiceStartDate = practiceStartDate;
    }

    public String getPracticeStartDateStart() {
        return practiceStartDateStart;
    }

    public void setPracticeStartDateStart(String practiceStartDateStart) {
        this.practiceStartDateStart = practiceStartDateStart;
    }

    public String getPracticeStartDateEnd() {
        return practiceStartDateEnd;
    }

    public void setPracticeStartDateEnd(String practiceStartDateEnd) {
        this.practiceStartDateEnd = practiceStartDateEnd;
    }

    public Date getPracticeEndDate() {
        return practiceEndDate;
    }

    public void setPracticeEndDate(Date practiceEndDate) {
        this.practiceEndDate = practiceEndDate;
    }

    public String getPracticeEndDateStart() {
        return practiceEndDateStart;
    }

    public void setPracticeEndDateStart(String practiceEndDateStart) {
        this.practiceEndDateStart = practiceEndDateStart;
    }

    public String getPracticeEndDateEnd() {
        return practiceEndDateEnd;
    }

    public void setPracticeEndDateEnd(String practiceEndDateEnd) {
        this.practiceEndDateEnd = practiceEndDateEnd;
    }

    public Date getTrialStartDate() {
        return trialStartDate;
    }

    public void setTrialStartDate(Date trialStartDate) {
        this.trialStartDate = trialStartDate;
    }

    public String getTrialStartDateStart() {
        return trialStartDateStart;
    }

    public void setTrialStartDateStart(String trialStartDateStart) {
        this.trialStartDateStart = trialStartDateStart;
    }

    public String getTrialStartDateEnd() {
        return trialStartDateEnd;
    }

    public void setTrialStartDateEnd(String trialStartDateEnd) {
        this.trialStartDateEnd = trialStartDateEnd;
    }

    public Date getTrialEndDate() {
        return trialEndDate;
    }

    public void setTrialEndDate(Date trialEndDate) {
        this.trialEndDate = trialEndDate;
    }

    public String getTrialEndDateStart() {
        return trialEndDateStart;
    }

    public void setTrialEndDateStart(String trialEndDateStart) {
        this.trialEndDateStart = trialEndDateStart;
    }

    public String getTrialEndDateEnd() {
        return trialEndDateEnd;
    }

    public void setTrialEndDateEnd(String trialEndDateEnd) {
        this.trialEndDateEnd = trialEndDateEnd;
    }

    public Integer getTrialResult() {
        return trialResult;
    }

    public void setTrialResult(Integer trialResult) {
        this.trialResult = trialResult;
    }

    public Date getFormalDate() {
        return formalDate;
    }

    public void setFormalDate(Date formalDate) {
        this.formalDate = formalDate;
    }

    public String getFormalDateStart() {
        return formalDateStart;
    }

    public void setFormalDateStart(String formalDateStart) {
        this.formalDateStart = formalDateStart;
    }

    public String getFormalDateEnd() {
        return formalDateEnd;
    }

    public void setFormalDateEnd(String formalDateEnd) {
        this.formalDateEnd = formalDateEnd;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public BigDecimal getBefworkAge() {
        return befworkAge;
    }

    public void setBefworkAge(BigDecimal befworkAge) {
        this.befworkAge = befworkAge;
    }

    public BigDecimal getBefworkAgeStart() {
        return befworkAgeStart;
    }

    public void setBefworkAgeStart(BigDecimal befworkAgeStart) {
        this.befworkAgeStart = befworkAgeStart;
    }

    public BigDecimal getBefworkAgeEnd() {
        return befworkAgeEnd;
    }

    public void setBefworkAgeEnd(BigDecimal befworkAgeEnd) {
        this.befworkAgeEnd = befworkAgeEnd;
    }

    public BigDecimal getAftworkAge() {
        return aftworkAge;
    }

    public void setAftworkAge(BigDecimal aftworkAge) {
        this.aftworkAge = aftworkAge;
    }

    public BigDecimal getAftworkAgeStart() {
        return aftworkAgeStart;
    }

    public void setAftworkAgeStart(BigDecimal aftworkAgeStart) {
        this.aftworkAgeStart = aftworkAgeStart;
    }

    public BigDecimal getAftworkAgeEnd() {
        return aftworkAgeEnd;
    }

    public void setAftworkAgeEnd(BigDecimal aftworkAgeEnd) {
        this.aftworkAgeEnd = aftworkAgeEnd;
    }

    public BigDecimal getWorkAgeStart() {
        return workAgeStart;
    }

    public void setWorkAgeStart(BigDecimal workAgeStart) {
        this.workAgeStart = workAgeStart;
    }

    public BigDecimal getWorkAgeEnd() {
        return workAgeEnd;
    }

    public void setWorkAgeEnd(BigDecimal workAgeEnd) {
        this.workAgeEnd = workAgeEnd;
    }

    public BigDecimal getWorkAge() {
        return workAge;
    }

    public void setWorkAge(BigDecimal workAge) {
        this.workAge = workAge;
    }

    public String getWorkDateStart() {
        return workDateStart;
    }

    public void setWorkDateStart(String workDateStart) {
        this.workDateStart = workDateStart;
    }

    public String getWorkDateEnd() {
        return workDateEnd;
    }

    public void setWorkDateEnd(String workDateEnd) {
        this.workDateEnd = workDateEnd;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getGraduateDateStart() {
        return graduateDateStart;
    }

    public void setGraduateDateStart(String graduateDateStart) {
        this.graduateDateStart = graduateDateStart;
    }

    public String getGraduateDateEnd() {
        return graduateDateEnd;
    }

    public void setGraduateDateEnd(String graduateDateEnd) {
        this.graduateDateEnd = graduateDateEnd;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getTrainingMode() {
        return trainingMode;
    }

    public void setTrainingMode(Integer trainingMode) {
        this.trainingMode = trainingMode;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUrgencyCnt() {
        return urgencyCnt;
    }

    public void setUrgencyCnt(String urgencyCnt) {
        this.urgencyCnt = urgencyCnt;
    }

    public String getUrgencyTel() {
        return urgencyTel;
    }

    public void setUrgencyTel(String urgencyTel) {
        this.urgencyTel = urgencyTel;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getRegisterAddr() {
        return registerAddr;
    }

    public void setRegisterAddr(String registerAddr) {
        this.registerAddr = registerAddr;
    }

    public Integer getRegisterType() {
        return registerType;
    }

    public void setRegisterType(Integer registerType) {
        this.registerType = registerType;
    }

    public Integer getJpLevel() {
        return jpLevel;
    }

    public void setJpLevel(Integer jpLevel) {
        this.jpLevel = jpLevel;
    }

    public Integer getEnLevel() {
        return enLevel;
    }

    public void setEnLevel(Integer enLevel) {
        this.enLevel = enLevel;
    }

    public String getSalaryCard() {
        return salaryCard;
    }

    public void setSalaryCard(String salaryCard) {
        this.salaryCard = salaryCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public Integer getNation() {
        return nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getIsmarried() {
        return ismarried;
    }

    public void setIsmarried(Integer ismarried) {
        this.ismarried = ismarried;
    }

    public Integer getHasbaby() {
        return hasbaby;
    }

    public void setHasbaby(Integer hasbaby) {
        this.hasbaby = hasbaby;
    }

    public String getDocManageMode() {
        return docManageMode;
    }

    public void setDocManageMode(String docManageMode) {
        this.docManageMode = docManageMode;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Integer getDocFee() {
        return docFee;
    }

    public void setDocFee(Integer docFee) {
        this.docFee = docFee;
    }

    public String getDocRemark() {
        return docRemark;
    }

    public void setDocRemark(String docRemark) {
        this.docRemark = docRemark;
    }

    public Integer getIspartied() {
        return ispartied;
    }

    public void setIspartied(Integer ispartied) {
        this.ispartied = ispartied;
    }

    public Date getPartiedDate() {
        return partiedDate;
    }

    public void setPartiedDate(Date partiedDate) {
        this.partiedDate = partiedDate;
    }

    public String getPartiedRls() {
        return partiedRls;
    }

    public void setPartiedRls(String partiedRls) {
        this.partiedRls = partiedRls;
    }

    public String getPartiedRls1() {
        return partiedRls1;
    }

    public void setPartiedRls1(String partiedRls1) {
        this.partiedRls1 = partiedRls1;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Integer getSalaryStatus() {
        return salaryStatus;
    }

    public void setSalaryStatus(Integer salaryStatus) {
        this.salaryStatus = salaryStatus;
    }

    public String getDocBoxNo() {
        return docBoxNo;
    }

    public void setDocBoxNo(String docBoxNo) {
        this.docBoxNo = docBoxNo;
    }

    public BigDecimal getPracticeFee() {
        return practiceFee;
    }

    public void setPracticeFee(BigDecimal practiceFee) {
        this.practiceFee = practiceFee;
    }

    public BigDecimal getTrialFee() {
        return trialFee;
    }

    public void setTrialFee(BigDecimal trialFee) {
        this.trialFee = trialFee;
    }

    public BigDecimal getFormalFeeBottom() {
        return formalFeeBottom;
    }

    public void setFormalFeeBottom(BigDecimal formalFeeBottom) {
        this.formalFeeBottom = formalFeeBottom;
    }

    public BigDecimal getFormalFeeTop() {
        return formalFeeTop;
    }

    public void setFormalFeeTop(BigDecimal formalFeeTop) {
        this.formalFeeTop = formalFeeTop;
    }

    public BigDecimal getFormalFee() {
        return formalFee;
    }

    public void setFormalFee(BigDecimal formalFee) {
        this.formalFee = formalFee;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Integer getDuty() {
        return duty;
    }

    public void setDuty(Integer duty) {
        this.duty = duty;
    }

    public BigDecimal getCmpbefworkAge() {
        return cmpbefworkAge;
    }

    public void setCmpbefworkAge(BigDecimal cmpbefworkAge) {
        this.cmpbefworkAge = cmpbefworkAge;
    }

    public BigDecimal getCmpbefworkAgeStart() {
        return cmpbefworkAgeStart;
    }

    public void setCmpbefworkAgeStart(BigDecimal cmpbefworkAgeStart) {
        this.cmpbefworkAgeStart = cmpbefworkAgeStart;
    }

    public BigDecimal getCmpbefworkAgeEnd() {
        return cmpbefworkAgeEnd;
    }

    public void setCmpbefworkAgeEnd(BigDecimal cmpbefworkAgeEnd) {
        this.cmpbefworkAgeEnd = cmpbefworkAgeEnd;
    }

    public Integer gettLevel() {
        return tLevel;
    }

    public void settLevel(Integer tLevel) {
        this.tLevel = tLevel;
    }

    public Integer getStudentLine() {
        return studentLine;
    }

    public void setStudentLine(Integer studentLine) {
        this.studentLine = studentLine;
    }

    public List<SysDic> getSexList() {
        return sexList;
    }

    public void setSexList(List<SysDic> sexList) {
        this.sexList = sexList;
    }

    public List<SysDic> getJobStatusList() {
        return jobStatusList;
    }

    public void setJobStatusList(List<SysDic> jobStatusList) {
        this.jobStatusList = jobStatusList;
    }

    public List<SysDic> getYesNoList() {
        return yesNoList;
    }

    public void setYesNoList(List<SysDic> yesNoList) {
        this.yesNoList = yesNoList;
    }

    public List<SysDic> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<SysDic> educationList) {
        this.educationList = educationList;
    }

    public List<SysDic> getDegreeList() {
        return degreeList;
    }

    public void setDegreeList(List<SysDic> degreeList) {
        this.degreeList = degreeList;
    }

    public List<SysDic> getTrainingModeList() {
        return trainingModeList;
    }

    public void setTrainingModeList(List<SysDic> trainingModeList) {
        this.trainingModeList = trainingModeList;
    }

    public List<SysDic> getRegisterTypeList() {
        return registerTypeList;
    }

    public void setRegisterTypeList(List<SysDic> registerTypeList) {
        this.registerTypeList = registerTypeList;
    }

    public List<SysDic> getJpLevelList() {
        return jpLevelList;
    }

    public void setJpLevelList(List<SysDic> jpLevelList) {
        this.jpLevelList = jpLevelList;
    }

    public List<SysDic> getEnLevelList() {
        return enLevelList;
    }

    public void setEnLevelList(List<SysDic> enLevelList) {
        this.enLevelList = enLevelList;
    }

    public List<SysDic> getNationList() {
        return nationList;
    }

    public void setNationList(List<SysDic> nationList) {
        this.nationList = nationList;
    }

    public List<SysDic> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<SysDic> countryList) {
        this.countryList = countryList;
    }

    public List<SysDic> getIsmarriedList() {
        return ismarriedList;
    }

    public void setIsmarriedList(List<SysDic> ismarriedList) {
        this.ismarriedList = ismarriedList;
    }

    public List<SysDic> getHasbabyList() {
        return hasbabyList;
    }

    public void setHasbabyList(List<SysDic> hasbabyList) {
        this.hasbabyList = hasbabyList;
    }

    public List<SysDic> getIspartiedList() {
        return ispartiedList;
    }

    public void setIspartiedList(List<SysDic> ispartiedList) {
        this.ispartiedList = ispartiedList;
    }

    public List<SysDic> getValidList() {
        return validList;
    }

    public void setValidList(List<SysDic> validList) {
        this.validList = validList;
    }

    public List<SysDic> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<SysDic> departmentList) {
        this.departmentList = departmentList;
    }

    public List<SysDic> getDutyList() {
        return dutyList;
    }

    public void setDutyList(List<SysDic> dutyList) {
        this.dutyList = dutyList;
    }

    public List<SysDic> gettLevelList() {
        return tLevelList;
    }

    public void settLevelList(List<SysDic> tLevelList) {
        this.tLevelList = tLevelList;
    }

    public List<SysDic> getStudentLineList() {
        return studentLineList;
    }

    public void setStudentLineList(List<SysDic> studentLineList) {
        this.studentLineList = studentLineList;
    }

    public List<String> getSexIdList() {
        return sexIdList;
    }

    public void setSexIdList(List<String> sexIdList) {
        this.sexIdList = sexIdList;
    }

    public List<String> getJobStatusIdList() {
        return jobStatusIdList;
    }

    public void setJobStatusIdList(List<String> jobStatusIdList) {
        this.jobStatusIdList = jobStatusIdList;
    }

    public List<String> getYesNoIdList() {
        return yesNoIdList;
    }

    public void setYesNoIdList(List<String> yesNoIdList) {
        this.yesNoIdList = yesNoIdList;
    }

    public List<String> getEducationIdList() {
        return educationIdList;
    }

    public void setEducationIdList(List<String> educationIdList) {
        this.educationIdList = educationIdList;
    }

    public List<String> getDegreeIdList() {
        return degreeIdList;
    }

    public void setDegreeIdList(List<String> degreeIdList) {
        this.degreeIdList = degreeIdList;
    }

    public List<String> getTrainingModeIdList() {
        return trainingModeIdList;
    }

    public void setTrainingModeIdList(List<String> trainingModeIdList) {
        this.trainingModeIdList = trainingModeIdList;
    }

    public List<String> getRegisterTypeIdList() {
        return registerTypeIdList;
    }

    public void setRegisterTypeIdList(List<String> registerTypeIdList) {
        this.registerTypeIdList = registerTypeIdList;
    }

    public List<String> getJpLevelIdList() {
        return jpLevelIdList;
    }

    public void setJpLevelIdList(List<String> jpLevelIdList) {
        this.jpLevelIdList = jpLevelIdList;
    }

    public List<String> getEnLevelIdList() {
        return enLevelIdList;
    }

    public void setEnLevelIdList(List<String> enLevelIdList) {
        this.enLevelIdList = enLevelIdList;
    }

    public List<String> getNationIdList() {
        return nationIdList;
    }

    public void setNationIdList(List<String> nationIdList) {
        this.nationIdList = nationIdList;
    }

    public List<String> getCountryIdList() {
        return countryIdList;
    }

    public void setCountryIdList(List<String> countryIdList) {
        this.countryIdList = countryIdList;
    }

    public List<String> getIsmarriedIdList() {
        return ismarriedIdList;
    }

    public void setIsmarriedIdList(List<String> ismarriedIdList) {
        this.ismarriedIdList = ismarriedIdList;
    }

    public List<String> getHasbabyIdList() {
        return hasbabyIdList;
    }

    public void setHasbabyIdList(List<String> hasbabyIdList) {
        this.hasbabyIdList = hasbabyIdList;
    }

    public List<String> getIspartiedIdList() {
        return ispartiedIdList;
    }

    public void setIspartiedIdList(List<String> ispartiedIdList) {
        this.ispartiedIdList = ispartiedIdList;
    }

    public List<String> getValidIdList() {
        return validIdList;
    }

    public void setValidIdList(List<String> validIdList) {
        this.validIdList = validIdList;
    }

    public List<String> getDepartmentIdList() {
        return departmentIdList;
    }

    public void setDepartmentIdList(List<String> departmentIdList) {
        this.departmentIdList = departmentIdList;
    }

    public List<String> getDutyIdList() {
        return dutyIdList;
    }

    public void setDutyIdList(List<String> dutyIdList) {
        this.dutyIdList = dutyIdList;
    }

    public List<String> gettLevelIdList() {
        return tLevelIdList;
    }

    public void settLevelIdList(List<String> tLevelIdList) {
        this.tLevelIdList = tLevelIdList;
    }

    public List<String> getStudentLineIdList() {
        return studentLineIdList;
    }

    public void setStudentLineIdList(List<String> studentLineIdList) {
        this.studentLineIdList = studentLineIdList;
    }

    public List<BusProject> getBusProjectList() {
        return busProjectList;
    }

    public void setBusProjectList(List<BusProject> busProjectList) {
        this.busProjectList = busProjectList;
    }

    public List<BusProjectExp> getBusProjectExpList() {
        return busProjectExpList;
    }

    public void setBusProjectExpList(List<BusProjectExp> busProjectExpList) {
        this.busProjectExpList = busProjectExpList;
    }

    public List<BusJpExp> getBusJpExpList() {
        return busJpExpList;
    }

    public void setBusJpExpList(List<BusJpExp> busJpExpList) {
        this.busJpExpList = busJpExpList;
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

    public List<String> getDevLanguageIdList() {
        return devLanguageIdList;
    }

    public void setDevLanguageIdList(List<String> devLanguageIdList) {
        this.devLanguageIdList = devLanguageIdList;
    }

    public List<String> getOperateSysIdList() {
        return operateSysIdList;
    }

    public void setOperateSysIdList(List<String> operateSysIdList) {
        this.operateSysIdList = operateSysIdList;
    }

    public List<String> getDevToolIdList() {
        return devToolIdList;
    }

    public void setDevToolIdList(List<String> devToolIdList) {
        this.devToolIdList = devToolIdList;
    }

    public List<String> getDevDatabaseIdList() {
        return devDatabaseIdList;
    }

    public void setDevDatabaseIdList(List<String> devDatabaseIdList) {
        this.devDatabaseIdList = devDatabaseIdList;
    }

    public List<String> getDevAppServerIdList() {
        return devAppServerIdList;
    }

    public void setDevAppServerIdList(List<String> devAppServerIdList) {
        this.devAppServerIdList = devAppServerIdList;
    }

    public List<String> getDevFrameworkIdList() {
        return devFrameworkIdList;
    }

    public void setDevFrameworkIdList(List<String> devFrameworkIdList) {
        this.devFrameworkIdList = devFrameworkIdList;
    }

    public List<String> getServiceCustomerIdList() {
        return serviceCustomerIdList;
    }

    public void setServiceCustomerIdList(List<String> serviceCustomerIdList) {
        this.serviceCustomerIdList = serviceCustomerIdList;
    }

    public List<String> getBusTypeIdList() {
        return busTypeIdList;
    }

    public void setBusTypeIdList(List<String> busTypeIdList) {
        this.busTypeIdList = busTypeIdList;
    }

    public String getSelectedProjectId() {
        return selectedProjectId;
    }

    public void setSelectedProjectId(String selectedProjectId) {
        this.selectedProjectId = selectedProjectId;
    }
}
