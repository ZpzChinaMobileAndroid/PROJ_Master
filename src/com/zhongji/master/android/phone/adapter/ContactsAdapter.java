package com.zhongji.master.android.phone.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.entity.Comments;
import com.zhongji.master.android.phone.entity.Dynamic_Comments;
import com.zhongji.master.android.phone.util.ImageLoaderUtils;

public class ContactsAdapter extends BaseAdapter{
	
	private Context context;
	private List<Dynamic_Comments> lists;
	private final int INTEGER_TXT = R.layout.items_list_contacts_text_dynamic;
	private final int INTEGER_PIC = R.layout.items_list_contacts_picture_dynamic;
	private final int INTEGER_PRO = R.layout.items_list_contacts;
	
	public ContactsAdapter(Context context) {
		this.context = context;
		this.lists = new ArrayList<Dynamic_Comments>();
	}
 
	public void setLists(List<Dynamic_Comments> lists) {
		this.lists = lists;
	}

	@Override 
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public Dynamic_Comments getItem(int arg0) {
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
		ViewHolder holder = null;
        View convertView_txt,convertView_pic,convertView_pro;
		Dynamic_Comments bean = lists.get(position);
		if("Actives".equals(bean.getActives().getEventType())){
			//动态
			if(TextUtils.isEmpty(bean.getActives().getImageLocation())){
				//图片路径是空
				convertView_txt = convertView;
				if(convertView_txt == null || convertView_txt.getTag(INTEGER_TXT) == null){
					holder = new ViewHolder();
					convertView_txt = View.inflate(context, R.layout.items_list_contacts_text_dynamic, null);
					holder.iv_head = (ImageView) convertView_txt.findViewById(R.id.iv_head);
					holder.tv_content = (TextView) convertView_txt.findViewById(R.id.tv_content);
					holder.iv_comment = (ImageView) convertView_txt.findViewById(R.id.iv_comment);
					holder.layout_dynamic_comment = (LinearLayout) convertView_txt.findViewById(R.id.layout_dynamic_comment);
					convertView_txt.setTag(INTEGER_TXT, holder);
				}else{
	                holder = (ViewHolder) convertView_txt.getTag(INTEGER_TXT);
	            }
				 convertView = convertView_txt;
			}else{
				convertView_pic = convertView;
				if(convertView_pic == null || convertView_pic.getTag(INTEGER_PIC) == null){
					holder = new ViewHolder();
					convertView_pic = View.inflate(context, R.layout.items_list_contacts_picture_dynamic, null);
					holder.iv_head = (ImageView) convertView_pic.findViewById(R.id.iv_head);
					holder.tv_content = (TextView) convertView_pic.findViewById(R.id.tv_content);
					holder.iv_comment = (ImageView) convertView_pic.findViewById(R.id.iv_comment);
					holder.iv_pic = (ImageView) convertView_pic.findViewById(R.id.iv_pic);
					holder.layout_dynamic_comment = (LinearLayout) convertView_pic.findViewById(R.id.layout_dynamic_comment);
					convertView_pic.setTag(INTEGER_PIC, holder);
				}else{
	                holder = (ViewHolder) convertView_pic.getTag(INTEGER_PIC);
	            }
				 convertView = convertView_pic;
			}
		}else{
			//项目
			convertView_pro = convertView;
			if(convertView_pro == null || convertView_pro.getTag(INTEGER_PRO) == null){
				holder = new ViewHolder();
				convertView_pro = View.inflate(context, R.layout.items_list_contacts, null);
				convertView_pro.setTag(INTEGER_PRO, holder);
			}else{
				holder = (ViewHolder) convertView_pro.getTag(INTEGER_PRO);
			}
			 convertView = convertView_pro;
		}
		
		
		
		if("Actives".equals(bean.getActives().getEventType())){
			//动态
			if(!TextUtils.isEmpty(bean.getActives().getImageLocation())){
				//有图片
//				ImageLoaderUtils.getInstance().displayImage(context, bean.getActives().getImageLocation(), holder.iv_pic);
			}
			//头像
//			ImageLoaderUtils.getInstance().displayImage(context, bean.getActives().getAvatarUrl(), holder.iv_head);
			//文字内容
			holder.tv_content.setText(bean.getActives().getContent());
			
			if(Integer.parseInt(bean.getActives().getCommentsCount()) > 0){
				List<Comments> clists = bean.getComments();
				holder.layout_dynamic_comment.setVisibility(View.VISIBLE);
				holder.layout_dynamic_comment.removeAllViews();
			
				for(Comments comment : clists){
					View child = View.inflate(context, R.layout.items_list_contacts_comment, null);
					ImageView iv_head = (ImageView) child.findViewById(R.id.iv_comment_head);
					TextView tv_content = (TextView) child.findViewById(R.id.tv_comment_content);
					TextView tv_time = (TextView) child.findViewById(R.id.tv_comment_time);
					ImageLoaderUtils.getInstance().displayImage(context, comment.getUserImage(), iv_head);
					tv_content.setText(comment.getCommentContents());
					tv_time.setText(comment.getCreatedTime());
					holder.layout_dynamic_comment.addView(child);
				}
				
			}else{
				holder.layout_dynamic_comment.setVisibility(View.GONE);
			}
		}else{
			//项目
		}
		
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView iv_head;
		TextView tv_content;
		ImageView iv_comment;
		ImageView iv_pic;
		LinearLayout layout_dynamic_comment;
	}

}
