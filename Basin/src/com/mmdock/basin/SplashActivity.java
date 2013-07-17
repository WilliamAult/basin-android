package com.mmdock.basin;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;

/**
 * @author Morgan Dock
 * 
 * This class will display a splash screen that will appear for a developer/company logo on start up.
 */
public class SplashActivity extends Activity {

	private Handler handler;
	private Thread thread;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//setContentView(R.layout.splash);  //This is needed, but splash needs to be added
		handler = new Handler();
	}

	@Override
	protected void onResume() {
		super.onResume();
		thread = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);//Wait 5 seconds
					handler.post(new Runnable() {
						public void run() {
							goToNextScreen();
						}
					});
				} catch (InterruptedException e) {
				}
			}
		};

		thread.start();
	}

	/**
	 * Proceed to the Menu
	 */
	protected void goToNextScreen() {
		Intent intent = new Intent(this, com.randymcollier.basin.MainActivity.class);
		startActivity(intent);
	}

}
