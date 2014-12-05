package com.zhongji.master.android.phone.entity;

import java.io.Serializable;

/**
 * 动态信息
 * @author Admin
 *
 */


public class Dynamic implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;					// 动态表id
	private String createdTime;			// 创建时间
	private String title;				//  标题
	private String imageLocation;		// 图片保存路径
	private String content;				// 内容
	private String createdBy;			// 创建人
	private String entityId;			// 相关Id
	private String category;			//  类别			Personal Company Project Product
	private String projectStage;		// 项目阶段
	private String projectName;			//  项目名称
	private String companyName;			// 公司名称 
	private String imageHeight;			// 图片高度
	private String imageSize;			//  图片大小
	private String imageWidth;			//  图片宽度
	private String userName;			//  用户名
	private String avatarUrl;			//  头像url
	private String userType;			//  用户类型
	private String eventType;			//  来源类型		1.AutomaticUpdate：表示更新了xxxx项目或者添加xxxx也是后台自动发出来的动态，更新、新建项目等  2.actives：表示个人，公司自个发的动  3.Automatic：表示后台自动产生的一条动态类型 4.AutomaticCreate：创建项目
	private String entityUrl;			//  详情url
	private String commentsCount;		//评论数
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageLocation() {
		return imageLocation;
	}
	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProjectStage() {
		return projectStage;
	}
	public void setProjectStage(String projectStage) {
		this.projectStage = projectStage;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(String imageHeight) {
		this.imageHeight = imageHeight;
	}
	public String getImageSize() {
		return imageSize;
	}
	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}
	public String getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(String imageWidth) {
		this.imageWidth = imageWidth;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEntityUrl() {
		return entityUrl;
	}
	public void setEntityUrl(String entityUrl) {
		this.entityUrl = entityUrl;
	}
	public String getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(String commentsCount) {
		this.commentsCount = commentsCount;
	}
	
	@Override
	public String toString() {
		return "Dynamic [id=" + id + ", createdTime=" + createdTime
				+ ", title=" + title + ", imageLocation=" + imageLocation
				+ ", content=" + content + ", createdBy=" + createdBy
				+ ", entityId=" + entityId + ", category=" + category
				+ ", projectStage=" + projectStage + ", projectName="
				+ projectName + ", companyName=" + companyName
				+ ", imageHeight=" + imageHeight + ", imageSize=" + imageSize
				+ ", imageWidth=" + imageWidth + ", userName=" + userName
				+ ", avatarUrl=" + avatarUrl + ", userType=" + userType
				+ ", eventType=" + eventType + ", entityUrl=" + entityUrl
				+ ", commentsCount=" + commentsCount + "]";
	}
	
}
