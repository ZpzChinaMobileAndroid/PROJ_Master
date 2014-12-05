package com.zhongji.master.android.phone.base;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.activity.company.CompanyActivity;
import com.zhongji.master.android.phone.activity.company.CompanyMySelf;
import com.zhongji.master.android.phone.activity.contacts.ContactsActivity;
import com.zhongji.master.android.phone.activity.product.ProductActivity;
import com.zhongji.master.android.phone.activity.project.ProjectActivity;
import com.zhongji.master.android.phone.net.HttpRestClient;

public abstract class BaseIndexActivity extends BaseActivity implements
		OnClickListener {

	private TextView tv_left, tv_right;
	private RadioGroup base_ragroup_bottom;
	private int state = 0;
	private int INITIAL_STATE = 0;
	private int RUNNING_STATE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		//
		View view = View.inflate(this, R.layout.base_activity_index, null);
		LinearLayout base_layout_view = (LinearLayout) view
				.findViewById(R.id.base_layout_view);
		View child = View.inflate(this, layoutResID, null);
		child.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT));
		base_layout_view.addView(child);
		setContentView(view);

		init();

		base_ragroup_bottom = (RadioGroup) findViewById(R.id.base_ragroup_bottom);
		base_ragroup_bottom
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						// TODO Auto-generated method stub
						startActivity(checkedId);
					}

				});
	}
	private void startActivity(int checkedId) {
		// TODO Auto-generated method stub
		if (state == INITIAL_STATE) {
			state = RUNNING_STATE;
			return;
		}

		Intent intent = new Intent();
		// intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		switch (checkedId) {
		case R.id.radio0:
			// 人脉
			intent.setClass(this, ContactsActivity.class);
			break;
		case R.id.radio1:
			// 项目
			intent.setClass(this, ProjectActivity.class);
			break;
		case R.id.radio2:
			// 公司
			String usertype = HttpRestClient.UserType;
			String hascompany = HttpRestClient.hasCompany;

			if (usertype.equals("Personal") && hascompany.equals("false")) {
				intent.setClass(this, CompanyActivity.class);
			} else if (usertype.equals("Personal") && hascompany.equals("true")) {
				intent.setClass(this, CompanyMySelf.class);
			} else if (usertype.equals("Company")) {
				intent.setClass(this, CompanyMySelf.class);
			}

			break;
		case R.id.radio3:
			// 产品
			intent.setClass(this, ProductActivity.class);
			break;
		}

		startActivity(intent);
		overridePendingTransition(0, 0);
	}

	public int getRaGroupIndex() {
		String name = getRunningActivityName();
		if (ContactsActivity.class.toString().contains(name)) {
			return 0;
		} else if (ProjectActivity.class.toString().contains(name)) {
			return 1;
		} else if (CompanyActivity.class.toString().contains(name)
				|| CompanyMySelf.class.toString().contains(name)) {
			return 2;
		} else if (ProductActivity.class.toString().contains(name)) {
			return 3;
		}
		return 0;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		RadioButton childRaBtn = (RadioButton) base_ragroup_bottom
				.getChildAt(getRaGroupIndex());
		if (childRaBtn.isChecked()) {
			state = RUNNING_STATE;
		} else {
			state = INITIAL_STATE;
		}
		childRaBtn.setChecked(true);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			// startActivity(new Intent(BaseIndexActivity.this,
			// EmptyActivity.class));
			// showAkertDialog("是否退出！", new DialogInterface.OnClickListener() {
			// @Override
			// public void onClick(DialogInterface dialog,
			// int which) {
			// // TODO Auto-generated method stub
			// finish();
			// }
			// });
			break;
		default:
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * 获取当前activity
	 * 
	 * @return
	 */
	private String getRunningActivityName() {
		String contextString = BaseIndexActivity.this.toString();
		return contextString.substring(contextString.lastIndexOf(".") + 1,
				contextString.indexOf("@"));
	}

	/**
	 * 设置标题
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		TextView tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText(title);
	}

	public void setRightBtn(View.OnClickListener listener) {
		tv_right = (TextView) findViewById(R.id.tv_right);
		tv_right.setOnClickListener(listener);
		tv_right.setText("设置");
		tv_right.setVisibility(View.VISIBLE);
		tv_right.setTextColor(Color.TRANSPARENT);
		Drawable drawable = getResources().getDrawable(
				R.drawable.contacts_send_dynamic);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		tv_right.setCompoundDrawables(null, null, drawable, null);
	}

	public void setRightBtnMore(OnClickListener listener) {
		tv_right = (TextView) findViewById(R.id.tv_right);
		tv_right.setOnClickListener(listener);
		tv_right.setTextColor(Color.WHITE);
		tv_right.setVisibility(View.VISIBLE);
		tv_right.setText("更多");
	}
	
}
