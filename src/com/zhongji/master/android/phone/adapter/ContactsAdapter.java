package com.zhongji.master.android.phone.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.entity.Project;

public class ContactsAdapter extends BaseAdapter{
	
	private Context context;
	private List<Project> lists;
	
	public ContactsAdapter(Context context) {
		this.context = context;
		this.lists = new ArrayList<Project>();
	}
 
	public void setLists(List<Project> lists) {
		this.lists = lists;
	}

	@Override 
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Project getItem(int arg0) {
		// TODO Auto-generated method stub
		return lists.get(arg0);
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
			convertView = View.inflate(context, R.layout.items_list_contacts_text_dynamic, null);
			holder = new ViewHolder();
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		if(position == 2){
			convertView = View.inflate(context, R.layout.items_list_contacts, null);
		}
		if(position == 4){
			convertView = View.inflate(context, R.layout.items_list_contacts_picture_dynamic, null);
		}
		
		
//		Project pro = lists.get(position);
//		
//		
//		if(pro!=null){
////			ImageLoaderUtils.getInstance().displayImage(context, info.getTximg(), holder.IvHead);
//			
//		}
		
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
