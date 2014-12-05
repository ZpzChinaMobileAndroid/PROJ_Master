package com.zhongji.master.android.phone.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 动态&评论信息
 * @author Admin
 *
 */


public class Dynamic_Comments implements Serializable{

	private static final long serialVersionUID = 1L;
	private Dynamic actives;
	private List<Comments> comments;
	public Dynamic getActives() {
		return actives;
	}
	public void setActives(Dynamic actives) {
		this.actives = actives;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Dynamic_Comments [actives=" + actives + "]";
	}
	
}
