package com.zhongji.master.android.phone.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.provider.MediaStore.Images;

public class ImagesListBean extends BaseBean implements Serializable {

	/**
	 * 图片列表
	 */
	private static final long serialVersionUID = 1L;
	private List<Images> data;


	public List<Images> getData() {
		if(data == null){
			return new ArrayList<Images>();
		}
		return data;
	}


	public void setData(List<Images> data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "UserListBean [data=" + data + ", status=" + status + "]";
	}


}
