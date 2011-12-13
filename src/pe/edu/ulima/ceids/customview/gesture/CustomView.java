package pe.edu.ulima.ceids.customview.gesture;


import android.content.Context;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.widget.ImageView;

public class CustomView extends ImageView {

	
	private int direction;
	
	public CustomView(Context context) {
		super(context);
		super.setImageResource(R.drawable.circulo);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		int height = this.getHeight();
	    int width = this.getWidth();

	    canvas.rotate(this.direction, width / 2, height / 2);
		
		super.onDraw(canvas);
	}

	public void rotateView(float linealVelocityX, float linealVelocityY, int radius){
		
		if(radius == 0){
    		return;
    	}
    	
    	double vector = Math.sqrt(Math.pow(linealVelocityX, 2) + Math.pow(linealVelocityY, 2));
    	
    	double centripetalAcceleration = Math.pow( vector , 2)/radius;
    	
    	int angularVelocity = (int) Math.sqrt(centripetalAcceleration/radius);
    	
    	new AsyncTask_RotateView().execute(this, angularVelocity);
		
	}
	
	public void changeDirection(int direction){

		this.direction = direction;
		
	}
	
	private class AsyncTask_RotateView extends AsyncTask<Object, Void, Void>{

		@Override
		protected Void doInBackground(Object... params) {
			
			CustomView view = (CustomView) params[0];
			int angularVelocity = (Integer) params[1];
			
			int sum = direction;
	    	
	    	while(angularVelocity > 0){
	    		
	    		angularVelocity--;
	    		sum += angularVelocity;
	    		if(sum>360){
	    			sum-=360;
	    		}
	    		System.out.println("Direction: "+sum);
	    		System.out.println("Angular: "+angularVelocity);
	    		view.changeDirection(sum);
	    		view.postInvalidate();
	    		try {
					Thread.sleep(80);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
			
			return null;
		}

	}
	
}
