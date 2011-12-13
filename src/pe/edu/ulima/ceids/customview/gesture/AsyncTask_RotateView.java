package pe.edu.ulima.ceids.customview.gesture;

import android.os.AsyncTask;

public class AsyncTask_RotateView extends AsyncTask<Object, Void, Void>{

	@Override
	protected Void doInBackground(Object... params) {
		
		CustomView view = (CustomView) params[0];
		int angularVelocity = (Integer) params[1];
		
		int sum = 0;
    	
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
