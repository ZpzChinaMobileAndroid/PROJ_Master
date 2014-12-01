package com.zhongji.master.android.phone.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Toast;

import com.zhongji.master.android.phone.R;

public class PicEditText extends EditText{
	
	private Context context;
	private Bitmap bitmap;
	private Paint paint;
	private String text="111";
	private int line = 1;

	public PicEditText(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initial(context);
	}

	public PicEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initial(context);
	}

	public PicEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initial(context);
	}
	
	

	private void initial(Context context) {
		this.setBackground(null);
		this.addTextChangedListener(mTextWatcher);
		this.context = context;
		this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.contacts_publish_photo);
		this.paint = new Paint();
		this.paint.setColor(Color.RED);
		this.paint.setStyle(Style.STROKE);
		this.paint.setStrokeWidth(2);
		this.paint.setTextSize(24);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		
//		super.onDraw(canvas);
//		canvas.drawBitmap(bitmap, 0, 0, paint);
//		
		Path path = new Path();
		path.moveTo(bitmap.getWidth(), getHeight());
		path.lineTo(getWidth(), getHeight());
		canvas.drawPath(path, paint);
		canvas.drawTextOnPath(text, path, 0, 0, paint);
		
	}
	
	public TextWatcher mTextWatcher = new TextWatcher() {
		private CharSequence temp;
        private int editStart ;
        private int editEnd ;
        @Override
        public void beforeTextChanged(CharSequence s, int arg1, int arg2,
                int arg3) {
            temp = s;
        }
       
        @Override
        public void onTextChanged(CharSequence s, int arg1, int arg2,
                int arg3) {
//        	setText(s);
//            setText(s.toString());
        }
       
        @Override
        public void afterTextChanged(Editable s) {
            editStart = getSelectionStart();
            editEnd = getSelectionEnd();
            if (temp.length() > 150) {
                Toast.makeText(context,
                        "你输入的字数已经超过了限制！", Toast.LENGTH_SHORT)
                        .show();
                s.delete(editStart-1, editEnd);
                int tempSelection = editStart;
//                setText(s.toString());
//                setText(s);
                setSelection(tempSelection);
            }
        }
	};
	
	public void setText(String str) {
		text = str;
//		setText("abc "+text);
//		invalidate();
	};
}
