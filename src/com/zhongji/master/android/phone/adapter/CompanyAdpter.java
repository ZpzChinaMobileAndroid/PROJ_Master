package com.zhongji.master.android.phone.adapter;

import java.util.ArrayList;
import java.util.List;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.R.id;
import com.zhongji.master.android.phone.entity.Company;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *公司适配器 
 * @author Admin
 *
 */

public class CompanyAdpter extends BaseAdapter {

	
	private Context context;
	private List<Company> list;

	public CompanyAdpter(Context context) {
		this.context = context;
		this.list = new ArrayList<Company>();
	}

	public void setList(List<Company> lists) {
		this.list = lists;
	}

	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		return list.size();
	}

	@Override
	public Company getItem(int arg0) {
		// TODO 自动生成的方法存根
		return list.get(arg0);
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
			arg1 = View.inflate(context, R.layout.activity_company_item_content, null);
			viewholder =new ViewHolder();
			viewholder.iv_company_logo=(ImageView) arg1.findViewById(id.iv_company_logo);
			viewholder.tv_company_name=(TextView) arg1.findViewById(id.tv_company_name);
			viewholder.tv_company_industry=(TextView) arg1.findViewById(id.tv_company_industry);
			viewholder.tv_company_focusnumber=(TextView) arg1.findViewById(id.tv_company_focusnumber);
			arg1.setTag(viewholder);
		}else {
			viewholder=(ViewHolder) arg1.getTag();
		}
		
		Company company=list.get(arg0);

		if(company!=null){
//			ImageLoaderUtils.getInstance().displayImage(context, info.getTximg(), holder.IvHead);
			int stage = Integer.parseInt(company.getProjectStage());
			
			viewholder.iv_company_logo.setImageResource(R.drawable.company_icon);
			viewholder.tv_company_name.setText(company.getCompanyName());
			viewholder.tv_company_industry.setText(company.getCompanyIndustry());
			viewholder.tv_company_focusnumber.setText(company.getCompanyFocusNumber());
		
			
		}

		return arg1;
	}

	class ViewHolder {
		ImageView  iv_company_logo;
		TextView   tv_company_name;
		TextView   tv_company_industry;
		TextView   tv_company_focusnumber;

	}
}
