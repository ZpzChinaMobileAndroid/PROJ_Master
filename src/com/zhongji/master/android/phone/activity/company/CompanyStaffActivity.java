package com.zhongji.master.android.phone.activity.company;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseSecondActivity;

/**
 * 员工详情
 * @author Admin
 *
 */
public class CompanyStaffActivity extends BaseSecondActivity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.company_staff);
		
	}

	@Override
	protected void init() {
		// TODO 自动生成的方法存根

		setTitle("公司员工");
		setLeftBtn();
		
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		super.onClick(v);
	}

}
