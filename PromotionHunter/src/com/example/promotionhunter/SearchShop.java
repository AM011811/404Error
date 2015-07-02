package com.example.promotionhunter;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
 
public class SearchShop extends Activity{
	Button bt_gps;
	String shop[] = {"大潤發", "家樂福", "愛買", "COSTCO","比漾"};
    String goods[][] = {
    		{"T-shirt","襯衫","西裝褲","登山包","皮鞋"},
    		{"球鞋","名牌包","高跟鞋","電腦包","運動外套"},
    		{"無袖背心","平口褲","慢跑鞋","連身洋裝","帽T"},
    		{"T-shirt","西裝褲","高跟鞋","慢跑鞋","連身洋裝"},
    		{"無袖背心","名牌包","電腦包","平口褲","帽T"}
    };
    
    int Price[][] = {
    		{690,790,690,1390,850},
    		{1190,6250,590,620,590},
    		{250,199,990,650,790},
    		{590,790,690,890,750},
    		{270,6000,590,149,750}
    };
    int[] p;
    String[] name;
    int t;
    int m = 0;
    int[] n;
    private ListView listview;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
    String[] g;
    ArrayList<HashMap<String, String>> productList;
    @Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.search_shop_layout);
        bt_gps = (Button)findViewById(R.id.button_gps);
        listview = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        Button button =(Button)findViewById(R.id.b1);
        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.shop_name, shop);
        listview.setAdapter(adapter);
        n = new int[30];
        name = new String[30];
        /**
         * Enabling Search Filter
         * */
        inputSearch.addTextChangedListener(new TextWatcher() {
             
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                SearchShop.this.adapter.getFilter().filter(cs);   
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
            }
             
            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub                          
            }
        });
        
        listview.setOnItemClickListener(new OnItemClickListener(){
            public void  onItemClick(AdapterView<?> arg0,View arg1,int arg2,long  arg3){
            	TextView tv = (TextView) arg1.findViewById(R.id.shop_name);
                String str = tv.getText().toString().trim();
                
                for(int i=0;i<5;i++){
                	if(str.equals(shop[i])){
                		g = goods[i];
                		p = Price[i];
                		
                        Intent intent=new Intent();
                        intent.setClass(SearchShop.this,Goods.class);
                        intent.putExtra("goods", g);
                        intent.putExtra("Price", p);
                        intent.putExtra("number", Integer.toString(i) );
                        System.out.println("dd  "+i);
                        startActivityForResult(intent,1);
                        //startActivity(intent);
                	}
                }
            }
        });
        
        bt_gps.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(SearchShop.this, gps.class);      		
    			startActivity(intent);
    			SearchShop.this.finish();
        	}
        });
        
        button.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
        		Intent intent2 = new Intent();
        		intent2.setClass(SearchShop.this, Track.class);
        		

        		for(int a=0;a<m;a++){
        			name[a] = shop[n[a]];
        		}
    			intent2.putExtra("name", name);
    			//System.out.println("bb   "+shop[n[a]]);
    			startActivity(intent2);
        	}
        });    
    }      

    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
    	
    
    	
    	if(requestCode==1){
    		if(resultCode == RESULT_OK){
    			t = (Integer) data.getSerializableExtra("result");
    				n[m]=t;
    				m++;
    				System.out.println("aa   "+n[m-1]);
    		}
    	}
    	
    	super.onActivityResult(requestCode, resultCode, data);
    	
    }
    

}