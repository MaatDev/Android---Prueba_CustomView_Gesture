package pe.edu.ulima.ceids.customview.gesture;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;


public class Prueba_CustomView_GestureActivity extends Activity {
    
	private GestureDetector gestureDetector;
	
	private View.OnTouchListener touchListener;
	
	private CustomView view;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        System.out.println("Start");
        
        this.view = new CustomView(this);
        this.setListeners();
        this.view.setOnTouchListener(this.touchListener);
        
        setContentView(this.view);
    }
    
    private void setListeners(){
    	this.gestureDetector = new GestureDetector(this, new CustomGestureDetector());
    	this.touchListener = new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				System.out.println("Touch!");
				if(gestureDetector.onTouchEvent(event)){
					return true;
				}else{
					return false;
				}
			}
		};
    }
    
    public class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener{
          	
    	@Override
    	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
    			float velocityY) {
    		
//    		Log.d(getClass().getSimpleName(),"onFling: "+calculateInstantAngularVelocity(velocityX, velocityY, 70));
//    	
//    		rotateView( calculateInstantAngularVelocity(velocityX, velocityY, 70) );
    		    		
    		Log.d(getClass().getSimpleName(),"onFling");
    		
    		view.rotateView(velocityX, velocityY, 80);
    		
    		return true;
    	}
    	
    	@Override
    	public boolean onDown(MotionEvent e) {
    		// TODO Auto-generated method stub
    		return true;
    	}
    	
    }
    
//    private void rotateView(int angularVelocity){
//    	
//    	new AsyncTask_RotateView().execute(this.view, angularVelocity);
//    	
//    }
//    
//    private int calculateInstantAngularVelocity(float linealVelocityX, float linealVelocityY, int radius){
//    	
//    	if(radius == 0){
//    		return 1;
//    	}
//    	
//    	double vector = Math.sqrt(Math.pow(linealVelocityX, 2) + Math.pow(linealVelocityY, 2));
//    	
//    	double centripetalAcceleration = Math.pow( vector , 2)/radius;
//    	
//    	return (int) Math.sqrt(centripetalAcceleration/radius);
//    	
//    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	super.finish();
    }
    
}