package com.example.promotionhunter;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Goods extends Activity implements OnClickListener {
	Intent intent;
	int m;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_goods);		
		intent = new Intent();		
		Button button =(Button)findViewById(R.id.b1);		
		ListView lv = (ListView)findViewById(R.id.listView1);
		String[] goods =  (String[])getIntent().getSerializableExtra("goods");
		int[] Price =  (int[])getIntent().getSerializableExtra("Price");
		String n = getIntent().getStringExtra("number");
		System.out.println(n);
		m =Integer.valueOf(n);
		
		System.out.println(goods[0]);
		System.out.println(Price[0]);
		
		ArrayList<HashMap<String,Object>> shop = new ArrayList<HashMap<String,Object>>();
		
		for(int i=0; i<goods.length;i++){
			HashMap<String,Object> data = new HashMap<String,Object>();
			data.put("goods",goods[i]);
			data.put("price",Price[i]);
			shop.add(data);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this,shop,
				R.layout.goods_item,new String[]{"goods","price"},
				new int[]{R.id.textView1,R.id.textView2});
		lv.setAdapter(adapter);
		
        button.setOnClickListener(this);
        System.out.println("bb");
	}

	public void onClick(View arg0){
		
		

		intent.putExtra("result", m );
		setResult(RESULT_OK,intent);
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.goods, menu);
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
