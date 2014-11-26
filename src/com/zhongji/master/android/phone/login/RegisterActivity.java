package com.zhongji.master.android.phone.login;

/**
 * 注册
 * 
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
import com.zhongji.master.android.phone.base.BaseSecondActivity;
import com.zhongji.master.android.phone.entity.UserListBean;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.until.JsonUtils;
import com.zhongji.master.android.phone.until.MD5;

public class RegisterActivity extends BaseSecondActivity implements
		OnClickListener {

	@ViewInject(id = R.id.et_cellphone)
	private EditText et_cellphone;
	@ViewInject(id = R.id.et_verification)
	private EditText et_verification;
	@ViewInject(id = R.id.et_username)
	private EditText et_username;
	@ViewInject(id = R.id.et_userpassword)
	private EditText et_userpassword;
	@ViewInject(id = R.id.et_usersecendpassword)
	private EditText et_usersecendpassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}

	@Override
	protected void init() {
		// TODO 自动生成的方法存根

		setTitle("注册");

		setLeftBtn();
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		super.onClick(arg0);

		if (arg0.getId() == R.id.iv_clause) {
			// 用户条款
			Intent intent = new Intent(RegisterActivity.this,
					UserClauseActivity.class);
			startActivity(intent);
		} else if (arg0.getId() == R.id.btn_register) {
			// 注册

			String cellpone = et_cellphone.getText().toString().trim();
			String barcode = et_verification.getText().toString().trim();
			String usernameString = et_username.getText().toString().trim();
			String userpassword = et_userpassword.getText().toString().trim();
			String usersecendpassword = et_usersecendpassword.getText()
					.toString().trim();

			if (cellpone.equals("")) {
				showShortToast("请输入手机号码");
				return;
			}
			if (cellpone.length() != 11) {
				showShortToast("你输入的手机号码不正确");
				return;
			}
			if (barcode.equals("")) {
				showShortToast("请填写验证码");
				return;
			}
			if (userpassword.equals("")) {
				showShortToast("请填写密码");
				return;
			}
			if (usersecendpassword.equals("")) {
				showShortToast("请再次输入密码");
				return;
			}
			if (!userpassword.equals(usersecendpassword)) {
				showShortToast("对不起你两次输入的密码不同，请重新输入");
				return;
			}

			showProgressDialog();
			register(cellpone, barcode, usernameString, userpassword);

		} else if (arg0.getId() == R.id.btn_send) {
			// 发送验证码

		}
	}

	/**
	 * 注册
	 * 
	 * @param cellpone
	 * @param usernameString
	 * @param userpasword
	 */

	private void register(String cellpone, String barcode,
			String usernameString, String userpassword) {
		// TODO 自动生成的方法存根

		Map<String, String> maps = new LinkedHashMap<String, String>();
		maps.put("cellPhone", cellpone);
		maps.put("password", MD5.md5(userpassword).substring(8, 24));
		maps.put("userName", usernameString);
		maps.put("deviceType", "mobile");
		maps.put("barCode", barcode);
		HttpRestClient.post(RegisterActivity.this, HttpAPI.USERS_REGISTER,
				JsonUtils.change(maps, false), new ResponseUtils(
						RegisterActivity.this) {

					@Override
					public void getResult(int httpCode, String result) {
						// TODO 自动生成的方法存根
						dismissProgressDialog();
						if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
							UserListBean bean = JSON.parseObject(
									JsonUtils.parseString(result),
									UserListBean.class);
							if (getData(bean)) {
								return;
							}
							showShortToast("注册成功");

							Intent intent = new Intent(RegisterActivity.this,
									LoginActivity.class);
							startActivity(intent);
						} else {
							showNetShortToast(httpCode);
						}
					}
				});

	}
}
