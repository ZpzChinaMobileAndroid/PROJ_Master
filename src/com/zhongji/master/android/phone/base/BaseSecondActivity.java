package com.zhongji.master.android.phone.base;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.until.DensityUtil;

public abstract class BaseSecondActivity extends BaseActivity implements OnClickListener{
	
	private RadioGroup base_ragroup_bottom;
	private TextView tv_left, tv_right;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
	    
		View view = View.inflate(this, R.layout.base_activity_index, null);
		LinearLayout base_layout_view = (LinearLayout) view.findViewById(R.id.base_layout_view);
		View child = View.inflate(this, layoutResID, null);
		child.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
		base_layout_view.addView(child);
		setContentView(view);
		init();
		
		base_ragroup_bottom = (RadioGroup) findViewById(R.id.base_ragroup_bottom);
		base_ragroup_bottom.setVisibility(View.GONE);
	}
	
	public void setLeftBtn() {
		tv_left = (TextView) findViewById(R.id.tv_left);
		tv_left.setOnClickListener(this);
		tv_left.setTextColor(Color.TRANSPARENT);
		tv_left.setVisibility(View.VISIBLE);
		tv_left.setGravity(Gravity.CENTER_VERTICAL);
		tv_left.setText("返回");
		Drawable drawable = getResources().getDrawable(R.drawable.register_back);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		tv_left.setCompoundDrawables(drawable, null, null, null);
	}
	
	public void setLeftBtn_X() {
		tv_left = (TextView) findViewById(R.id.tv_left);
		RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		rl.addRule(RelativeLayout.CENTER_VERTICAL);
		rl.setMargins(DensityUtil.dip2px(this, 20), 0, 0, 0);
		tv_left.setLayoutParams(rl);
		tv_left.setOnClickListener(this);
		tv_left.setTextColor(Color.TRANSPARENT);
		tv_left.setVisibility(View.VISIBLE);
		tv_left.setGravity(Gravity.CENTER_VERTICAL);
		tv_left.setText("返回");
		
		Drawable drawable = getResources().getDrawable(R.drawable.login_anonymity);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		tv_left.setCompoundDrawables(drawable, null, null, null);
	}
	
	public void setRightBtn(OnClickListener listener) {
		tv_right = (TextView) findViewById(R.id.tv_right);
		tv_right.setOnClickListener(listener);
		tv_right.setTextColor(Color.WHITE);
		tv_right.setVisibility(View.VISIBLE);
		tv_right.setText("清空");
	}
	
	public void setRightBtnMore(OnClickListener listener) {
		tv_right = (TextView) findViewById(R.id.tv_right);
		tv_right.setOnClickListener(listener);
		tv_right.setTextColor(Color.WHITE);
		tv_right.setVisibility(View.VISIBLE);
		tv_right.setText("更多");
	}
	
	
//	/**
//	 * 设置搜索背景
//	 * 
//	 * @param title
//	 */
//	public void setTitlebackgroud(String title, OnClickListener listener) {
//		LinearLayout layout_title = (LinearLayout) findViewById(R.id.layout_title);
//		RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//		rl.addRule(RelativeLayout.LEFT_OF, R.id.tv_right);
//		rl.addRule(RelativeLayout.RIGHT_OF, R.id.tv_left);
//		rl.addRule(RelativeLayout.CENTER_IN_PARENT);
//		layout_title.setLayoutParams(rl);
//		layout_title.setOnClickListener(listener);
//		layout_title.setBackgroundResource(R.drawable.seach_basemap);
//		TextView tv_title = (TextView) findViewById(R.id.tv_title);
//		tv_title.setOnClickListener(listener);
//		tv_title.setGravity(Gravity.CENTER);
//		tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getDimension(R.dimen.activity_14_size) / getResources().getDisplayMetrics().density);
//		Drawable drawable = getResources().getDrawable(R.drawable.seach_find_seach);
//		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
//		tv_title.setCompoundDrawables(drawable, null, null, null);
//		tv_title.setPadding(0, DensityUtil.dip2px(this, 5), 0, DensityUtil.dip2px(this, 5));
//		tv_title.setText(title);
//	}
//	
//	/**
//	 * 设置搜索条
//	 * 
//	 * @param title
//	 */
//	public void setTitleSeach(OnClickListener listener) {
//		TextView tv_title = (TextView) findViewById(R.id.tv_title);
//		EditText et_seach_result_start = (EditText) findViewById(R.id.et_seach_result_start);
//		tv_right = (TextView) findViewById(R.id.tv_right);
//		tv_right.setOnClickListener(listener);
//		tv_right.setText("取消");
//		tv_title.setVisibility(View.GONE);
//		et_seach_result_start.setVisibility(View.VISIBLE);
//		
//	}
	
	public void onClick(View v) {
		if (v.getId() == R.id.tv_left) {
			// 左
			finish();
		} else if (v.getId() == R.id.tv_right) {
			// 右
		}
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
}
