package com.zhongji.master.android.phone.activity.contacts;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.adapter.CenterAdapter;
import com.zhongji.master.android.phone.base.BaseSecondActivity;

/**
 * 个人中心
 * @author admin
 *
 */
public class CenterActivity extends BaseSecondActivity{
	
	private CenterAdapter adapter;
	@ViewInject(id=R.id.listView1)
	private ListView listView1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_center);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		super.onClick(arg0);
		if(arg0.getId() == R.id.tv_right){
			//账号设置
			Intent intent = new Intent();
			intent.setClass(CenterActivity.this, AccountActivity.class);
			startActivity(intent);
		}
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
		setTitle("个人中心");
		setRightSettingBtn(CenterActivity.this);
		
		listView1.addHeaderView(View.inflate(this, R.layout.items_list_contacts_top, null));
		
		adapter = new CenterAdapter(CenterActivity.this);
		listView1.setAdapter(adapter);
		
		
	}

}
