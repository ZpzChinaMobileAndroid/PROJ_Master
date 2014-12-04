package com.zhongji.master.android.phone.launch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseActivity;
import com.zhongji.master.android.phone.util.PreferencesUse;

/**
 * 引导
 * @author Administrator
 *
 */
public class GuideActivity extends BaseActivity implements OnClickListener{

//	private AdvertView advertview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch_guide);
		
		boolean bool = PreferencesUse.getIs_Login(GuideActivity.this);
		if(bool){
			startActivity(new Intent(GuideActivity.this, EmptyActivity.class));
			finish();
		}
	}

	@Override
	protected void init() { 
		// TODO Auto-generated method stub
		
		
//		advertview = (AdvertView) findViewById(R.id.advertview);
//		advertview.setmOnListener(new OnListener() {
//			
//			@Override
//			public void toActivity() {
//				// TODO Auto-generated method stub
//				startActivity(new Intent(GuideActivity.this, EmptyActivity.class));
//				finish();
//			}
//		});
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
//		if(arg0.getId() == R.id.btn_skip){
//			//跳过
//			startActivity(new Intent(GuideActivity.this, EmptyActivity.class));
//			finish();
//		}
	}

}
