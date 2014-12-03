package com.zhongji.master.android.phone.activity.login;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseSecondActivity;


/**
 * 找回密码
 * @author Admin
 *
 */

public class FoundPasswordActivity extends BaseSecondActivity implements  OnClickListener {

	
	@ViewInject (id=R.id.btn_next)
	private Button bt_next;
	@ViewInject (id=R.id.et_cellphone)
	private EditText et_cellphone;
	@ViewInject (id=R.id.et_verification)
	private EditText et_verification;
	@ViewInject (id=R.id.btn_send)
	private Button bt_send;
	private TimeCount time;
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foundpassword);
		time = new TimeCount(60000, 1000);//构造CountDownTimer对象
		 
	}
	
	@Override
	protected void init() {
		// TODO 自动生成的方法存根
		
		setTitle("找回密码");
		setLeftBtn();
		
	}
	
	
	@Override
	public void onClick(View arg0) {
		// TODO 自动生成的方法存根
		
	  if(arg0.getId()==R.id.btn_next){
	  //下一步
		String cellphone=et_cellphone.getText().toString().trim();
		String verificatio=et_verification.getText().toString().trim();
		
		if(cellphone.equals("")){
			showShortToast("请输入手机号");
			return;
		}else if(cellphone.length()!=11){
			showShortToast("请输入正确手机号码");
			return;
			
		}else if(verificatio.equals("")){
			showShortToast("请输入验证码");
			return;
		}else{
	 		  Intent intent=new Intent(FoundPasswordActivity.this,AffirmActivity.class);
	 		  startActivity(intent);
	 	  }
 	  }else if(arg0.getId()==R.id.btn_send){
 		  
 	  //发送验证码
 		 String cellphone=et_cellphone.getText().toString().trim();
 		  if(cellphone.equals("")){
 			  showShortToast("手机号码不正确，请重新输入");
 			  return;
 		  }else{
 		  time.start();
 		  
 		   }
 	    }
     }

	
	//倒计时
	class TimeCount extends CountDownTimer {
		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		}

		@Override
		public void onFinish() {// 计时完毕时触发
			bt_send.setText("获取验证码");
			bt_send.setBackgroundResource(R.drawable.login_send_backgroud);
			bt_send.setClickable(true);
		}

		@Override
		public void onTick(long millisUntilFinished) {// 计时过程显示
			bt_send.setClickable(false);
			bt_send.setBackgroundResource(R.drawable.register_sendbackgroud);
			bt_send.setText(millisUntilFinished / 1000 + "秒");
		}
	}
}
