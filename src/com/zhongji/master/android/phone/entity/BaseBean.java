package com.zhongji.master.android.phone.entity;

import java.io.Serializable;

public class BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Status status;
	protected Status status1;
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BaseBean [status=" + status + "]";
	}
	public String toString1() {
		// TODO 自动生成的方法存根
		return"BaseBean [status1=" + status1 + "]";
	}


}
