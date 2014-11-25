package com.zhongji.master.android.phone.login;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.R.id;
import com.zhongji.master.android.phone.base.BaseActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * 用户条款
 * 
 */

public class UserClauseActivity extends BaseActivity implements OnClickListener{
	
	private ImageView im_clauseback;
	
	
   @Override
    protected void onCreate(Bundle savedInstanceState) {
	// TODO 自动生成的方法存根
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_userclause);
  }
	
	@Override
	protected void init() {
		// TODO 自动生成的方法存根
		
		im_clauseback=(ImageView) findViewById(id.im_clauseback);
		im_clauseback.setOnClickListener(this);
	}


	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
	//返回注册	
	if(arg0.getId()==R.id.im_clauseback){
		Intent intent=new Intent(UserClauseActivity.this,RegisterActivity.class);
		startActivity(intent);
		finish();
		}	
	}
 }
