package com.example.promotionhunter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button b1;
	private Button b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button)findViewById(R.id.b1);
		b2 = (Button)findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
			switch(v.getId()){
				case R.id.b1:
					Intent I1 = new Intent();
					I1.setClass(MainActivity.this, SearchItem.class);
					startActivity(I1); 
					MainActivity.this.finish();
					break;
				case R.id.button2:
					Intent I2 = new Intent();
					I2.setClass(MainActivity.this, SearchShop.class);
					startActivity(I2);
					MainActivity.this.finish();
					break;
			}
	}
}
