package com.example.starter_project;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	Button buttonOK;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		buttonOK = (Button) findViewById(R.id.button_ok);
		buttonOK.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this, Questions.class);
						startActivity(intent);
					}
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
