package com.is413.simpledrawrect;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.graphics.Color;
import android.graphics.Paint; 
import android.graphics.Canvas; 
import android.graphics.Typeface;


public class DrawView extends View 
{
	/* define and instantiate Paint here - otherwise it will be created 
	 * and destroyed every time onView() is executed 
	 */
	private Paint paint = new Paint(); 
	private float x = 0; 
	private float y = 0; 
	private String drawString = ""; 
	private int width = 0; 
	private int height = 0; 
	private final String TAG = "My Tag"; 

	/* 
	 * this constructor must be defined when we extend View
	 */
	public DrawView(Context context) {
		super(context);
	}
	
	@Override
	public void onDraw(Canvas canvas)
	{
		height = this.getMeasuredHeight(); 
		width = this.getMeasuredWidth(); 
		Log.v(TAG, "The height is:"+height); 
		Log.v(TAG, "The width is:"+width); 
		
        // rectangle upper left
		paint.setColor(Color.RED); 
		paint.setStyle(Paint.Style.FILL); 
        paint.setStrokeWidth(3); 
        canvas.drawRect(0, 0, 100, 100, paint); 
        
       //circle in center
        paint.setColor(Color.CYAN); 
        canvas.drawCircle(width/2, height/2, 100, paint); 
        
        //rectangle lower right
        paint.setStyle(Paint.Style.FILL); 
        paint.setColor(Color.BLUE); 
        canvas.drawRect(width-100, height-100, width, height, paint); 
       
        // draw text 
        paint.setColor(Color.BLACK);    
        paint.setTextSize(20); 
        paint.setTypeface(Typeface.DEFAULT_BOLD); 
        // use below if the type face is not bold on your device
        //paint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        drawString = "The coordinates are x: "+this.x+" and y: "+this.y; 
        canvas.drawText(drawString, 10, height-20, paint); 
	}
	
	public void setTouchCoordinates(float x, float y)
	{
		this.x = x; 
		this.y = y; 
	}

} ///~
