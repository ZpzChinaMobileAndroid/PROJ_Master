package com.zhongji.master.android.phone.activity.contacts;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseSecondActivity;
import com.zhongji.master.android.phone.entity.BaseBean;
import com.zhongji.master.android.phone.net.HttpAPI;
import com.zhongji.master.android.phone.net.HttpRestClient;
import com.zhongji.master.android.phone.net.ResponseUtils;
import com.zhongji.master.android.phone.util.BitmapUtil;
import com.zhongji.master.android.phone.util.DensityUtil;
import com.zhongji.master.android.phone.util.JsonUtils;
import com.zhongji.master.android.phone.util.PhotoUtils;
import com.zhongji.master.android.phone.widget.KeyboardLayout;
import com.zhongji.master.android.phone.widget.KeyboardLayout.onKybdsChangeListener;

/**
 * 发布动态
 * @author admin
 *
 */
public class PublishActivity extends BaseSecondActivity {

	@ViewInject(id = R.id.et_content)
	private EditText et_content;
	@ViewInject(id = R.id.tv_hint)
	private TextView tv_hint;
	@ViewInject(id = R.id.iv_photo)
	private ImageView iv_photo;
	@ViewInject(id = R.id.radioGroup1)
	private RadioGroup radioGroup1;
	@SuppressWarnings("unused")
	private boolean isEmpty = true;
	private String constart = "";
	private KeyboardLayout mainView;
	private Bitmap bit;
	private boolean isRes = false;
	private boolean key_enter = false;
	private PhotoUtils photoUtil = new PhotoUtils(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts_publish);

	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

		setTitle("发布动态");
		setLeftBtn();
		setRightBtn(this);

