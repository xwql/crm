package cn.crm.bean;

import java.io.Serializable;

public class BaseDict implements Serializable {
    private Long id;

    private String type_code;

    private String type_name;

    private String item_name;

    private Integer dict_sort;

    private Integer dict_enable;

    private String remark;

    private Integer start;
    private Integer rows;
    public Integer getStart() {
        return start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }
    public Integer getRows() {
        return rows;
    }
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Long getId() {
        return id;
    }

    public String getType_code() {
        return type_code;
    }

    public String getType_name() {
        return type_name;
    }

    public String getItem_name() {
        return item_name;
    }

    public Integer getDict_sort() {
        return dict_sort;
    }

    public Integer getDict_enable() {
        return dict_enable;
    }

    public String getRemark() {
        return remark;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setDict_sort(Integer dict_sort) {
        this.dict_sort = dict_sort;
    }

    public void setDict_enable(Integer dict_enable) {
        this.dict_enable = dict_enable;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

