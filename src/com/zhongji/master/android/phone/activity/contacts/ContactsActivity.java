package com.zhongji.master.android.phone.activity.contacts;

import android.os.Bundle;
import android.view.View;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseIndexActivity;

/**
 * 人脉
 * @author admin
 *
 */
public class ContactsActivity extends BaseIndexActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
		setTitle("人脉");
		setRightBtn(null);
	}

}
