/*
 * Copyright 2015 Anton Tananaev (anton.tananaev@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.c4d.oyster.mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.c4d.mobile.widgets.SlidingWidgets;


public class MapActivity extends AppCompatActivity {
    private String TAG = MapActivity.class.getSimpleName();
    private MapFragment mapFragment = null;
   // private ActionButtonFragment actionButtonFragment = null;
    private ScrollHandleFragment scrollHandleFragment = null;
    private SlidingWidgets slidingWidgets = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "inside main activity sms");
        setContentView(R.layout.activity_layout);
        Log.d(TAG, "after layout set");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.activity_layout, (mapFragment = new MapFragment()))
                    .commit();
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .add(R.id.activity_layout, (actionButtonFragment = new ActionButtonFragment()))
//                    .commit();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.activity_layout, (scrollHandleFragment = new ScrollHandleFragment()))
                    .commit();



        }

//        //R.layout.action_buttons.
//        RelativeLayout buttonsLayout = (RelativeLayout) findViewById(R.id.activity_layout);
//        System.out.print("buttons layout "+buttonsLayout);
//        EditText testView = new EditText(this);
//        testView.setText("ABCD".toCharArray(), 0, "ABCD".length());
//        buttonsLayout.addView(testView);

          //scrollHandleFragment.setClickListener();

        //ImageButton scrollButton = (ImageButton) scrollActionView.findViewById(R.id.scroll);


//        Button animateButton= (Button) findViewById(scrollHandleFragment.getView().R);



//        if(slidingWidgets == null)
//        slidingWidgets = new SlidingWidgets(buttons);



    }



//    private void scrollTheButtons(View v)
//    {
//        Toast.makeText(this.getBaseContext(),"Clicked", Toast.LENGTH_LONG).show();
//       // slidingWidgets.animate(v, (FrameLayout) findViewById(R.id.activity_layout));
//    }

}
