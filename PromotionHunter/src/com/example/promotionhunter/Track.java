package com.example.promotionhunter;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Track extends Activity {
	Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_track);
		intent = new Intent();
		ListView lv = (ListView)findViewById(R.id.listView1);
		System.out.println("0202");
		String[] name =  (String[])getIntent().getSerializableExtra("name");
		System.out.println("0101");
		ArrayList<HashMap<String,Object>> shop = new ArrayList<HashMap<String,Object>>();
		for(int i=0; i<name.length;i++){
			HashMap<String,Object> data = new HashMap<String,Object>();
			data.put("name",name[i]);
			shop.add(data);
		}
		System.out.println("0303");
		SimpleAdapter adapter = new SimpleAdapter(this,shop,
				R.layout.track_list,new String[]{"name"},
				new int[]{R.id.textView1});
		lv.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.track, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
