package com.zhongji.master.android.phone.activity.contacts;

import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.adapter.ContactsPersonDetailAdapter;
import com.zhongji.master.android.phone.base.BaseSecondActivity;

/**
 * 人的详情
 * @author admin
 *
 */
public class PersonDetailActivity extends BaseSecondActivity {

	@ViewInject(id=R.id.listView1)
	private ListView listView1;
	private ContactsPersonDetailAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_persondetial);

	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

		setTitle("人的详情");
		setLeftBtn();

		listView1.addHeaderView(View.inflate(this, R.layout.items_list_contacts_top, null));
		
		adapter = new ContactsPersonDetailAdapter(PersonDetailActivity.this);
		listView1.setAdapter(adapter);
	}

}
