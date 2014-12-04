package com.zhongji.master.android.phone.activity.company;

import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.RecyclerListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.loopj.android.http.RequestParams;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.adapter.CompanyAdpter;
import com.zhongji.master.android.phone.base.BaseIndexActivity;
import com.zhongji.master.android.phone.entity.Company;
import com.zhongji.master.android.phone.entity.CompanyListBean;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.util.JsonUtils;
import com.zhongji.master.android.phone.widget.KeyboardLayout;
import com.zhongji.master.android.phone.widget.RTPullListView;

/**
 * 公司
 * 
 */
public class CompanyActivity extends BaseIndexActivity implements
		OnClickListener {

	@ViewInject(id = R.id.btn_company_seach)
	private Button btn_company_seach;
	@ViewInject(id = R.id.et_company_seach_name)
	private EditText et_company_seach_name;
	@ViewInject(id = R.id.tv_company_cancel)
	private TextView tv_company_cancel;
	private int page = 0;
	private int size = 5;
	private CompanyAdpter adapter;
	@ViewInject(id = R.id.lv_company_list)
	private RTPullListView listView;
	private List<Company> lists;
	private TextView tv_count = null;
	private KeyboardLayout mainView;
	private String content = "";
	private boolean isRes = false;
	private boolean key_enter = false;
	private boolean isSave = true;
	private int keystate = KeyboardLayout.KEYBOARD_STATE_HIDE;
	private String usertype, userid, devicetoken;
	private InputMethodManager manager; // 隐藏软键盘

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		usertype = HttpRestClient.UserType;
		System.out.println("sss" + usertype);
		userid = HttpRestClient.UserID;

		setContentView(R.layout.activity_company_unautherized);

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
				intent.putExtra("userid", userid);
				intent.putExtra("usertype", usertype);
				intent.putExtra("content", com);
				startActivity(intent);

			}
		});

		showProgressDialog();
		getCompanyname();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0.getId() == R.id.btn_company_seach) {
			// 搜索
			btn_company_seach.setVisibility(View.GONE);
			et_company_seach_name.setVisibility(View.VISIBLE);
			// SeachCompany();
		} else if (arg0.getId() == R.id.tv_company_cancel) {
			// 取消
			finish();
		}
	}

	//
	// /**
	// * 显示隐藏软键盘
	// */
	// private Handler m_Handle = new Handler() {
	// public void handleMessage(Message msg) {
	// if (1 == msg.what) {
	// InputMethodManager imm = (InputMethodManager)
	// getSystemService(Context.INPUT_METHOD_SERVICE);
	// if (keystate == KeyboardLayout.KEYBOARD_STATE_HIDE) {
	// imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	// }
	// } else if (2 == msg.what) {
	// InputMethodManager imm = (InputMethodManager)
	// getSystemService(Context.INPUT_METHOD_SERVICE);
	// if (imm.isActive()) {
	// if (keystate == KeyboardLayout.KEYBOARD_STATE_SHOW) {
	// imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
	// InputMethodManager.HIDE_NOT_ALWAYS);
	// }
	// }
	// }
	// }
	// };

	/**
	 * 公司名称
	 * 
	 */

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

							adapter.setList(lists);
							adapter.notifyDataSetChanged();

							listView.removeFootView();

						} else {
							showNetShortToast(httpCode);
						}
					}
				});
	}

	// /**
	// * 搜索公司
	// *
	// */
	// private void SeachCompany() {
	// // TODO 自动生成的方法存根
	//
	// // TODO 自动生成的方法存根
	// RequestParams params = new RequestParams();
	// params.put("KeyWords", et_company_seach_name.getText().toString());
	// HttpRestClient.get(CompanyActivity.this, HttpAPI.COMPANY_SEACH,
	// HttpRestClient.DeviceTOKEN, params, new ResponseUtils(
	// CompanyActivity.this) {
	//
	// @Override
	// public void getResult(int httpCode, String result) {
	// // TODO 自动生成的方法存根
	// dismissProgressDialog();
	// if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
	// CompanyListBean beans = JSON.parseObject(
	// JsonUtils.parseString(result),
	// CompanyListBean.class);
	// if (getData(beans)) {
	// return;
	// }
	//
	// if (page == 0) {
	// lists.clear();
	// adapter.setList(lists);
	// adapter.notifyDataSetChanged();
	// }
	//
	// List<Company> temp = beans.getData();
	// if (temp != null && temp.size() > 0) {
	// for (Company com : temp) {
	// lists.add(com);
	// }
	// }
	//
	// if (tv_count == null) {
	// tv_count = new TextView(CompanyActivity.this);
	// tv_count.setGravity(Gravity.CENTER);
	// tv_count.setLayoutParams(new AbsListView.LayoutParams(
	// AbsListView.LayoutParams.MATCH_PARENT,
	// AbsListView.LayoutParams.WRAP_CONTENT));
	// tv_count.setTextColor(getResources().getColor(
	// R.color.gray_txt_hint));
	// listView.addHeaderView(tv_count);
	// }
	//
	// adapter.setList(lists);
	// adapter.notifyDataSetChanged();
	//
	// listView.removeFootView();
	//
	// } else {
	// showNetShortToast(httpCode);
	// }
	// }
	// });
	//
	// }

}
