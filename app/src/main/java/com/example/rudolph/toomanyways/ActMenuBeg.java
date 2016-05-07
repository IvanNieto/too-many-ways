package com.example.rudolph.toomanyways;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by ivan on 23/04/2016.
 */
public class ActMenuBeg extends Activity {
    ListView listView;
    int itemMenu = 0;
    static String actualUri = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_menu_bg);

        // Creating list and populate the id.list on ly_menu_bg.xml      // First find the listview
        listView = (ListView) findViewById(R.id.list);

        String[] sectionValues = getResources().getStringArray(R.array.arrayMenuBeg);
        final String[] urlValues = getResources().getStringArray(R.array.urlsBeg);


        // Explanation:
        // Adapters are used to provide the data to the ListView
        //
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, sectionValues);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                actualUri = urlValues[position];
                Intent intentPr = new Intent(ActMenuBeg.this, ActWebView.class);
                intentPr.putExtra("Url", actualUri);
                startActivity(intentPr);
                finish();
            }

        });
    }

}