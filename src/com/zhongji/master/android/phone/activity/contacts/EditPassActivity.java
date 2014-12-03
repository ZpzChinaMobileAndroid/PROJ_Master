package com.zhongji.master.android.phone.activity.contacts;

import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseSecondActivity;

/**
 * 修改密码
 * 
 * @author Admin
 * 
 */
public class EditPassActivity extends BaseSecondActivity implements
		OnClickListener {

	@ViewInject(id = R.id.btn_affirm)
	private Button bt_affirm;
	@ViewInject(id = R.id.et_password)
	private EditText et_password;
	@ViewInject(id = R.id.et_newpassword)
	private EditText et_newpassword;
	@ViewInject(id = R.id.et_repassword)
	private EditText et_repassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_editpass);

	}

	@Override
	protected void init() {

		setTitle("找回密码");
		setLeftBtn();

	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		super.onClick(arg0);

		if (arg0.getId() == R.id.btn_affirm) {
			// 下一步
			String password = et_password.getText().toString().trim();
			String newpassword = et_newpassword.getText().toString().trim();
			String repassword = et_repassword.getText().toString().trim();

			if (password.equals("")) {
				showShortToast("请输入原密码");
				return;
			} else if (newpassword.equals("")) {
				showShortToast("请输入新密码");
				return;
			} else if (!newpassword.equals(repassword)) {
				showShortToast("对不起您输入的两次密码不同，请重新输入");
				return;
			} else {
				finish();
			}
		}
	}
}
