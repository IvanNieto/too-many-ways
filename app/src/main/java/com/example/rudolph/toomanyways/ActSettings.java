package com.example.rudolph.toomanyways;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ivan on 23/04/2016.
 */

public class ActSettings extends ActMainLanding {

    // Global variables
    static int usrxptmp; // used to store temp var
    String usxp = "0"; // string displayed on view

    /**
     * onCreate method
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_settings);

        /**
         * VideoView holding intro video to become a great dev
         * (could be a good place to hold some paid ad by a company as Udacity or similar)
         */
//        VideoView vid = (VideoView) findViewById(R.id.vidView);
//
//        Uri uri = Uri.parse("https://www.youtube.com/watch?v=ESVtkjrE9V0");
//        vid.setVideoURI(uri);

        // Display starting xp years at 0
        showYears(usxp);

        /**
         * Button next
         * This throws a new intent to load next activity -> Menu
         * If usrxptmp is less or equals than 2 years -> MenuBeg
         * If usrxptmp is more than 2 years -> ActMenuAdv
         * In case of error throws again the ActSettings view
         */
        Button button = (Button) findViewById(R.id.btn_settings_next);

        // Starts a listener for clicks on the button object
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usrxptmp = Integer.parseInt(usxp);

                if (usrxptmp <= 2 && usrxptmp>=0) {
                    // loads MenuBeg intent -> ActMenuBeg.class
                    Intent intentMenuBeg = new Intent(ActSettings.this, ActMenuBeg.class);
                    startActivity(intentMenuBeg);
                    finish();
                } else if (usrxptmp > 2 && usrxptmp<=100) {
                    // loads ActMenuAdv intent -> MenuAdvanced.class
                    Intent intentMenuAdv = new Intent(ActSettings.this, ActMenuAdv.class);
                    startActivity(intentMenuAdv);
                    finish();
                } else {
                    // Displays notification alert to set correct xp range on device display
                    Toast.makeText(getApplicationContext(),
                            "Please set years between 0 and 100", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    /**
     * more method
     * Increments user experience in years on button click
     */
    public void less(View view) {
        TextView usrXP = (TextView) findViewById(R.id.usr_xp);
        usrxptmp = Integer.parseInt(usxp);
        usrxptmp = usrxptmp - 1;
        usxp = Integer.toString(usrxptmp);
        showYears(usxp);
    }

    /**
     * less method
     * Decrements user experience in years on button click
     * @param view
     */
    public void more(View view) {
        TextView usrXP = (TextView) findViewById(R.id.usr_xp);
        usrxptmp = Integer.parseInt(usxp);
        usrxptmp = usrxptmp + 1;
        usxp = Integer.toString(usrxptmp);
        showYears(usxp);
    }

    /**
     * showYears method
     * Show user experience in years on screen
     * @param years [String] of user xp as developer
     */
    public void showYears(String years) {
        TextView usrXP = (TextView) findViewById(R.id.usr_xp);
        usrXP.setText(years);
    }


}





