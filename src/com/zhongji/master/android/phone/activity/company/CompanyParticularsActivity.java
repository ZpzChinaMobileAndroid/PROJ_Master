package com.zhongji.master.android.phone.activity.company;

import org.apache.http.client.RequestDirector;
import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.RequestParams;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseSecondActivity;
import com.zhongji.master.android.phone.entity.Company;
import com.zhongji.master.android.phone.entity.CompanyListBean;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.until.JsonUtils;

/**
 * 公司详情
 * 
 * @author Admin
 * 
 */

public class CompanyParticularsActivity extends BaseSecondActivity implements
		OnClickListener {

	@ViewInject(id = R.id.iv_company_logo)
	private ImageView iv_company_logo;
	@ViewInject(id = R.id.tv_company_name)
	private TextView tv_company_name;
	@ViewInject(id = R.id.tv_company_industry)
	private TextView tv_company_industry;
	@ViewInject(id = R.id.tv_introduce)
	private TextView tv_introduce;
	@ViewInject(id = R.id.btn_attention)
	private Button btn_attention;
	@ViewInject(id = R.id.btn_authentication)
	private Button btn_authentication;
	@ViewInject(id = R.id.tv_right)
	private TextView tv_right;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_particulars);

	}

	@Override
	protected void init() {
		// TODO 自动生成的方法存根
		setTitle("公司详情");
		setRight("更多");

		Company company = new Company();
		iv_company_logo.setBackgroundResource(R.drawable.company_icon);
		tv_company_name.setText(company.getCompanyname());
		tv_company_industry.setText(company.getCompanyIndustry());
		tv_introduce.setText(company.getCompanyDescription());

	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		super.onClick(v);
		if (v.getId() == R.id.tv_right) {
			// 更多
			Intent intent = new Intent(CompanyParticularsActivity.this,
					CompanyActivity.class);
			startActivity(intent);
		} else if (v.getId() == R.id.btn_attention) {
			attention();
			// 加关注
		} else if (v.getId() == R.id.btn_authentication) {
			// 申请认证
			authentication();
		}
	}

	/**
	 * 加关注
	 * 
	 */

	private void attention() {
		// TODO 自动生成的方法存根
		RequestParams params = new RequestParams();
		params.put("", "");
		params.put("", "");
		params.put("", "");
		params.put("", "");

		HttpRestClient.get(CompanyParticularsActivity.this,
				HttpAPI.COMPANY_ATTENTION, HttpRestClient.DeviceTOKEN, params,
				new ResponseUtils(CompanyParticularsActivity.this) {

					@Override
					public void getResult(int httpCode, String result) {
						// TODO Auto-generated method stub
						if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
							CompanyListBean beans = JSON.parseObject(
									JsonUtils.parseString(result),
									CompanyListBean.class);

						}
					}
				});
	}

	/**
	 * 申请认证
	 * 
	 */
	private void authentication() {
		// TODO 自动生成的方法存根

		RequestParams params = new RequestParams();
		params.put("", "");
		params.put("", "");
		params.put("", "");
		params.put("", "");

		HttpRestClient.get(CompanyParticularsActivity.this,
				HttpAPI.COMPANY_ATTENTION, HttpRestClient.DeviceTOKEN, params,
				new ResponseUtils(CompanyParticularsActivity.this) {

					@Override
					public void getResult(int httpCode, String result) {
						// TODO Auto-generated method stub
						if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
							CompanyListBean beans = JSON.parseObject(
									JsonUtils.parseString(result),
									CompanyListBean.class);

						}

					}
				});
	}
}
