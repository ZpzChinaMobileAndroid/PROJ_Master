package com.zhongji.master.android.phone.activity.company;

import java.util.ArrayList;

import org.apache.http.client.RequestDirector;
import org.json.JSONException;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.loopj.android.http.RequestParams;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.activity.login.LoginActivity;
import com.zhongji.master.android.phone.base.BaseSecondActivity;
import com.zhongji.master.android.phone.entity.Company;
import com.zhongji.master.android.phone.entity.CompanyListBean;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.util.JsonUtils;

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
	private int number = 0;
	private String userid, usertype;
	private Company content;
	private String companyid, companyName, comoanyLogo, companyIndustry,
			companyDescription, companyType, deviceToken;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_particulars);

		userid = getIntent().getStringExtra("userid");
		usertype = getIntent().getStringExtra("usertype");
		content = (Company) getIntent().getSerializableExtra("content");
		System.out.println("选择公司数据：" + content);

		String companymessage = content.toString();
		companyid = "id";
		companyName = "companyName";
		comoanyLogo = "comoanyLogo";
		companyIndustry = "companyIndustry";
		companyType = "companyType";
		companyDescription = "companyDescription";
		
		int a = companymessage.indexOf(companyid);// 公司id
		int b = companymessage.indexOf(",", a);
		int c = companymessage.indexOf(companyName);// 公司名字
		int d = companymessage.indexOf(",", c);
		int e = companymessage.indexOf(comoanyLogo);// 公司logo
		int f = companymessage.indexOf(",", e);
		int g = companymessage.indexOf(companyIndustry);// 公司行业
		int h = companymessage.indexOf(",", g);
		int i = companymessage.indexOf(companyType);// 公司类型
		int j = companymessage.indexOf(",", i);
		int k = companymessage.indexOf(companyDescription);// 公司描述
		int l = companymessage.indexOf(",", k);

		iv_company_logo.setBackgroundResource(R.drawable.company_icon);
		tv_company_name.setText(companymessage.substring(
				c + companyName.length() + 1, d));
		tv_company_industry.setText(companymessage.substring(g
				+ companyIndustry.length() + 1, h));
		tv_introduce.setText(companymessage.substring(
				k + companyDescription.length() + 1, l));
	}

	@Override
	protected void init() {
		// TODO 自动生成的方法存根
		setTitle("公司详情");
		deviceToken = HttpRestClient.DeviceTOKEN;
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
			if (deviceToken.equals(null)) {
				Intent intent = new Intent(CompanyParticularsActivity.this,
						LoginActivity.class);
				startActivity(intent);
			} else {
				// 加关注
				attention();
			}
			// // 取消关注
			// cancelattention();

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
		params.put("userId", userid);
		params.put("focusId", companyid);
		params.put("UserType", usertype);
		params.put("FocusType", "Company");

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

							btn_attention.setText("已关注");
						}
					}
				});
	}

	/**
	 * 取消关注
	 * 
	 */

	private void cancelattention() {
		// TODO 自动生成的方法存根
		RequestParams params = new RequestParams();
		params.put("userId", userid);
		params.put("focusId", companyid);

		HttpRestClient.get(CompanyParticularsActivity.this,
				HttpAPI.COMPANY_CANCELATTENTION, HttpRestClient.DeviceTOKEN,
				params, new ResponseUtils(CompanyParticularsActivity.this) {

					@Override
					public void getResult(int httpCode, String result) {
						// TODO Auto-generated method stub
						if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
							CompanyListBean beans = JSON.parseObject(
									JsonUtils.parseString(result),
									CompanyListBean.class);

							btn_attention.setText("加关注");
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
