package com.zhongji.master.android.phone.activity.company;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseSecondActivity;

public class CompanyParticularsActivity extends BaseSecondActivity implements OnClickListener {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.company_particulars);
	}
	
	@Override
	protected void init() {
		// TODO 自动生成的方法存根
		setTitle("公司详情");
	}
	
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		super.onClick(v);
	}
}
