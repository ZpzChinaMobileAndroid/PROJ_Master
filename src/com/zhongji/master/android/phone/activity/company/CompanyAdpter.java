package com.zhongji.master.android.phone.activity.company;

import java.util.ArrayList;
import java.util.List;

import com.zhongji.master.android.phone.entity.Company;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CompanyAdpter extends BaseAdapter {

	private Context context;
	private List<Company> list;
	
	
	public CompanyAdpter(Context context){
		this.context = context;
		this.list = new ArrayList<Company>();
	}
	
	public void setList(List<Company> lists) {
		this.list = list;
	}
	
	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO 自动生成的方法存根
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO 自动生成的方法存根
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO 自动生成的方法存根
		
		
		
		return null;
	}

}
