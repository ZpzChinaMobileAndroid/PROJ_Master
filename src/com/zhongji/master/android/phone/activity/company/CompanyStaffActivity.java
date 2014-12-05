package com.zhongji.master.android.phone.activity.company;

import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.alibaba.fastjson.JSON;
import com.loopj.android.http.RequestParams;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.adapter.CompanyAdpter;
import com.zhongji.master.android.phone.adapter.StaffAdpter;
import com.zhongji.master.android.phone.base.BaseSecondActivity;
import com.zhongji.master.android.phone.entity.Company;
import com.zhongji.master.android.phone.entity.CompanyListBean;
import com.zhongji.master.android.phone.entity.ContactsListBean;
import com.zhongji.master.android.phone.entity.StaffListBean;
import com.zhongji.master.android.phone.entity.Staffer;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.util.JsonUtils;
import com.zhongji.master.android.phone.widget.RTPullListView;

/**
 * 员工详情
 * 
 * @author Admin
 * 
 */
public class CompanyStaffActivity extends BaseSecondActivity implements
		OnClickListener {

	private int page = 0;
	private int size = 5;
	private String companyidString;
	private StaffAdpter adapter;
	@ViewInject(id = R.id.lv_company_staff_list)
	private RTPullListView listView;
	private List<Staffer> lists;
	private TextView tv_count = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_staff_user);

	}

	@Override
	protected void init() {
		// TODO 自动生成的方法存根

		setTitle("公司员工");
		setLeftBtn();

		companyidString = getIntent().getStringExtra("companyidString");

		lists = new ArrayList<Staffer>();
		adapter = new StaffAdpter(CompanyStaffActivity.this);
		listView.setAdapter(adapter);

		showProgressDialog();
		staff();
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		super.onClick(v);
	}

	/**
	 * 员工详情
	 * 
	 */

	private void staff() {
		// TODO 自动生成的方法存根
		RequestParams params = new RequestParams();
		params.put("CompanyId", companyidString);
		params.put("PageIndex", page + "");
		params.put("PageSize", size + "");

		HttpRestClient.get(HttpAPI.COMPANY_GETSTAFF, params, new ResponseUtils(
				CompanyStaffActivity.this) {

			@Override
			public void getResult(int httpCode, String result) {
				// TODO 自动生成的方法存根
				dismissProgressDialog();
				listView.onRefreshComplete();
				listView.onLoadMoreComplete();
				if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
					StaffListBean beans = JSON.parseObject(
							JsonUtils.parseString(result),
							StaffListBean.class);
					if (getData(beans)) {
						return;
					}

					if (page == 0) {
						lists.clear();
						adapter.setList(lists);
						adapter.notifyDataSetChanged();
					}

					List<Staffer> temp = beans.getData();

					if (temp != null && temp.size() > 0) {
						for (Staffer sta : temp) {
							lists.add(sta);
						}
					}
//
//					if (tv_count == null) {
//						tv_count = new TextView(CompanyStaffActivity.this);
//						tv_count.setGravity(Gravity.CENTER);
//						tv_count.setLayoutParams(new AbsListView.LayoutParams(
//								AbsListView.LayoutParams.MATCH_PARENT,
//								AbsListView.LayoutParams.WRAP_CONTENT));
//						tv_count.setTextColor(getResources().getColor(
//								R.color.gray_txt_hint));
//						listView.addHeaderView(tv_count);
//					}
//
//					tv_count.setText("共计" + lists.size() + "条");

					adapter.setList(lists);
					adapter.notifyDataSetChanged();

					listView.removeFootView();

				} else {
					showShortToast(result);
				}

			}
		});

	}
}
