package com.zhongji.master.android.phone.activity.contacts;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.adapter.CenterAdapter;
import com.zhongji.master.android.phone.base.BaseSecondActivity;

/**
 * 账号设置
 * @author admin
 *
 */
public class AccountActivity extends BaseSecondActivity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_account);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		super.onClick(arg0);
		if(arg0.getId() == R.id.tv_right){
			//完成
			
		}
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
		setTitle("账号设置");
		setRightFinishBtn(AccountActivity.this);
		
		
		
	}

}
