package com.zhongji.master.android.phone.activity.contacts;

import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.adapter.CommentAdapter;
import com.zhongji.master.android.phone.base.BaseSecondActivity;

/**
 * 动态的详情
 * @author admin
 *
 */
public class DynamicDetailActivity extends BaseSecondActivity {

	@ViewInject(id=R.id.listView1)
	private ListView listView1;
	private CommentAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_dynamicdetial);
		
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

		setTitle("动态详情");
		setLeftBtn();

//		listView1.addHeaderView(View.inflate(this, R.layout.layout_contacts_text_dynamic, null));
		listView1.addHeaderView(View.inflate(this, R.layout.layout_contacts_picture_dynamic, null));
		
		adapter = new CommentAdapter(DynamicDetailActivity.this);
		listView1.setAdapter(adapter);
	}

}
