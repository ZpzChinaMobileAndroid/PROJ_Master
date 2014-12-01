package com.zhongji.master.android.phone.activity.contacts;

import android.os.Bundle;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseSecondActivity;

/**
 * 人的详情
 * @author admin
 *
 */
public class PersonDetialActivity extends BaseSecondActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_publish);

	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

		setTitle("人的详情");
		setLeftBtn();
		setRightBtn(null);

		
	}

}
