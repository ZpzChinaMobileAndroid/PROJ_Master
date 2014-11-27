package com.zhongji.master.android.phone.activity.company;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseIndexActivity;

/**
 * 公司
 * 
 * @author admin
 * 
 */
public class CompanyActivity extends BaseIndexActivity {

	@ViewInject(id = R.id.btn_company_seach)
	private Button btn_company_seach;
	@ViewInject(id=R.id.et_company_seach_name)
	private EditText et_company_seach_name;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_unautherized);
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

		setTitle("公司组织");

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0.getId() == R.id.btn_company_seach) {
		btn_company_seach.setVisibility(View.GONE);	
		et_company_seach_name.setVisibility(View.VISIBLE);
		
		
		}
	}
}
