package com.zhongji.master.android.phone.entity;

import java.io.Serializable;

/**
 * 用户信息
 * @author Admin
 *
 */


public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String realName;
	private String userToken;
	private String deviceToken;
	private String isFaceRegister;
	private String faceCount;
	private String loginStatus;
	private String userType;
	private String sessionStartTime;
	private String loginTimes;
	private String lastLoginTime;
	private String failedTimes;
	private String forbidEndTime;
	private String forbidStartTime;
	private String hasCompany;
	private String imageLocation;
	
	
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
