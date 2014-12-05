package com.zhongji.master.android.phone.entity;

import java.io.Serializable;

/**
 * 评论信息
 * @author Admin
 *
 */

public class Comments implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String commentContents;		// 评论内容
	private String entityType;			// 类型
	private String entityId;			// 相关Id
	private String createdBy;			// 创建人
	private String id;					// 评论表Id
	private String createdTime;			// 创建时间
	private String userName;			// 用户名
	private String userImage;			// 用户图片
	private String userType;
	public String getCommentContents() {
		return commentContents;
	}
	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "Comments [commentContents=" + commentContents + ", entityType="
				+ entityType + ", entityId=" + entityId + ", createdBy="
				+ createdBy + ", id=" + id + ", createdTime=" + createdTime
				+ ", userName=" + userName + ", userImage=" + userImage
				+ ", userType=" + userType + "]";
	}		
	
}
