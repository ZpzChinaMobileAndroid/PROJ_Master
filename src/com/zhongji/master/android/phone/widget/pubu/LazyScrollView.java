package com.zhongji.master.android.phone.widget.pubu;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
 
public class LazyScrollView extends ScrollView{
	private static final String tag="LazyScrollView";
	private Handler handler;
	private View view;
	public LazyScrollView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public LazyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public LazyScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	//�������ܵĸ߶�
	public int computeVerticalScrollRange(){
		return super.computeHorizontalScrollRange();
	}
	public int computeVerticalScrollOffset(){
		return super.computeVerticalScrollOffset();
	}
	private void init(){
		
		this.setOnTouchListener(onTouchListener);
		handler=new Handler(){
        	@Override
			public void handleMessage(Message msg) {
				// process incoming messages here
				super.handleMessage(msg);
				switch(msg.what){
				case 1:
					if(view.getMeasuredHeight() <= getScrollY() + getHeight()) {
						if(onScrollListener!=null){
							onScrollListener.onBottom();
						}
						
					}else if(getScrollY()==0){
						if(onScrollListener!=null){
							onScrollListener.onTop();
						}
					}
					else{
						if(onScrollListener!=null){
							onScrollListener.onScroll();
						}
					}
					break;
				default:
					break;
				}
			}
        };
		
	}
	
	  OnTouchListener onTouchListener=new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					break;
				case MotionEvent.ACTION_UP:
					if(view!=null&&onScrollListener!=null){
						handler.sendMessageDelayed(handler.obtainMessage(1), 200);
					}
					break;

				default:
					break;
				}
				return false;
			}
	    	
	    };
	    
	    /**
	     * ��òο���View����Ҫ��Ϊ�˻�����MeasuredHeight��Ȼ��͹�������ScrollY+getHeight���Ƚϡ�
	     */
	    public void getView(){
	    	this.view=getChildAt(0);
	    	if(view!=null){
	    		init();
	    	}
	    }
	    
	    /**
	     * ����ӿ�
	     * @author admin
	     *
	     */
	    public interface OnScrollListener{
	    	void onBottom();
	    	void onTop();
	    	void onScroll();
	    }
	    private OnScrollListener onScrollListener;
	    public void setOnScrollListener(OnScrollListener onScrollListener){
	    	this.onScrollListener=onScrollListener;
	    }
}