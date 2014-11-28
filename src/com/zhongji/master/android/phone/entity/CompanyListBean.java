package com.zhongji.master.android.phone.entity;

import java.io.Serializable;
import java.util.List;

public class CompanyListBean extends BaseBean implements Serializable {

	/**
	 * 项目列表
	 */
	private static final long serialVersionUID = 1L;
	private List<Company> data;


	public List<Company> getData() {
		return data;
	}


	public void setData(List<Company> data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "UserListBean [data=" + data + ", status=" + status + "]";
	}

}
