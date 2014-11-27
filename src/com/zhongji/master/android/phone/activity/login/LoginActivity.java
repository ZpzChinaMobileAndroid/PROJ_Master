package com.zhongji.master.android.phone.activity.login;

/**
 * 登陆
 */
import java.util.LinkedHashMap;
import java.util.Map;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.activity.contacts.ContactsActivity;
import com.zhongji.master.android.phone.base.BaseSecondActivity;
import com.zhongji.master.android.phone.entity.UserListBean;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.until.JsonUtils;
import com.zhongji.master.android.phone.until.MD5;

public class LoginActivity extends BaseSecondActivity implements
		OnClickListener {

	@ViewInject(id = R.id.et_username)
	private EditText et_username;
	@ViewInject(id = R.id.et_userpassword)
	private EditText et_userpassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	protected void init() {
		// TODO 自动生成的方法存根

		setTitle("");
		setLeftBtn_X();

		et_username.setText("12365478901");
		et_userpassword.setText("111");
	}

	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		super.onClick(arg0);
		if (arg0.getId() == R.id.btn_login) {
			// 登陆
			String username = et_username.getText().toString().trim();
			String userpassword = et_userpassword.getText().toString().trim();

			if (username.equals("")) {
				showShortToast("请输入用户名");
				return;
			}
			if (userpassword.equals("")) {
				showShortToast("请输入密码");
				return;
			}

			showProgressDialog();
			login(username, userpassword);

		} else if (arg0.getId() == R.id.btn_register) {
			// 注册
			Intent intent = new Intent(LoginActivity.this,
					RegisterActivity.class);
			startActivity(intent);
		} else if (arg0.getId() == R.id.tv_forget) {
			// 找回密码
			Intent intent = new Intent(LoginActivity.this,
					FoundPasswordActivity.class);
			startActivity(intent);
		} else if (arg0.getId() == R.id.tv_forget) {
			// 找回密码
			Intent intent = new Intent(LoginActivity.this,
					FoundPasswordActivity.class);
			startActivity(intent);

		}
	}

	/**
	 * 登陆
	 * 
	 * @param username
	 * @param userpassword
	 */
	private void login(String username, String userpassword) {
		// TODO 自动生成的方法存根

		Map<String, String> content = new LinkedHashMap<String, String>();
		content.put("userName", username);
		content.put("password", MD5.md5(userpassword).substring(8, 24));
		content.put("deviceType", "android");
		HttpRestClient.post(LoginActivity.this, HttpAPI.USERS_LOGIN, JsonUtils
				.change(content, false), new ResponseUtils(LoginActivity.this) {

			@Override
			public void getResult(int httpCode, String result) {
				// TODO 自动生成的方法存根
				dismissProgressDialog();
				if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
					UserListBean bean = JSON.parseObject(
							JsonUtils.parseString(result), UserListBean.class);
					if (getData(bean)) {
						return;
					}
					showShortToast("登陆成功");

					Intent intent = new Intent(LoginActivity.this,
							ContactsActivity.class);
					startActivity(intent);
				} else {
					showNetShortToast(httpCode);
				}
			}
		});
	}
}
