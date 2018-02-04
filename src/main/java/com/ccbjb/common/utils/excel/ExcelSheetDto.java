package com.ccbjb.common.utils.excel;
import java.util.Collection;

public class ExcelSheetDto<T> {
    private String sheetname;
    private Collection<T> dataset;

    public String getSheetname() {
        return sheetname;
    }

    public void setSheetname(String sheetname) {
        this.sheetname = sheetname;
    }

    public Collection<T> getDataset() {
        return dataset;
    }

    public void setDataset(Collection<T> dataset) {
        this.dataset = dataset;
    }
}
