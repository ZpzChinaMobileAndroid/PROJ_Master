package com.zhongji.master.android.phone.launch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseActivity;

/**
 * 启动
 * @author Administrator
 *
 */
public class LaunchActivity extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch_launch);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				startActivity(new Intent(LaunchActivity.this, GuideActivity.class));
				finish();
			}
		}, 1500);
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}
}
