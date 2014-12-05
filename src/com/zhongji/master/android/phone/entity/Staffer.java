package com.zhongji.master.android.phone.entity;

import java.io.Serializable;

public class Staffer implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userid;//用户id
	private String realName;//真实姓名
	private String userName;//用户昵称
	private String department;//部门
	private String duties;//
	private String userIamge;//用户头像
	private String isFocused;//
	private String id;//
	private String createdTime;//
	private String updatedTime;//
	private String comments;//
	private String companyId;//公司id
	private String projectStage = "1";
	private String projectVersion;//版本号

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public String getUserIamge() {
		return userIamge;
	}

	public void setUserIamge(String userIamge) {
		this.userIamge = userIamge;
	}

	public String getIsFocused() {
		return isFocused;
	}

	public void setIsFocused(String isFocused) {
		this.isFocused = isFocused;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "Project [userid=" + userid + ", realName=" + realName
				+ ", userName=" + userName + ", department=" + department
				+ ", duties=" + duties + ", userIamge=" + userIamge
				+ ", isFocused=" + isFocused + "," + " id=" + id
				+ ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + ", comments=" + comments + ", companyId="
				+ companyId + "]";
	}

}
