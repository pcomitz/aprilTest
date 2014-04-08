package com.is413.simpledrawrect;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.app.Activity;
import android.graphics.Color;

/*
 * A project that illustrates how to draw on an Android
 * View 
 */
public class SimpleDrawRectActivity extends Activity 
{
	protected DrawView drawView = null; 
	protected float xTouchPosition = 0; 
	protected float yTouchPosition = 0; 
	private final String TAG = "My Tag"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		drawView = new DrawView(this); 
		drawView.setBackgroundColor(Color.LTGRAY); 
		setContentView(drawView);
		
		//set the TouchListener
		drawView.setOnTouchListener(new MyTouchListener()); 
	}
	
	private class MyTouchListener implements OnTouchListener
	{
		@Override
		public boolean onTouch(View view, MotionEvent event) 
		{
			boolean returnValue = false; 
			
			if(event.getAction()== MotionEvent.ACTION_DOWN)
			{	
				xTouchPosition = event.getX(); 
				yTouchPosition = event.getY(); 
				Log.v(TAG, "The coordinates are x: "+xTouchPosition+" and y: " +yTouchPosition); 
				drawView.setTouchCoordinates(xTouchPosition, yTouchPosition); 
				
				//will cause onDraw to be called
				drawView.invalidate(); 
				
				returnValue = true; 
			}
			return returnValue;
		}	
	} //inner class 
} ///~