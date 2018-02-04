package com.ccbjb.common.consts;

public class Const {
    public static final String DATE_SUFFIX = " 00:00:00";
    public enum SexEnum {
        MALE(1 , "男"),
        FEMALE(0 , "女");
        private String value;
        private int code;
        SexEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum JobStatusEnum {
        ATJOB(0 , "在职"),
        LEAVEJOB(1 , "离职");
        private String value;
        private int code;
        JobStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum EducationEnum {
        JUNIOR_COLLEGE(0 , "专科"),
        RAGULAR_COLLEGE(1 , "本科"),
        GRADUATE_COLLEGE(2 , "研究生");
        private String value;
        private int code;
        EducationEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum TrainingModeEnum {
        UNIFY(0 , "统招"),
        OTHER(1 , "其他");
        private String value;
        private int code;
        TrainingModeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum DegreeEnum {
        BACHELOR(0 , "学士"),
        MASTER(1 , "硕士");
        private String value;
        private int code;
        DegreeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum RegisterTypeEnum {
        CITY(0 , "城镇"),
        VILLAGE(1 , "农村");
        private String value;
        private int code;
        RegisterTypeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum JpLevelEnum {
        OTHER(0 , "其他"),
        N4(1 , "N4"),
        N3(2 , "N3"),
        N2(3 , "N2"),
        N1(4 , "N1");
        private String value;
        private int code;
        JpLevelEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum EnLevelEnum {
        OTHER(0 , "其他"),
        CET4(1 , "四级"),
        CET6(2 , "六级"),
        TEM8(3 , "专业八级");
        private String value;
        private int code;
        EnLevelEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum NationEnum {
        OTHER(0 , "其他"),
        HANZU(1 , "汉"),
        MANZU(2 , "满"),
        CHAOXIANZU(3 , "朝鲜");
        private String value;
        private int code;
        NationEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum CountryEnum {
        OTHER(0 , "其他"),
        CHN(1 , "中国"),
        JP(2 , "日本");
        private String value;
        private int code;
        CountryEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum IsMarriedEnum {
        UNMARRIED(0 , "未婚"),
        MARRIED(1 , "已婚");
        private String value;
        private int code;
        IsMarriedEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum HasBabyEnum {
        UNHASBABY(0 , "未育"),
        HASBABY(1 , "已育");
        private String value;
        private int code;
        HasBabyEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum IsPartiedEnum {
        UNPARTIED(0 , "0"),
        PARTIED(1 , "1");
        private String value;
        private int code;
        IsPartiedEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum SalaryStatusEnum {
        NORMAL(0 , "正常"),
        FREEZE(1 , "冻结");
        private String value;
        private int code;
        SalaryStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum DepartmentEnum {
        MYT(0 , "MYT"),
        NRI(1 , "NRI"),
        OTHER(2 , "其他"),
        FINANCE(3 , "财务"),
        ADMIN(4 , "行政"),
        NET(5 , "网络");
        private String value;
        private int code;
        DepartmentEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum ServiceCustomerEnum {
        NRI(0 , "NRI"),
        MYT(1 , "明治安田");
        private String value;
        private int code;
        ServiceCustomerEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum DutyEnum {
        PG(0 , "PG"),
        SE(1 , "SE"),
        TL(2 , "TL"),
        SL(3 , "SL"),
        PL(4 , "PL"),
        PM(5 , "PM")
        ;
        private String value;
        private int code;
        DutyEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum DocFeeEnum {
        OTHER(0 , "其他"),
        SELF(1 , "自费")
        ;
        private String value;
        private int code;
        DocFeeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    public enum TrialResultEnum {
        FORMAL(0 , "转正"),
        LEAVE(1 , "离职")
        ;
        private String value;
        private int code;
        TrialResultEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

}