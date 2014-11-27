package com.zhongji.master.android.phone.activity.login;

import android.os.Bundle;
import android.view.View.OnClickListener;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseSecondActivity;

/**
 * 用户条款
 * 
 */

public class UserClauseActivity extends BaseSecondActivity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_userclause);
	}

	@Override
	protected void init() {
		// TODO 自动生成的方法存根

		setTitle("使用条款");
		setLeftBtn();

	}

}
