package com.example.rudolph.toomanyways;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by ivan on 23/04/2016.
 */
public class ActMainLanding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // loads on content act_main_landinging.xml
        setContentView(R.layout.ly_main_landing);

        ImageView button = (ImageView) findViewById(R.id.cover_btn); // set button

        // set button listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // loads next activity -> ActSettings.class
                Intent intentInit = new Intent(ActMainLanding.this, ActSettings.class);
                startActivity(intentInit);
            }
        });
    }
}
