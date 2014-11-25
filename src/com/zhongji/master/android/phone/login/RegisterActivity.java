package com.zhongji.master.android.phone.login;

/**
 * 注册
 * 
 */
import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements OnClickListener {
	
	@ViewInject(id=R.id.et_cellphone)
	private EditText et_cellphone;
	@ViewInject(id=R.id.et_verification)
	private EditText et_verification;
	@ViewInject(id=R.id.im_send)
	private EditText im_send;
	@ViewInject(id=R.id.et_username)
	private EditText et_username;
	@ViewInject(id=R.id.et_userpassword)
	private EditText et_userpassword;
	@ViewInject(id=R.id.et_usersecendpassword)
	private EditText et_usersecendpassword;
	@ViewInject(id=R.id.im_clause)
	private EditText im_clause;
	@ViewInject(id=R.id.im_countersign)
	private EditText im_countersign;
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}

	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	protected void init() {
		// TODO 自动生成的方法存根
		
	}
}
