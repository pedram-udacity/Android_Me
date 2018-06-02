/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {


    public static final String INDEX_BUNDLE_KEY_HEAD = "head-index-bundle-key";
    public static final String INDEX_BUNDLE_KEY_BODY = "body-index-bundle-key";
    public static final String INDEX_BUNDLE_KEY_LEG = "leg-index-bundle-key";
    private int headIndex = 0;
    private int bodyIndex = bodyPartCounts;
    private int legIndex = bodyPartCounts * 2;

    final private static int bodyPartCounts = 12;

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIntent = new Intent(this, AndroidMeActivity.class);

        Button nextButton = (Button) findViewById(R.id.btn_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View aView) {
                startActivity(mIntent);
            }
        });

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {

        // TODO (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
        switch (position / bodyPartCounts) {
            case 0:
                headIndex = position;
                break;
            case 1:
                bodyIndex = position - bodyPartCounts;
                break;
            case 2:
                legIndex = position - (bodyPartCounts * 2);
                break;
        }

        // TODO (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity

        Bundle bundle = new Bundle();
        bundle.putInt(INDEX_BUNDLE_KEY_HEAD, headIndex);
        bundle.putInt(INDEX_BUNDLE_KEY_BODY, bodyIndex);
        bundle.putInt(INDEX_BUNDLE_KEY_LEG, legIndex);

        mIntent.putExtras(bundle);

        // TODO (4) Get a reference to the "Next" button and launch the intent when this button is clicked

    }

}
