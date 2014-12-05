package com.zhongji.master.android.phone.activity.contacts;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.RequestParams;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.activity.login.LoginActivity;
import com.zhongji.master.android.phone.adapter.ContactsAdapter;
import com.zhongji.master.android.phone.base.BaseIndexActivity;
import com.zhongji.master.android.phone.entity.DynamicListBean;
import com.zhongji.master.android.phone.entity.Dynamic_Comments;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.util.JsonUtils;

/**
 * 人脉首页
 * @author admin
 *
 */
public class ContactsActivity extends BaseIndexActivity{
	
	private ContactsAdapter adapter;
	@ViewInject(id=R.id.listView1)
	private ListView listView1;
	
	private List<Dynamic_Comments> lists;
	
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
				startActivityForResult(intent,10);
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
		lists = new ArrayList<Dynamic_Comments>();
		adapter = new ContactsAdapter(ContactsActivity.this);
		listView1.setAdapter(adapter);
		
		showProgressDialog();
		dynamicList();
	}

	/**
	 * 动态列表
	 * @param text
	 */
	private void dynamicList() {
		// TODO 自动生成的方法存根
		RequestParams content = new RequestParams();
		content.put("EntityID", HttpRestClient.UserID);
		content.put("pageSize", size);
		content.put("pageIndex", page);
		HttpRestClient.get(HttpAPI.DYNAMIC_LIST, content, new ResponseUtils(ContactsActivity.this) {

			@Override
			public void getResult(int httpCode, String result) {
				// TODO 自动生成的方法存根
				dismissProgressDialog();
				if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
					DynamicListBean bean = JSON.parseObject(
							JsonUtils.parseString(result), DynamicListBean.class);
					if (getData(bean)) {
						return;
					}
					
					List<Dynamic_Comments> temp = bean.getData();
					if(temp!=null && temp.size()>0){
						for(Dynamic_Comments pro : temp){
							lists.add(pro);
						}
					}
					
					adapter.setLists(lists);
					adapter.notifyDataSetChanged();
					
					
				} else {
					showNetShortToast(httpCode);
				}
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (resultCode == 0) {
			return;
		}
		if(requestCode == 10 && resultCode == 10){
			//放到onResume就可以实现android 返回键动画
			overridePendingTransition(R.anim.logout_in, R.anim.logout_out);
		}
		super.onActivityResult(requestCode, resultCode, data);  
	}
}
