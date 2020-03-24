package cn.crm.bean;

import java.util.Date;

public class FollowStatus {
    private Long cust_id;

    private String cust_status;

    private String business_status;

    private Integer follow_status;

    private String cust_property;

    private Long times;
    //这两项为连接查询表格显示
    //负责人
    private Long cust_user_id;
    private String cust_user_name;
    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCust_user_name() {
        return cust_user_name;
    }

    public void setCust_user_name(String cust_user_name) {
        this.cust_user_name = cust_user_name;
    }

    //联系人
    private String cust_linkman;
    //客户名称
    private String cust_name;

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

    //分页
    private Integer start;
    private Integer rows;

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_linkman() {
        return cust_linkman;
    }

    public void setCust_linkman(String cust_linkman) {
        this.cust_linkman = cust_linkman;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_status() {
        return cust_status;
    }

    public void setCust_status(String cust_status) {
        this.cust_status = cust_status;
    }

    public String getBusiness_status() {
        return business_status;
    }

    public void setBusiness_status(String business_status) {
        this.business_status = business_status;
    }

    public Integer getFollow_status() {
        return follow_status;
    }

    public void setFollow_status(Integer follow_status) {
        this.follow_status = follow_status;
    }

    public String getCust_property() {
        return cust_property;
    }

    public void setCust_property(String cust_property) {
        this.cust_property = cust_property;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Long getCust_user_id() {
        return cust_user_id;
    }

    public void setCust_user_id(Long cust_user_id) {
        this.cust_user_id = cust_user_id;
    }
}