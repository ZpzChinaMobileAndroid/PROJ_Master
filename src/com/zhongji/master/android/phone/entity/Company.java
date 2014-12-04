package com.zhongji.master.android.phone.entity;

import java.io.Serializable;

/**
 * 公司名称
 * @author Admin
 *
 */

public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String id;//公司id
	private  String companyName;//公司名字
	private  String companyAlias;//公司别名
	private  String companyContactEmail;//公司邮箱
	private  String companyDescription;//公司描述
	private  String companyIndustry;//公司行业
	private  String companyLocation;//公司位置
	private  String companyContactCellphone;//公司电话
	private  String companyContactName;//公司联系人
	private  String companyScale;//公司规模
	private  String companyType;//公司模式
	private  String companyEmployeeNumber;//公司员工数量
	private  String companyFocusNumber;//公司关注数量
	private  String companyLogo;//公司logo
	private  String reviewStatus;//回复状态
	private String projectStage = "1";
	private String projectVersion;//版本号
	private  String	focused;//
	public String id() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAlias() {
		return companyAlias;
	}
	public void setCompanyAlias(String companyAlias) {
		this.companyAlias = companyAlias;
	}
	public String getCompanyContactEmail() {
		return companyContactEmail;
	}
	public void setCompanyContactEmail(String companyContactEmail) {
		this.companyContactEmail = companyContactEmail;
	}
	public String getCompanyDescription() {
		return companyDescription;
	}
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}
	public String getCompanyIndustry() {
		return companyIndustry;
	}
	public void setCompanyIndustry(String companyIndustry) {
		this.companyIndustry = companyIndustry;
	}
	public String getCompanyLocation() {
		return companyLocation;
	}
	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}
	public String getCompanyContactCellphone() {
		return companyContactCellphone;
	}
	public void setCompanyContactCellphone(String companyContactCellphone) {
		this.companyContactCellphone = companyContactCellphone;
	}
	public String getCompanyContactName() {
		return companyContactName;
	}
	public void setCompanyContactName(String companyContactName) {
		this.companyContactName = companyContactName;
	}
	public String getCompanyScale() {
		return companyScale;
	}
	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCompanyEmployeeNumber() {
		return companyEmployeeNumber;
	}
	public void setCompanyEmployeeNumber(String companyEmployeeNumber) {
		this.companyEmployeeNumber = companyEmployeeNumber;
	}
	public String getCompanyFocusNumber() {
		return companyFocusNumber;
	}
	public void setCompanyFocusNumber(String companyFocusNumber) {
		this.companyFocusNumber = companyFocusNumber;
	}
	public String getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public String getFocused() {
		return focused;
	}
	public void setFocused(String focused) {
		this.focused = focused;
	}

	public String getProjectStage() {
		return projectStage;
	}
	public void setProjectStage(String projectStage) {
		this.projectStage = projectStage;
	}
	public String getProjectVersion() {
		return projectVersion;
	}
	public void setProjectVersion(String projectVersion) {
		this.projectVersion = projectVersion;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", companyName=" + companyName
				+ ", companyAlias=" + companyAlias + ", companyContactEmail="
				+ companyContactEmail + ", companyDescription=" + companyDescription + ", companyIndustry="
				+ companyIndustry + ", companyLocation="
				+ companyLocation + ", companyContactCellphone=" + companyContactCellphone
				+ ", companyContactName=" + companyContactName
				+ ", companyScale=" + companyScale
				+ ", companyType=" + companyType
				+ ", companyEmployeeNumber=" + companyEmployeeNumber + ", companyFocusNumber="
				+ companyFocusNumber + ", companyLogo=" + companyLogo
				+ ", reviewStatus=" + reviewStatus + ", focused=" + focused+", projectVersion=" + projectVersion+"]";
	}
	
	
}
