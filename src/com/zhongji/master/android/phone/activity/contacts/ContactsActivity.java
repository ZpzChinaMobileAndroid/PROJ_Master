package com.zhongji.master.android.phone.activity.contacts;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.activity.login.LoginActivity;
import com.zhongji.master.android.phone.adapter.ContactsAdapter;
import com.zhongji.master.android.phone.base.BaseIndexActivity;
import com.zhongji.master.android.phone.net.HttpRestClient;

/**
 * 人脉首页
 * @author admin
 *
 */
public class ContactsActivity extends BaseIndexActivity{
	
	private ContactsAdapter adapter;
	@ViewInject(id=R.id.listView1)
	private ListView listView1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		super.onClick(arg0);
		if(arg0.getId() == R.id.tv_right){
			//发布
			Intent intent = new Intent();
			if("".equals(HttpRestClient.DeviceTOKEN)){
				intent.setClass(ContactsActivity.this, LoginActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.login_in, R.anim.login_out);
			}else{
				intent.setClass(ContactsActivity.this, PublishActivity.class);
				startActivity(intent);
			}
			
			
		}
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
		setTitle("人脉");
		setRightBtn(this);
		
		listView1.addHeaderView(View.inflate(this, R.layout.items_list_contacts_top, null));
		
		adapter = new ContactsAdapter(ContactsActivity.this);
		listView1.setAdapter(adapter);
		
		
	}

	protected void onResume() {
	    //放到onResume就可以实现android 返回键动画
		overridePendingTransition(R.anim.logout_in, R.anim.logout_out);
	    super.onResume();
	}
	
}
