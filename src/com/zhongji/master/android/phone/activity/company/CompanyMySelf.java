package com.zhongji.master.android.phone.activity.company;

import java.util.List;

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
import com.zhongji.master.android.phone.base.BaseIndexActivity;
import com.zhongji.master.android.phone.base.BaseSecondActivity;
import com.zhongji.master.android.phone.entity.Company;
import com.zhongji.master.android.phone.entity.CompanyListBean;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.util.JsonUtils;

/**
 * 我的公司
 * 
 * @author Admin
 * 
 */

public class CompanyMySelf extends BaseIndexActivity implements OnClickListener {

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
	private String companymessage;
	private int a, b, c, d, e, f, g, h, i, j, k, l;
	private String id, companyName, comoanyLogo, companyIndustry,
			companyDescription, companyType, deviceToken;
	private String companyidString, IndustryString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_myself);
	}

	@Override
	protected void init() {
		// TODO 自动生成的方法存根

		setTitle("我的公司");
		setRightBtnMore(this);
		getMyCompany();
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		super.onClick(v);
		if (v.getId() == R.id.tv_right) {
			// 更多
			Intent intent = new Intent(CompanyMySelf.this,
					CompanyActivity.class);
			startActivity(intent);
		}
	}

	/**
	 * 获取我的公司
	 * 
	 */
	private void getMyCompany() {
		// TODO 自动生成的方法存根

		RequestParams params = new RequestParams();
		String companyid = HttpRestClient.UserID;
		params.put("CompanyBaseInformationId", companyid);

		HttpRestClient.get(CompanyMySelf.this, HttpAPI.COMPANY_MYSELF,
				new ResponseUtils(CompanyMySelf.this) {

					@Override
					public void getResult(int httpCode, String result) {
						// TODO 自动生成的方法存根

						if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
							CompanyListBean bean = JSON.parseObject(
									JsonUtils.parseString(result),
									CompanyListBean.class);
							List<Company> temp = bean.getData();

							companymessage = temp.toString();
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

							companyidString = companymessage.substring(
									a + id.length() + 1, b);
							iv_company_logo
									.setBackgroundResource(R.drawable.company_icon);
							tv_company_name.setText(companymessage.substring(c
									+ companyName.length() + 1, d));

							IndustryString = companymessage.substring(g
									+ companyIndustry.length() + 1, h);
							if (IndustryString.equals("null")) {
								tv_company_industry.setText("");
							} else {
								tv_company_industry.setText(IndustryString);
							}

							tv_introduce.setText(companymessage.substring(k
									+ companyDescription.length() + 1, l));

						} else {
							showShortToast(result);
						}

					}
				});
	}
}
