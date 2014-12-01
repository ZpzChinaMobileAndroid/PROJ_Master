package com.zhongji.master.android.phone.activity.contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhongji.master.android.phone.R;
import com.zhongji.master.android.phone.base.BaseSecondActivity;
import com.zhongji.master.android.phone.widget.KeyboardLayout;
import com.zhongji.master.android.phone.widget.KeyboardLayout.onKybdsChangeListener;

/**
 * 发布动态
 * @author admin
 *
 */
public class PublishActivity extends BaseSecondActivity {

	@ViewInject(id = R.id.editText1)
	private EditText editText1;
	@ViewInject(id = R.id.textView1)
	private TextView textView1;
	@SuppressWarnings("unused")
	private boolean isEmpty = true;
	private String constart = "";
	private KeyboardLayout mainView;
	private InputMethodManager manager; // 隐藏软键盘

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
		setRightBtn(null);

		manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		mainView = (KeyboardLayout) findViewById(R.id.keyboardLayout1);
		keyboardlistener();
		
		editText1.addTextChangedListener(mTextWatcher);
		addImg("");
		constart = editText1.getText().toString();
	}

	private ImageGetter imageGetter = new ImageGetter() {
		@Override
		public Drawable getDrawable(String source) {
			int id = Integer.parseInt(source);
			Drawable d = getResources().getDrawable(id);
			d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
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
			editStart = editText1.getSelectionStart();
			editEnd = editText1.getSelectionEnd();
			
			if(!s.toString().contains(constart)){
				addImg(s.toString());
			}
			
			if(s.toString().length()>1){
				textView1.setVisibility(View.GONE);
			}else{
				textView1.setVisibility(View.VISIBLE);
			}
			int count = getCount(s);
			System.out.println(count);
			
			int index = s.toString().lastIndexOf(constart);
			System.out.println("---"+index);
			
			int lastindex = s.toString().indexOf(constart);
			System.out.println("---"+lastindex);
			System.out.println(s.toString().length());
			
			if(index >1 || (index==1 && s.toString().length()>1)){
				editText1.setText(s.delete(index, index+1));
				if(index >1){
					editText1.setSelection(s.toString().length());
				}else{
					editText1.setSelection(s.toString().length()+(editEnd-editStart)+1);
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
					editText1.setText(s);
					editText1.setSelection(s.toString().length());
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
		editText1.setText(Html.fromHtml("<img src='" + R.drawable.contacts_publish_photo_hf + "' /><font>"+content.replace("\n", "<br>")+"</font>", imageGetter, null));
//		editText1.setHint(Html.fromHtml("<img src='" + R.drawable.contacts_publish_photo + "'/>&nbsp;<font color='#a8a8a8'>您在做什么? (限150字)</font>", imageGetter, null));
		editText1.setSelection(1);
	}
	
	/**
	 * 显示隐藏文本框
	 * 
	 * @param bool
	 */
	private void layoutchange(boolean bool) {
		if (bool) {
			
		} else {
			finish();
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
