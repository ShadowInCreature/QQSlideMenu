package com.sjb.tencent.tencentqq.swipe;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;


public class FrontLayout extends RelativeLayout {

	private SwipeLayoutInterface mISwipeLayout;

	public FrontLayout(Context context) {
		super(context);
	}

	public FrontLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public FrontLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void setSwipeLayout(SwipeLayoutInterface mSwipeLayout){
		this.mISwipeLayout = mSwipeLayout;
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if(mISwipeLayout.getCurrentStatus() == SwipeLayout.Status.Close){
			return super.onInterceptTouchEvent(ev);
		}else {
			return true;//当前条目打开，直接消费事件
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(mISwipeLayout.getCurrentStatus() == SwipeLayout.Status.Close){
			return super.onTouchEvent(event);
		}else {//当前条目打开，则抬起时就关闭它
			if(event.getActionMasked() == MotionEvent.ACTION_UP){
				mISwipeLayout.close();
			}
			return true;
		}
	}

}
