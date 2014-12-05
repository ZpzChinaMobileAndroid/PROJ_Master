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
import com.zhongji.master.android.phone.activity.login.LoginActivity;
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
	@ViewInject(id = R.id.btn_staff)
	private Button btn_staff;
	@ViewInject(id = R.id.tv_staff_number)
	private TextView tv_staff_number;
	private String companymessage;
	private int a, b, c, d, e, f, g, h, i, j, k, l, m, n;
	private String id, companyName, comoanyLogo, companyIndustry,
			companyDescription, companyType, deviceToken,
			companyEmployeeNumber;
	private String companyidString, IndustryString;
	private int number = 0;

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
		if (HttpRestClient.UserType.equals("Personal")) {
			getMyCompany();
		} else if (HttpRestClient.UserType.equals("Company")) {
			getCompanyUser();
		}
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
		} else if (v.getId() == R.id.btn_attention) {

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

		} else if (v.getId() == R.id.btn_staff) {
			// 员工人数
			Intent intent = new Intent(CompanyMySelf.this,
					CompanyStaffActivity.class);
			intent.putExtra("companyidString", companyidString);
			startActivity(intent);

		}

	}

	/**
	 * 获取我的公司
	 * 
	 */
	private void getMyCompany() {
		// TODO 自动生成的方法存根

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
							if (temp.size() > 0) {
								companymessage = temp.toString();
								id = "id";
								companyName = "companyName";
								comoanyLogo = "comoanyLogo";
								companyIndustry = "companyIndustry";
								companyType = "companyType";
								companyDescription = "companyDescription";
								companyEmployeeNumber = "companyEmployeeNumber";

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
								m = companymessage
										.indexOf(companyEmployeeNumber);// 公司描述
								n = companymessage.indexOf(",", m);

								companyidString = companymessage.substring(a
										+ id.length() + 1, b);
								iv_company_logo
										.setBackgroundResource(R.drawable.company_icon);
								tv_company_name.setText(companymessage.substring(
										c + companyName.length() + 1, d));
								tv_staff_number.setText(companymessage
										.substring(
												m
														+ companyEmployeeNumber
																.length() + 1,
												n));
								IndustryString = companymessage.substring(g
										+ companyIndustry.length() + 1, h);
								if (IndustryString.equals("null")) {
									tv_company_industry.setText("");
								} else {
									tv_company_industry.setText(IndustryString);
								}

								tv_introduce.setText(companymessage.substring(k
										+ companyDescription.length() + 1, l));
							}

						} else {
							showShortToast(result);
						}

					}
				});
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
				new ResponseUtils(CompanyMySelf.this) {

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
				new ResponseUtils(CompanyMySelf.this) {

					@Override
					public void getResult(int httpCode, String result) {
						// TODO Auto-generated method stub
						if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {

						}
					}
				});
	}

	/**
	 * 获取单个公司
	 * 
	 */

	private void getCompanyUser() {
		// TODO 自动生成的方法存根

	}

}
