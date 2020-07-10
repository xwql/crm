package cn.crm.bean;

import java.io.Serializable;

public class BaseDict implements Serializable {
    private Long id;

    private String typeCode;

    private String typeName;

    private String itemName;

    private Integer dictSort;

    private Integer dictEnable;

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

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public Integer getDictEnable() {
        return dictEnable;
    }

    public String getRemark() {
        return remark;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public void setDictEnable(Integer dictEnable) {
        this.dictEnable = dictEnable;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

