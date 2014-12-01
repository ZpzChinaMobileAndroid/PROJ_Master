package com.zhongji.master.android.phone.activity.company;

import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView.RecyclerListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseIndexActivity;
import com.zhongji.master.android.phone.entity.Company;
import com.zhongji.master.android.phone.entity.CompanyListBean;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.until.JsonUtils;

/**
 * 公司
 * 
 */
public class CompanyActivity extends BaseIndexActivity {

	@ViewInject(id = R.id.btn_company_seach)
	private Button btn_company_seach;
	@ViewInject(id = R.id.et_company_seach_name)
	private EditText et_company_seach_name;
	private int page = 0;
	private int size = 5;
	private CompanyAdpter adapter;
	@ViewInject(id = R.id.lv_company_list)
	private RTPullListView listView;
	private List<Company> lists;
	private TextView tv_count = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
//		if(){
		setContentView(R.layout.activity_company_unautherized);
//	  }else{
//		  setContentView(R.layout.activity_company_particulars);
//	  }
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

		setTitle("公司组织");

		lists = new ArrayList<Company>();
		adapter = new CompanyAdpter(CompanyActivity.this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO 自动生成的方法存根

				if (arg2 - 2 < 0) {
					return;
				}
				Company com = adapter.getItem(arg2 - 2);
				Intent intent = new Intent();
				intent.setClass(CompanyActivity.this,
						CompanyParticularsActivity.class);
				intent.putExtra("url", com.getCompanyLogo());
				intent.putExtra("type", "show");
				startActivity(intent);

			}
		});

		listView.setRecyclerListener(new RecyclerListener() {

			@Override
			public void onMovedToScrapHeap(View arg0) {
				// TODO 自动生成的方法存根

				page = 0;
				getCompanyname();

			}

			public void onLoadMore() {
				// TODO Auto-generated method stub
				page = page + 1;
				getCompanyname();
			}
		});

		showProgressDialog();
		getCompanyname();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0.getId() == R.id.btn_company_seach) {
			btn_company_seach.setVisibility(View.GONE);
			et_company_seach_name.setVisibility(View.VISIBLE);

		}
	}

	private void getCompanyname() {
		// TODO 自动生成的方法存根

		HttpRestClient.get(CompanyActivity.this, HttpAPI.COMPANY_ALL,
				new ResponseUtils(CompanyActivity.this) {

					@Override
					public void getResult(int httpCode, String result) {
						// TODO 自动生成的方法存根
						dismissProgressDialog();
						listView.onRefreshComplete();
						listView.onLoadMoreComplete();
						if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
							CompanyListBean beans = JSON.parseObject(
									JsonUtils.parseString(result),
									CompanyListBean.class);
							if (getData(beans)) {
								return;
							}

							if (page == 0) {
								lists.clear();
								adapter.setList(lists);
								adapter.notifyDataSetChanged();
							}

							List<Company> temp = beans.getData();
							if (temp != null && temp.size() > 0) {
								for (Company com : temp) {
									lists.add(com);
								}
							}

							if (tv_count == null) {
								tv_count = new TextView(CompanyActivity.this);
								tv_count.setGravity(Gravity.CENTER);
								tv_count.setLayoutParams(new AbsListView.LayoutParams(
										AbsListView.LayoutParams.MATCH_PARENT,
										AbsListView.LayoutParams.WRAP_CONTENT));
								tv_count.setTextColor(getResources().getColor(
										R.color.gray_txt_hint));
								listView.addHeaderView(tv_count);
							}

							tv_count.setText("共计" + lists.size() + "条");

							adapter.setList(lists);
							adapter.notifyDataSetChanged();

							listView.removeFootView();

						} else {
							showNetShortToast(httpCode);
						}
					}
				});
	}
}
