package com.zhongji.master.android.phone.login;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseActivity;

/**
 * 确认找回
 * @author Admin
 *
 */
public class AffirmActivity  extends BaseActivity implements OnClickListener{

	
	@ViewInject (id=R.id.bt_affirm)
	private Button bt_affirm;
	@ViewInject (id=R.id.et_newpassword)
	private EditText et_newpassword;
	@ViewInject (id=R.id.et_sencendpassword)
	private EditText et_sencendpassword;
	@ViewInject(id=R.id.im_back)
	private ImageView im_back;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_affirm);
		
	}
	
	
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		super.onClick(arg0);
		if(arg0.getId()==R.id.bt_affirm){
			//下一步
//		String newpassword=et_newpassword.getText().toString().trim();
//		String sencendpassword=et_sencendpassword.getText().toString().trim();
//				
//		if(newpassword.equals("")){
//			showShortToast("请输入新密码");
//			return;
//		}else if(sencendpassword.equals("")){
//			showShortToast("请再次输入新密码");
//			return;
//		}else if(!newpassword.equals(sencendpassword)){
//			showShortToast("对不起您输入的两次密码不同，请重新输入");
//			return;
//					
//		}else{
//			 Intent intent=new Intent(AffirmActivity.this,LoginActivity.class);
//			 startActivity(intent);
//			 finish();
//		}
	}	else if(arg0.getId()==R.id.im_back){
		 //返回
		  Intent intent=new Intent(AffirmActivity.this,FoundPasswordActivity.class);
		  startActivity(intent);
		  finish();
		 		  
	 }
  }
	
	@Override
	protected void init() {
		// TODO 自动生成的方法存根
		
	}
}
