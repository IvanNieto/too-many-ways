package com.example.rudolph.toomanyways;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by ivan on 23/04/2016.
 */
public class ActMenuAdv extends Activity {
    ListView listView;
    static String actualUri = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_menu_adv);

        // Creating list and populate the id.list on ly_menu_bgl
        // First find the listview
        listView = (ListView) findViewById(R.id.list);

        // Arrays to get section and url resource values from arrays.xml
        String[] sectionValues = getResources().getStringArray(R.array.arrayMenuAdv);
        final String[] urlValuesAdv = getResources().getStringArray(R.array.urlsAdv);


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

                // Assignment of Url values on each item position
                actualUri = urlValuesAdv[position];
                // Throws intent to display new intent on WebView layout
                Intent intentPr = new Intent(ActMenuAdv.this, ActWebView.class);
                intentPr.putExtra("Url", actualUri);
                startActivity(intentPr);
                finish();

                // Displays notification alert on device display
                Toast.makeText(getApplicationContext(),
                        "URL :" + actualUri + "\n" + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

}