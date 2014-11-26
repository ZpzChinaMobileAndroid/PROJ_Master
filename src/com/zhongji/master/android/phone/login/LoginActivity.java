package com.zhongji.master.android.phone.login;

/**
 * 登陆
 */
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;

import net.tsz.afinal.annotation.view.ViewInject;

import com.alibaba.fastjson.JSON;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseActivity;
import com.zhongji.master.android.phone.base.BaseSecondActivity;
import com.zhongji.master.android.phone.entity.UserListBean;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.until.JsonUtils;
import com.zhongji.master.android.phone.until.MD5;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity  extends BaseActivity implements OnClickListener{

	@ViewInject(id=R.id.login_anonymity)
	private ImageView login_anonymity;
	@ViewInject(id=R.id.et_username)
	private EditText et_username;
	@ViewInject(id=R.id.et_userpassword)
	private EditText et_userpassword;
	@ViewInject(id=R.id.bt_landing)
	private EditText bt_landing;
	@ViewInject(id=R.id.bt_register)
	private EditText bt_register;
	@ViewInject(id=R.id.tv_foundpassword)
	private TextView tv_foundpassword;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
	}

	protected void init() {
		// TODO 自动生成的方法存根
		
		et_username.setText("18766142992");
		et_userpassword.setText("111");
		tv_foundpassword.setOnClickListener(this);
	}


	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getId()==R.id.bt_landing){
			
		//登陆	
		String username=et_username.getText().toString().trim();
		String userpassword=et_userpassword.getText().toString().trim();
		
		if(username.equals("")){
			showShortToast("请输入用户名");
			return;
		}
		if(userpassword.equals("")){
			showShortToast("请输入密码");
			return;
		}	
			
		showProgressDialog();
		login(username, userpassword);
		
		}else if(arg0.getId()==R.id.bt_register){
		//注册	
		Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
		startActivity(intent);
		
		}else if(arg0.getId()==R.id.tv_foundpassword){
		//找回密码
		Intent intent=new Intent(LoginActivity.this,FoundPasswordActivity.class);
		startActivity(intent);	
		
		}else if(arg0.getId()==R.id.login_anonymity){
		//匿名登陆
			
			
			
		}
	}

	/**
	 * 登陆
	 * @param username
	 * @param userpassword
	 */
	private void login(String username, String userpassword) {
		// TODO 自动生成的方法存根
		
		Map<String, String> content=new LinkedHashMap<String, String>();
		content.put("userName", username);
		content.put("password", MD5.md5(userpassword).substring(8,24));
		content.put("deviceType", "android");
		HttpRestClient.post(LoginActivity.this,HttpAPI.USERS_LOGIN, JsonUtils.change(content, false),new ResponseUtils(LoginActivity.this) {
			
			@Override
			public void getResult(int httpCode, String result) {
				// TODO 自动生成的方法存根
				dismissProgressDialog();
				if(httpCode==HttpAPI.HTTP_SUCCESS_CODE){
				UserListBean bean=JSON.parseObject(JsonUtils.parseString(result),UserListBean.class);	
				if(getData(bean)){
					return;
				}	
				showShortToast("登陆成功");
				
				
		//		Intent intent= new Intent(LoginActivity.this,UserClauseActivity.class);
		//		startActivity(intent);
				}else{
					showNetShortToast(httpCode);
				}
			}
		});
	}
}


