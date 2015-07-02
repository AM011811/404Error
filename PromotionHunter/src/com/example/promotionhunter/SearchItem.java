package com.example.promotionhunter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class SearchItem extends Activity{
	private Spinner mySpinner;
	private Button 	buttonSearch;
	private Button goMenu;
	private ArrayAdapter<String> typeList;
	private String[] type = {"全部","衣服", "褲子", "鞋子"};
	
	private String	search_type="全部";
	private String 	search_keyword;
	private EditText keyword;
	LinearLayout ll;
	//測次用資料
	private String[][] tempArea = 
		{	{"衣服","Shirt01","1100"},
			{"衣服","Shirt02","1200"},
			{"衣服","Shirt03","1300"},
			{"衣服","Shirt04","1400"},
			{"衣服","Shirt05","1500"},
			{"衣服","Shirt06","1600"},
			{"褲子","Paint01","2100"},
			{"褲子","Paint02","2200"},
			{"褲子","Paint03","2300"},
			{"褲子","Paint04","2400"},
			{"褲子","Paint05","2300"},
			{"褲子","Paint06","2400"},
			{"鞋子","Shoe01","3100"},
			{"鞋子","Shoe02","3200"},
			{"鞋子","Shoe03","3300"},
			{"鞋子","Shoe04","3400"},
			{"鞋子","Shoe05","3500"},
			{"鞋子","Shoe06","3600"},
			};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_item_layout);
		mySpinner = (Spinner)findViewById(R.id.spinner_type);
		buttonSearch = (Button)findViewById(R.id.button_search);
		goMenu = (Button)findViewById(R.id.button_go_menu);
		keyword =(EditText)findViewById(R.id.editText_keyword);
		ll = (LinearLayout)findViewById(R.id.LinnerLayout4);

		typeList = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type);
		mySpinner.setAdapter(typeList);
		mySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				search_type = type[arg2];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}

			
		});
		
		buttonSearch.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Boolean boo = false;
				ll.removeAllViews();
				search_keyword = keyword.getText().toString();
				
				
				for(int i=0; i<tempArea.length; i++){
					//if(tempArea[i][1].indexOf(search_keyword)!=-1) {
					if((search_type.equals("全部") ||tempArea[i][0].equals(search_type)) && tempArea[i][1].indexOf(search_keyword)!=-1 ) {
						LinearLayout ly = new LinearLayout(SearchItem.this);
						ly.isHorizontalScrollBarEnabled();
						
						TextView tv1 = new TextView(SearchItem.this);
						TextView tv2 = new TextView(SearchItem.this);
						TextView tv3 = new TextView(SearchItem.this);
						tv1.setWidth( 350);
						tv1.setHeight( 70);
						tv2.setWidth( 350);
						tv2.setHeight( 70);
						tv3.setWidth( 350);
						tv3.setHeight( 70);
						tv1.setText(tempArea[i][0]);
						tv2.setText(tempArea[i][1]);
						tv3.setText("$"+tempArea[i][2]);
						ly.addView(tv1);
						ly.addView(tv2);
						ly.addView(tv3);
							
						ll.addView(ly);
						if(!boo) boo=true;
					}
				}
				if(!boo) {
					TextView tv1 = new TextView(SearchItem.this);
					tv1.setText("查無資料");
					ll.addView(tv1);
				}
				
				
			}//onClick End 

		});
		
		goMenu.setOnClickListener(new Button.OnClickListener( ){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SearchItem.this, MainActivity.class);
				startActivity(intent);
				SearchItem.this.finish();

			}});
	};
		
}