		mainView = (KeyboardLayout) findViewById(R.id.keyboardLayout1);
		keyboardlistener();
		et_content.addTextChangedListener(mTextWatcher);
		addImg("");
		constart = et_content.getText().toString();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		super.onClick(v);
		if(v.getId() == R.id.iv_photo){
			//拍照/相册
//			isRes = true;
			photoUtil.getDialog2();
		}else if(v.getId() == R.id.tv_right){
			//清空
			et_content.setText("");
			iv_photo.setImageResource(R.drawable.contacts_publish_photo);
			if(bit!=null){
				bit.recycle();
				bit = null;
			}
		}
	}
	
	/**
	 * 监听回车键
	 * 
	 * @param event
	 * @return
	 */
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER && !key_enter) {
			String content = et_content.getText().toString().replace(constart, "").trim();
			if (!content.trim().equals("")) {
				/* 隐藏软键盘 */
				isRes = true;
				key_enter = true;
				if(radioGroup1.getCheckedRadioButtonId() == R.id.radio0){
					showProgressDialog();
					sendDynamic(content);
				}else{
					showProgressDialog();
					sendProduct(content);
				}
				
			} else {
				showShortToast("说点什么...");
			}
			return true;
		}
		return super.dispatchKeyEvent(event);
	}
	
	/**
	 * 发布动态
	 * @param username
	 * @param userpassword
	 * 	1. EntityID:用户或者项目ID
	 *  2. ActiveText:动态文字
	 *  3. ActivePicture:动态图片名字，包含后缀
	 *  4. PictureStrings:图片内容，base64 无头
	 *  5. Type:类型，Personal or Project
	 */
	private void sendDynamic(String text) {
		// TODO 自动生成的方法存根
		Map<String, String> content = new LinkedHashMap<String, String>();
		content.put("EntityID", HttpRestClient.UserID);
		content.put("ActiveText", text);
//		content.put("ActivePicture", "");
		if(bit!=null){
			content.put("PictureStrings", BitmapUtil.bitmapToBase64(bit));
		}
//		content.put("CreatedBy", "");
		content.put("Category", HttpRestClient.UserType);
		HttpRestClient.post(PublishActivity.this, HttpAPI.PUBLISH_DYNAMIC, JsonUtils
				.change(content, false), new ResponseUtils(PublishActivity.this) {

			@Override
			public void getResult(int httpCode, String result) {
				// TODO 自动生成的方法存根
				dismissProgressDialog();
				if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
					key_enter = false;
					BaseBean bean = JSON.parseObject(
							JsonUtils.parseString(result), BaseBean.class);
					if (getData(bean)) {
						InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
						imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
						return;
					}
					showShortToast("发布成功");
					finish();
				} else {
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
					showNetShortToast(httpCode);
				}
			}
		});
	}
	
	/**
	 * 发布产品信息
	 * @param text
	 */
	private void sendProduct(String text) {
		// TODO 自动生成的方法存根
		Map<String, String> content = new LinkedHashMap<String, String>();
		content.put("ProductDescription", text);
		if(bit!=null){
			content.put("ProductImageStrings", BitmapUtil.bitmapToBase64(bit));
		}
		content.put("CreatedBy", HttpRestClient.UserID);
		HttpRestClient.post(PublishActivity.this, HttpAPI.PUBLISH_PRODUCT, JsonUtils
				.change(content, false), new ResponseUtils(PublishActivity.this) {

			@Override
			public void getResult(int httpCode, String result) {
				// TODO 自动生成的方法存根
				dismissProgressDialog();
				if (httpCode == HttpAPI.HTTP_SUCCESS_CODE) {
					key_enter = false;
					BaseBean bean = JSON.parseObject(
							JsonUtils.parseString(result), BaseBean.class);
					if (getData(bean)) {
						InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
						imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
						return;
					}
					showShortToast("发布成功");
					finish();
				} else {
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
					showNetShortToast(httpCode);
				}
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
//		isRes = true;
		if (resultCode == 0) {
			return;
		}
		
		// 上传图片
		bit = photoUtil
				.onActivityResult(requestCode, resultCode, intent);
		if(bit!=null){
			// 保存图片
			BitmapUtil.saveBitmap(PublishActivity.this, "photo.jpg", bit);
			iv_photo.setImageBitmap(bit);
		}
	}

	private ImageGetter imageGetter = new ImageGetter() {
		@Override
		public Drawable getDrawable(String source) {
			int id = Integer.parseInt(source);
			Drawable d = getResources().getDrawable(id);
			d.setBounds(0, 0, DensityUtil.dip2px(PublishActivity.this, 65), DensityUtil.dip2px(PublishActivity.this, 30));
			return d;
		}
	};

	TextWatcher mTextWatcher = new TextWatcher() {
		private CharSequence temp;
		private int editStart;
		private int editEnd;

		@Override
		public void beforeTextChanged(CharSequence s, int arg1, int arg2,
				int arg3) {
			if("".equals(s.toString())){
				isEmpty = true;
			}
			temp = s;
		}

		@Override
		public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
			if("".equals(s.toString())){
				isEmpty = true;
			}
//			mTextView.setText(s);
		}

		@Override
		public void afterTextChanged(Editable s) {
			editStart = et_content.getSelectionStart();
			editEnd = et_content.getSelectionEnd();
			
			if(!s.toString().contains(constart)){
				addImg(s.toString());
			}
			
			if(s.toString().length()>1){
				tv_hint.setVisibility(View.GONE);
			}else{
				tv_hint.setVisibility(View.VISIBLE);
			}
			int count = getCount(s);
			System.out.println(count);
			
			int index = s.toString().lastIndexOf(constart);
			System.out.println("---"+index);
			
			int lastindex = s.toString().indexOf(constart);
			System.out.println("---"+lastindex);
			System.out.println(s.toString().length());
			
			if(index >1 || (index==1 && s.toString().length()>1)){
				et_content.setText(s.delete(index, index+1));
				if(index >1){
					et_content.setSelection(s.toString().length());
				}else{
					et_content.setSelection(s.toString().length()+(editEnd-editStart)+1);
				}
			}else{
				// if(isEmpty ){//|| select == 1
				// addImg(content);
				// }

				if (temp.length() > 150) {
					Toast.makeText(PublishActivity.this, "你输入的字数已经超过了限制！",
							Toast.LENGTH_SHORT).show();
					s.delete(editStart - 1, editEnd);
//					int tempSelection = editStart;
					et_content.setText(s);
					et_content.setSelection(s.toString().length());
				}

			}
			
		}

	};
	
	private int getCount(Editable s) {
		Pattern pattern = Pattern.compile(constart);
		Matcher matcher = pattern.matcher(s.toString());
		int count=0;
		while(matcher.find()){
			count++;
		}
		return count;
	}
	
	/**
	 * 添加拍照图片
	 */
	private void addImg(String content) {
		isEmpty = false;
		et_content.setText(Html.fromHtml("<img src='" + R.drawable.contacts_publish_photo_hf + "' /><font>"+content.replace("\n", "<br>")+"</font>", imageGetter, null));
//		et_content.setHint(Html.fromHtml("<img src='" + R.drawable.contacts_publish_photo + "'/>&nbsp;<font color='#a8a8a8'>您在做什么? (限150字)</font>", imageGetter, null));
		et_content.setSelection(1);
	}
	
	/**
	 * 显示隐藏文本框
	 * 
	 * @param bool
	 */
	private void layoutchange(boolean bool) {
		if (bool) {
			
		} else {
			if(isRes){
				isRes = false;
				//弹键盘
			}else{
				finish();
			}
		}
	}

	/**
	 * 监听软键盘
	 */
	private void keyboardlistener() {
		mainView.setOnkbdStateListener(new onKybdsChangeListener() {

			@Override
			public void onKeyBoardStateChange(int state) {
				switch (state) {
				case KeyboardLayout.KEYBOARD_STATE_HIDE:
//					keystate = KeyboardLayout.KEYBOARD_STATE_HIDE;
					layoutchange(false);
//					 Toast.makeText(getApplicationContext(), "软键盘隐藏",
//					 Toast.LENGTH_SHORT).show();
					break;
				case KeyboardLayout.KEYBOARD_STATE_SHOW:
//					keystate = KeyboardLayout.KEYBOARD_STATE_SHOW;
					layoutchange(true);
//					 Toast.makeText(getApplicationContext(), "软键盘弹起",
//					 Toast.LENGTH_SHORT).show();
					break;
				}
			}
		});
	}

}
