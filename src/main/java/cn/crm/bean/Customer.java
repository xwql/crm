package cn.crm.bean;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
	private Long custId;
	private String custName;
	private Long custUserId;
	private Long custCreateId;
	private String custSource;
	private String custIndustry;
	private String custLevel;
	private String custLinkman;
	private String custPhone;
	private String custEmail;
	private String custZipcode;
	private String custAddress;
	private Date custCreatetime;
	private Integer start;
	private Integer rows;
	public String getCustZipcode() {
		return custZipcode;
	}
	public void setCustZipcode(String custZipcode) {
		this.custZipcode = custZipcode;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
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
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Long getCustUserId() {
		return custUserId;
	}
	public void setCustUserId(Long custUserId) {
		this.custUserId = custUserId;
	}
	public Long getCustCreateId() {
		return custCreateId;
	}
	public void setCustCreateId(Long custCreateId) {
		this.custCreateId = custCreateId;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustLinkman() {
		return custLinkman;
	}
	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custMobile) {
		this.custEmail = custMobile;
	}
	public Date getCustCreatetime() {
		return custCreatetime;
	}
	public void setCustCreatetime(Date custCreatetime) {
		this.custCreatetime = custCreatetime;
	}
	
}
