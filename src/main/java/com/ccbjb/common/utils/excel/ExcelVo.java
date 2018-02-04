package com.ccbjb.common.utils.excel;

import java.util.List;

public class ExcelVo {
    private String filename;
    private String outfilePath;
    private List<ExcelSheetDto> sheets;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getOutfilePath() {
        return outfilePath;
    }

    public void setOutfilePath(String outfilePath) {
        this.outfilePath = outfilePath;
    }

    public List<ExcelSheetDto> getSheets() {
        return sheets;
    }

    public void setSheets(List<ExcelSheetDto> sheets) {
        this.sheets = sheets;
    }
}
