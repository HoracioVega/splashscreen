package com.example.splashfragment;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	 AnimationDrawable myAnimationDrawable;
	 Timer timer;
	 MyTimerTask myTimerTask;
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        ImageView myAnimation = (ImageView)findViewById(R.id.imageView1);
	        myAnimationDrawable 
	         = (AnimationDrawable)myAnimation.getDrawable();

	        myAnimation.post(
	          new Runnable(){

	     @Override
	     public void run() {
	      myAnimationDrawable.start();
	     }
	          });
	        
	        //Calculate the total duration
	        int duration = 0;
	        for(int i = 0; i < myAnimationDrawable.getNumberOfFrames(); i++){
	         duration += myAnimationDrawable.getDuration(i);
	        }
	        
	        timer = new Timer();
	        myTimerTask = new MyTimerTask();
	        //timer.schedule(myTimerTask, duration);
	        timer.schedule(myTimerTask, 5000);
	    }
	    
	    class MyTimerTask extends TimerTask {

	  @Override
	  public void run() {
	   
	   timer.cancel();
	   runOnUiThread(new Runnable(){
	    @Override
	    public void run() {
	    	
	    Intent intent = new Intent(
	    		MainActivity.this, LoginActivity.class);
	    startActivity(intent);
	    	
	     Toast.makeText(getApplicationContext(), 
	       "Animation Stopped", 
	       Toast.LENGTH_SHORT).show(); 
	    }});
	  }  
	 }

}
