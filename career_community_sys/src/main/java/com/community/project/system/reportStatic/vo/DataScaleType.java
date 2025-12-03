package com.community.project.system.reportStatic.vo;

/**
 * @BelongsProject: ruoyi
 * @BelongsPackage: com.community.project.system.reportStatic.vo
 * @Author: author
 * @CreateTime: 2025-02-13  13:27
 * @Description: TODO
 * @Version: 1.0
 */

public class DataScaleType {

    private String type;
    private Long total;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
    public DataScaleType() {
    }

    public DataScaleType(String type, Long total) {
        this.type = type;
        this.total = total;
    }

    @Override
    public String toString() {
        return "DataScaleType{" +
                "type='" + type + '\'' +
                ", total=" + total +
                '}';
    }
}
