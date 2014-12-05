package com.zhongji.master.android.phone.entity;

import java.io.Serializable;
import java.util.List;

public class StaffListBean extends BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Staffer> data;


	public List<Staffer> getData() {
		
		return data;
	}


	public void setData(List<Staffer> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "UserListBean [data=" + data + ", status=" + status + "]";
	}

}
