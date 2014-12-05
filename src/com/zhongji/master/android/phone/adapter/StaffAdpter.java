package com.zhongji.master.android.phone.adapter;

import java.util.ArrayList;
import java.util.List;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.R.id;
import com.zhongji.master.android.phone.adapter.CompanyAdpter.ViewHolder;
import com.zhongji.master.android.phone.entity.Company;
import com.zhongji.master.android.phone.entity.Staffer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 员工适配器
 * 
 * 
 */
public class StaffAdpter extends BaseAdapter {

	private Context context;
	private List<Staffer> lists;

	public StaffAdpter(Context context) {
		this.context = context;
		this.lists = new ArrayList<Staffer>();
	}

	public void setList(List<Staffer> lists) {
		this.lists = lists;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return lists.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO 自动生成的方法存根
		return lists.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO 自动生成的方法存根
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO 自动生成的方法存根
		ViewHolder viewholder;
		if (arg1 == null) {
			arg1 = View.inflate(context, R.layout.activity_company_staff, null);
			viewholder =new ViewHolder();
			viewholder.iv_company_staff_logo=(ImageView) arg1.findViewById(id.iv_company_staff_logo);
			viewholder.te_company_staff_name=(TextView) arg1.findViewById(id.te_company_staff_name);
			viewholder.tv_company_staff_department=(TextView) arg1.findViewById(id.tv_company_staff_department);
			arg1.setTag(viewholder);
		}else {
			viewholder=(ViewHolder) arg1.getTag();
		}
		
		Staffer staffer=lists.get(arg0);

		if(staffer!=null){
//			ImageLoaderUtils.getInstance().displayImage(context, info.getTximg(), holder.IvHead);
			int stage = Integer.parseInt(staffer.getProjectStage());
			
			viewholder.iv_company_staff_logo.setImageResource(R.drawable.company_staff_name);
			viewholder.te_company_staff_name.setText(staffer.getUserName());
			viewholder.tv_company_staff_department.setText(staffer.getDepartment());
		
		}

		return arg1;
	}

	class ViewHolder {
		ImageView  iv_company_staff_logo;
		TextView   te_company_staff_name;
		TextView   tv_company_staff_department;

	}
}
