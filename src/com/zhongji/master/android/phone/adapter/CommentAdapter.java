package com.zhongji.master.android.phone.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhongji.master.android.phone.R;

public class CommentAdapter extends BaseAdapter{
	
	private Context context;
	
	public CommentAdapter(Context context) {
		this.context = context;
	}
 

	@Override 
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView == null){ 
			convertView = View.inflate(context, R.layout.items_list_contacts_comment, null);
			holder = new ViewHolder();
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		
		return convertView;
	}
	
	class ViewHolder{
		TextView tv_proname;
		ImageView iv_prostage;
		TextView tv_investmentmoney;
		TextView tv_buildarea;
		TextView tv_starttime;
		TextView tv_endtime;
		ImageView iv_map;
		TextView tv_district;
		TextView tv_address;
		ImageView iv_more;
	}

}
