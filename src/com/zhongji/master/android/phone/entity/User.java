package com.zhongji.master.android.phone.entity;

import java.io.Serializable;

/**
 * 用户信息
 * @author Admin
 *
 */


public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userId;//用户id
	private String userName;//用户昵称
	private String realName;//真实姓名
	private String userToken;//用户token
	private String deviceToken;//设备token	
	private String isFaceRegister;//是否脸部注册
	private String faceCount;//脸部注册次数
	private String loginStatus;//登录状态
	private String userType;//用户类型
	private String sessionStartTime;//session开始时间
	private String loginTimes;//登录时间
	private String lastLoginTime;//最后一次登录时间
	private String failedTimes;//失败次数
	private String forbidEndTime;//禁止登出时间
	private String forbidStartTime;//禁止登录时间
	private String hasCompany;//是否有公司
	private String imageLocation;//图片路径
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	public String getIsFaceRegister() {
		return isFaceRegister;
	}
	public void setIsFaceRegister(String isFaceRegister) {
		this.isFaceRegister = isFaceRegister;
	}
	public String getFaceCount() {
		return faceCount;
	}
	public void setFaceCount(String faceCount) {
		this.faceCount = faceCount;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getSessionStartTime() {
		return sessionStartTime;
	}
	public void setSessionStartTime(String sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}
	public String getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(String loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getFailedTimes() {
		return failedTimes;
	}
	public void setFailedTimes(String failedTimes) {
		this.failedTimes = failedTimes;
	}
	public String getForbidEndTime() {
		return forbidEndTime;
	}
	public void setForbidEndTime(String forbidEndTime) {
		this.forbidEndTime = forbidEndTime;
	}
	public String getForbidStartTime() {
		return forbidStartTime;
	}
	public void setForbidStartTime(String forbidStartTime) {
		this.forbidStartTime = forbidStartTime;
	}
	public String getHasCompany() {
		return hasCompany;
	}
	public void setHasCompany(String hasCompany) {
		this.hasCompany = hasCompany;
	}
	public String getImageLocation() {
		return imageLocation;
	}
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "UserData [userId=" + userId + ", userName=" + userName
				+ ", realName=" + realName + ", userToken=" + userToken
				+ ", deviceToken=" + deviceToken + ", isFaceRegister=" + isFaceRegister
				+ ", faceCount=" + faceCount + ", loginStatus="
				+ loginStatus + ", userType=" + userType + ", sessionStartTime="
				+ sessionStartTime + ", loginTimes=" + loginTimes + ", lastLoginTime=" + lastLoginTime
				+ ", failedTimes=" + failedTimes + ", forbidEndTime=" + forbidEndTime + "," +
				" forbidStartTime="+ forbidStartTime + ", hasCompany=" + hasCompany + ", imageLocation=" + imageLocation+ " ]";
	}
	
	
	
}
