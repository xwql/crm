package cn.crm.bean;

import java.util.Date;

public class CustomerStatus {
    private Long custId;

    private String custStatus;

    private String deletereason;

    private String remark;

    private Date deletetime;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus == null ? null : custStatus.trim();
    }

    public String getDeletereason() {
        return deletereason;
    }

    public void setDeletereason(String deletereason) {
        this.deletereason = deletereason == null ? null : deletereason.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }
}
