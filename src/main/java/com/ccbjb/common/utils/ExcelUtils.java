package com.ccbjb.common.utils;

import com.ccbjb.common.consts.Const;
import com.ccbjb.common.domain.BusStaff;
import com.ccbjb.common.utils.excel.ExcelReader;
import com.ccbjb.common.utils.excel.PoiExcelReader;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static List<BusStaff> readFileToVo(MultipartFile excelFile) {
        List<BusStaff> busStaffList = new ArrayList<BusStaff>();
        try {
            ExcelReader reader = new PoiExcelReader(excelFile.getBytes());
            List<String[]> rows = reader.read();
            for(int i = 1; i<rows.size(); i++) {
                String[] cells = rows.get(i);
                BusStaff busStaff = new BusStaff();
                busStaff.setStaffNo(cells[0]);
                busStaff.setName(cells[1]);
                busStaff.setNameSpell(cells[2]);
                if(Const.SexEnum.MALE.getValue().equals(cells[3])) {
                    busStaff.setSex(Const.SexEnum.MALE.getCode());
                }else if(Const.SexEnum.FEMALE.getValue().equals(cells[3])){
                    busStaff.setSex(Const.SexEnum.FEMALE.getCode());
                }
                if(StringUtils.isNotBlank(cells[4])) {
                    busStaff.setBirthday(DateTimeUtil.strToDate(cells[4] + Const.DATE_SUFFIX));
                }
                if(StringUtils.isNotBlank(cells[5])) {
                    busStaff.setJoinDay(DateTimeUtil.strToDate(cells[5] + Const.DATE_SUFFIX));
                }
                if(StringUtils.isNotBlank(cells[6])) {
                    busStaff.setPracticeStartDate(DateTimeUtil.strToDate(cells[6] + Const.DATE_SUFFIX));
                    busStaff.setPracticeEndDate(DateTimeUtil.strToDate(cells[6] + Const.DATE_SUFFIX));
                }
                if(StringUtils.isNotBlank(cells[7])) {
                    busStaff.setTrialStartDate(DateTimeUtil.strToDate(cells[7] + Const.DATE_SUFFIX));
                    busStaff.setTrialEndDate(DateTimeUtil.strToDate(cells[7] + Const.DATE_SUFFIX));
                }
                if(Const.TrialResultEnum.FORMAL.getValue().equals(cells[8])) {
                    busStaff.setTrialResult(Const.TrialResultEnum.FORMAL.getCode());
                }else{
                    busStaff.setTrialResult(Const.TrialResultEnum.LEAVE.getCode());
                }
                if(StringUtils.isNotBlank(cells[9])) {
                    busStaff.setFormalDate(DateTimeUtil.strToDate(cells[9] + Const.DATE_SUFFIX));
                }

                if (Const.JobStatusEnum.ATJOB.getValue().equals(cells[10])) {
                    busStaff.setJobStatus(Const.JobStatusEnum.ATJOB.getCode());
                }else if(Const.JobStatusEnum.LEAVEJOB.getValue().equals(cells[10])) {
                    busStaff.setJobStatus(Const.JobStatusEnum.LEAVEJOB.getCode());
                }
                busStaff.setBefworkAge(new BigDecimal(cells[11]));
                busStaff.setAftworkAge(new BigDecimal(cells[12]));
                busStaff.setWorkAge(new BigDecimal(cells[13]));
                if(StringUtils.isNotBlank(cells[14])) {
                    busStaff.setWorkDate(DateTimeUtil.strToDate(cells[14] + Const.DATE_SUFFIX));
                }
                if(StringUtils.isNotBlank(cells[15])) {
                    busStaff.setGraduateDate(DateTimeUtil.strToDate(cells[15] + Const.DATE_SUFFIX));
                }
                busStaff.setGraduateSchool(cells[16]);
                if(Const.EducationEnum.JUNIOR_COLLEGE.getValue().equals(cells[17])) {
                    busStaff.setEducation(Const.EducationEnum.JUNIOR_COLLEGE.getCode());
                }else if(Const.EducationEnum.RAGULAR_COLLEGE.getValue().equals(cells[17])){
                    busStaff.setEducation(Const.EducationEnum.RAGULAR_COLLEGE.getCode());
                }else if(Const.EducationEnum.GRADUATE_COLLEGE.getValue().equals(cells[17])){
                    busStaff.setEducation(Const.EducationEnum.GRADUATE_COLLEGE.getCode());
                }
                if(Const.TrainingModeEnum.UNIFY.getValue().equals(cells[18])) {
                    busStaff.setTrainingMode(Const.TrainingModeEnum.UNIFY.getCode());
                }else if(Const.TrainingModeEnum.OTHER.getValue().equals(cells[18])){
                    busStaff.setTrainingMode(Const.TrainingModeEnum.OTHER.getCode());
                }
                busStaff.setMajor(cells[19]);
                if(Const.DegreeEnum.BACHELOR.getValue().equals(cells[20])) {
                    busStaff.setDegree(Const.DegreeEnum.BACHELOR.getCode());
                }else if(Const.DegreeEnum.MASTER.getValue().equals(cells[20])){
                    busStaff.setDegree(Const.DegreeEnum.MASTER.getCode());
                }
                busStaff.setEmail(cells[21]);
                busStaff.setTel(cells[22]);
                busStaff.setUrgencyCnt(cells[23]);
                busStaff.setUrgencyTel(cells[24]);
                busStaff.setHomeAddr(cells[25]);
                busStaff.setAddr(cells[26]);
                busStaff.setRegisterAddr(cells[27]);

                if(Const.RegisterTypeEnum.CITY.getValue().equals(cells[28])) {
                    busStaff.setRegisterType(Const.RegisterTypeEnum.CITY.getCode());
                }else if(Const.RegisterTypeEnum.VILLAGE.getValue().equals(cells[28])) {
                    busStaff.setRegisterType(Const.RegisterTypeEnum.VILLAGE.getCode());
                }

                if(Const.JpLevelEnum.N4.getValue().equals(cells[29])) {
                    busStaff.setJpLevel(Const.JpLevelEnum.N4.getCode());
                }else if(Const.JpLevelEnum.N3.getValue().equals(cells[29])){
                    busStaff.setJpLevel(Const.JpLevelEnum.N3.getCode());
                }else if(Const.JpLevelEnum.N2.getValue().equals(cells[29])){
                    busStaff.setJpLevel(Const.JpLevelEnum.N2.getCode());
                }else if(Const.JpLevelEnum.N1.getValue().equals(cells[29])){
                    busStaff.setJpLevel(Const.JpLevelEnum.N1.getCode());
                }else {
                    busStaff.setJpLevel(Const.JpLevelEnum.OTHER.getCode());
                }

                if (Const.EnLevelEnum.CET4.getValue().equals(cells[30])) {
                    busStaff.setEnLevel(Const.EnLevelEnum.CET4.getCode());
                }else if(Const.EnLevelEnum.CET6.getValue().equals(cells[30])) {
                    busStaff.setEnLevel(Const.EnLevelEnum.CET6.getCode());
                }else if(Const.EnLevelEnum.TEM8.getValue().equals(cells[30])) {
                    busStaff.setEnLevel(Const.EnLevelEnum.TEM8.getCode());
                }else {
                    busStaff.setEnLevel(Const.EnLevelEnum.OTHER.getCode());
                }

                busStaff.setSalaryCard(cells[31]);
                busStaff.setIdCard(cells[32]);
                busStaff.setProfessional(cells[33]);
                busStaff.setDoorNo(cells[34]);
                busStaff.setCheckNo(cells[35]);

                if (Const.NationEnum.HANZU.getValue().equals(cells[36])) {
                    busStaff.setNation(Const.NationEnum.HANZU.getCode());
                }else if(Const.NationEnum.MANZU.getValue().equals(cells[36])) {
                    busStaff.setNation(Const.NationEnum.MANZU.getCode());
                }else if(Const.NationEnum.CHAOXIANZU.getValue().equals(cells[36])) {
                    busStaff.setNation(Const.NationEnum.CHAOXIANZU.getCode());
                }else {
                    busStaff.setNation(Const.NationEnum.OTHER.getCode());
                }

                if (Const.CountryEnum.CHN.getValue().equals(cells[37])) {
                    busStaff.setCountry(Const.CountryEnum.CHN.getCode());
                }else if(Const.CountryEnum.JP.getValue().equals(cells[37])){
                    busStaff.setCountry(Const.CountryEnum.JP.getCode());
                }else {
                    busStaff.setCountry(Const.CountryEnum.OTHER.getCode());
                }

                if (Const.IsMarriedEnum.UNMARRIED.getValue().equals(cells[38])) {
                    busStaff.setIsmarried(Const.IsMarriedEnum.UNMARRIED.getCode());
                }else if(Const.IsMarriedEnum.MARRIED.getValue().equals(cells[38])){
                    busStaff.setIsmarried(Const.IsMarriedEnum.MARRIED.getCode());
                }

                if (Const.HasBabyEnum.UNHASBABY.getValue().equals(cells[39])) {
                    busStaff.setHasbaby(Const.HasBabyEnum.UNHASBABY.getCode());
                }else if(Const.HasBabyEnum.HASBABY.getValue().equals(cells[39])){
                    busStaff.setHasbaby(Const.HasBabyEnum.HASBABY.getCode());
                }

                busStaff.setDocManageMode(cells[40]);
                busStaff.setDocNo(cells[41]);
                if(Const.DocFeeEnum.SELF.getValue().equals(cells[42])){
                    busStaff.setDocFee(Const.DocFeeEnum.SELF.getCode());
                }else {
                    busStaff.setDocFee(Const.DocFeeEnum.OTHER.getCode());
                }
                busStaff.setDocRemark(cells[43]);

                if (Const.IsPartiedEnum.UNPARTIED.getValue().equals(cells[44])) {
                    busStaff.setIspartied(Const.IsPartiedEnum.UNPARTIED.getCode());
                }else if(Const.IsPartiedEnum.PARTIED.getValue().equals(cells[44])){
                    busStaff.setIspartied(Const.IsPartiedEnum.PARTIED.getCode());
                }
                if(StringUtils.isNotBlank(cells[45])) {
                    busStaff.setPartiedDate(DateTimeUtil.strToDate(cells[45] + Const.DATE_SUFFIX));
                }
                busStaff.setPartiedRls(cells[46]);
                busStaff.setPartiedRls1(cells[47]);
                busStaff.setPassportNo(cells[48]);
                if (Const.SalaryStatusEnum.NORMAL.getValue().equals(cells[49])) {
                    busStaff.setSalaryStatus(Const.SalaryStatusEnum.NORMAL.getCode());
                }else if(Const.SalaryStatusEnum.FREEZE.getValue().equals(cells[49])) {
                    busStaff.setSalaryStatus(Const.SalaryStatusEnum.FREEZE.getCode());
                }
                busStaff.setDocBoxNo(cells[50]);
                busStaff.setPracticeFee(new BigDecimal(cells[51]));
                busStaff.setTrialFee(new BigDecimal(cells[52]));
                busStaff.setFormalFeeBottom(new BigDecimal(cells[53]));
                busStaff.setFormalFeeTop(new BigDecimal(cells[54]));
                busStaff.setFormalFee(new BigDecimal(cells[55]));
                if (Const.DepartmentEnum.MYT.getValue().equals(cells[56])) {
                    busStaff.setDepartment(Const.DepartmentEnum.MYT.getCode());
                }else if(Const.DepartmentEnum.NRI.getValue().equals(cells[56])){
                    busStaff.setDepartment(Const.DepartmentEnum.NRI.getCode());
                }else if(Const.DepartmentEnum.FINANCE.getValue().equals(cells[56])){
                    busStaff.setDepartment(Const.DepartmentEnum.FINANCE.getCode());
                }else if(Const.DepartmentEnum.ADMIN.getValue().equals(cells[56])) {
                    busStaff.setDepartment(Const.DepartmentEnum.ADMIN.getCode());
                }else if(Const.DepartmentEnum.NET.getValue().equals(cells[56])){
                    busStaff.setDepartment(Const.DepartmentEnum.NET.getCode());
                }else {
                    busStaff.setDepartment(Const.DepartmentEnum.OTHER.getCode());
                }
                if(StringUtils.isNotBlank(cells[57])) {
                    busStaff.setLeaveDate(DateTimeUtil.strToDate(cells[57] + Const.DATE_SUFFIX));
                }

                busStaffList.add(busStaff);
            }

        }catch (Exception e){

        }
        return busStaffList;
    }
}
