package com.zhongji.master.android.phone.activity.company;

import java.util.ArrayList;

import org.apache.http.client.RequestDirector;
import org.json.JSONException;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.graphics.Color;
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
	private Company content;
	private String companymessage;
	private int a, b, c, d, e, f, g, h, i, j, k, l;
	private String id, companyName, comoanyLogo, companyIndustry,
			companyDescription, companyType, deviceToken;
	private String companyidString, IndustryString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_particulars);

		content = (Company) getIntent().getSerializableExtra("content");
		System.out.println("选择公司数据：" + content);

		companymessage = content.toString();
		id = "id";
		companyName = "companyName";
		comoanyLogo = "comoanyLogo";
		companyIndustry = "companyIndustry";
		companyType = "companyType";
		companyDescription = "companyDescription";

		a = companymessage.indexOf(id);// 公司id
		b = companymessage.indexOf(",", a);
		c = companymessage.indexOf(companyName);// 公司名字
		d = companymessage.indexOf(",", c);
		e = companymessage.indexOf(comoanyLogo);// 公司logo
		f = companymessage.indexOf(",", e);
		g = companymessage.indexOf(companyIndustry);// 公司行业
		h = companymessage.indexOf(",", g);
		i = companymessage.indexOf(companyType);// 公司类型
		j = companymessage.indexOf(",", i);
		k = companymessage.indexOf(companyDescription);// 公司描述
		l = companymessage.indexOf(",", k);

		companyidString = companymessage.substring(a + id.length() + 1, b);
		iv_company_logo.setBackgroundResource(R.drawable.company_icon);
		tv_company_name.setText(companymessage.substring(
				c + companyName.length() + 1, d));

		IndustryString = companymessage.substring(g + companyIndustry.length()
				+ 1, h);
		if (IndustryString.equals("null")) {
			tv_company_industry.setText("");
		} else {
			tv_company_industry.setText(IndustryString);
		}

		tv_introduce.setText(companymessage.substring(
				k + companyDescription.length() + 1, l));
	}

	@Override
	protected void init() {
		// TODO 自动生成的方法存根
		setTitle("公司详情");
		setLeftBtn();
		deviceToken = HttpRestClient.DeviceTOKEN;

		String haString = HttpRestClient.hasCompany;
		if (haString.equals("true")) {
			// 已认证
			btn_authentication.setEnabled(false);
			btn_authentication.setTextColor(Color.GRAY);
		}
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
			}
			if (number / 1 == 0) {
				// 加关注
				btn_attention.setText("取消关注");
				attention();
				number++;
			} else if (number / 1 == 1) {

				// 取消关注
				btn_attention.setText("加关注");
				cancelattention();
				number++;
			}

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
		params.put("userId", HttpRestClient.UserID);
		params.put("focusId", companyidString);
		params.put("UserType", HttpRestClient.UserType);
		params.put("FocusType", "Company");

		HttpRestClient.post(HttpAPI.COMPANY_ATTENTION, params,
				new ResponseUtils(CompanyParticularsActivity.this) {

					@Override
					public void getResult(int httpCode, String result) {
						// TODO Auto-generated method stub
						if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
							//

						} else {
							showShortToast(result);
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
		params.put("userId", HttpRestClient.UserID);
		params.put("focusId", companyidString);

		HttpRestClient.post(HttpAPI.COMPANY_CANCELATTENTION, params,
				new ResponseUtils(CompanyParticularsActivity.this) {

					@Override
					public void getResult(int httpCode, String result) {
						// TODO Auto-generated method stub
						if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {

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
		params.put("CompanyId", companyidString);
		params.put("EmployeeId", HttpRestClient.UserID);
		params.put("CreatedBy", HttpRestClient.UserID);

		HttpRestClient.post(HttpAPI.COMPANY_APPLY, params, new ResponseUtils(
				CompanyParticularsActivity.this) {

			@Override
			public void getResult(int httpCode, String result) {
				// TODO Auto-generated method stub
				if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {

				} else {
					showShortToast(result);
				}

			}
		});
	}
}
