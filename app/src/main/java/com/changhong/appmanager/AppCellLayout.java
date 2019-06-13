package com.changhong.appmanager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AppCellLayout extends LinearLayout {

	private static final String TAG = "HongLauncher";
	private boolean needTurnToRight = false;
	private boolean needTurnToLeft = false;
	public ImageView mImgView = null;
	public TextView mTextView = null;
	private int position = 0;

	private Context mContext;
	private RelativeLayout zhou_app_bkg;

	public AppCellLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(R.layout.layout_app_cell, this, true);
		mContext = context;
		mImgView = (ImageView)findViewById(R.id.img);
		mTextView = (TextView)findViewById(R.id.text);
		zhou_app_bkg=(RelativeLayout)findViewById(R.id.zhou_app_bkg);
	}

	/*����ͼƬ�ӿ�*/
	public void setImageResource(int resId){
		mImgView.setImageResource(resId);
	}

	public void setImageDrawable(Drawable drawable){
		mImgView.setImageDrawable(drawable);
	}

	/*�������ֽӿ�*/
	public void setText(String str){
		mTextView.setText(str);
	}
	/*�������ִ�С*/
	public void setTextSize(float size){
		mTextView.setTextSize(size);
	}

	public void setBackground(int bkg) {
		
		zhou_app_bkg.setBackgroundResource(bkg);
		
	}
	
	public boolean isNeedToTurnLeft() 
	{
		return needTurnToLeft;
	}
	
	public void setTurnLeft(boolean needToTurnLeft) 
	{
		this.needTurnToLeft = needToTurnLeft;
	}
	
	public boolean isNeedToTurnRight() 
	{
		return needTurnToRight;
	}
	
	public void setTurnRight(boolean needToTurnRight) 
	{
		this.needTurnToRight = needToTurnRight;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}
	
	public int getPosition()
	{
		return position;
	}
	
	public void setHorizontallyScrolling() {
		
		mTextView.setFocusable(true);
		mTextView.setFocusableInTouchMode(true);
		mTextView.setSingleLine(true);
		mTextView.setEllipsize(TruncateAt.MARQUEE);

		mTextView.setHorizontallyScrolling(true);
		mTextView.setMarqueeRepeatLimit(-1);
		
	}
	
	/*public void setautoscroll() {
		
		mTextView.setSingleLine(true);
		//zmTextView.setFocusable(true);
		//zmTextView.setFocusableInTouchMode(true);
		mTextView.setEllipsize(TruncateAt.MARQUEE);

		mTextView.setHorizontallyScrolling(true);
		mTextView.setMarqueeRepeatLimit(-1);
		mTextView.setSelected(true);
	}*/
	
	
}