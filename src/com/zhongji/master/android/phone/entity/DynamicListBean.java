package com.zhongji.master.android.phone.entity;

import java.io.Serializable;
import java.util.List;

public class DynamicListBean extends BaseBean implements Serializable {

	/**
	 * 动态信息
	 */
	private static final long serialVersionUID = 1L;
	private List<Dynamic_Comments> data;


	public List<Dynamic_Comments> getData() {
		return data;
	}


	public void setData(List<Dynamic_Comments> data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "UserListBean [data=" + data + ", status=" + status + "]";
	}

}
