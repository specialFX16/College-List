package com.example.collegelist;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
	
	//Activity Global variables; Try to keep globals to minimum
	private List<ItemForSale>forSaleList = new ArrayList<ItemForSale>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        populateListOfItems();
        populateListView();
    }


    // populate the list of items with what in in the list 
    private void populateListOfItems(){
    	forSaleList.add(new ItemForSale("First Couch","This is the desc for the first one", R.drawable.test_couch1));
    	forSaleList.add(new ItemForSale("Second Couch","This is the desc for the second one", R.drawable.test_couch2));
    	forSaleList.add(new ItemForSale("Third Couch","This is the desc for the third one", R.drawable.test_couch3));
    	forSaleList.add(new ItemForSale("Fourth Couch","This is the desc for the fourth one", R.drawable.test_couch4));
    	
    }
    
    
    private void populateListView(){
    	ArrayAdapter<ItemForSale> adapter = new MyListAdapter();
    	ListView list = (ListView) findViewById(R.id.list_view_main);
    	list.setAdapter(adapter);
    }
    
    static class ViewHolderItem{
		TextView title;
		TextView description;
		ImageView mainImg;
	}
    
    private class MyListAdapter extends ArrayAdapter<ItemForSale>{
    	public MyListAdapter(){
    		super(MainActivity.this, R.layout.list_view_card, forSaleList);
    	}
    	
    	
    	@Override
    	public View getView(int position, View convertView, ViewGroup parent){
    		
    		ViewHolderItem holder;
    		ItemForSale currItem = forSaleList.get(position);
    		
    		if(convertView == null){
    			LayoutInflater inflater = ((Activity) MainActivity.this).getLayoutInflater();
    			convertView = inflater.inflate(R.layout.list_view_card, null);
    			
    			// Create ViewHolderItem and store references to the two children views
    			holder = new ViewHolderItem();
    			holder.title = (TextView) convertView.findViewById(R.id.title_of_post);
    			holder.description = (TextView) convertView.findViewById(R.id.desc_of_post);
    			holder.mainImg = (ImageView) convertView.findViewById(R.id.main_list_image);
    			
    			convertView.setTag(holder);
    		}
    		else{
    			// Get ViewHolderItem back to get fast access to the TextViews and Image View
    			holder = (ViewHolderItem) convertView.getTag();
    		}
    		
    		holder.title.setText(currItem.getTitle());
    		holder.description.setText(currItem.getDescription());
    		holder.mainImg.setImageResource(currItem.getPictureID());
    		
    		return convertView;
    	}
    }
    
    
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
