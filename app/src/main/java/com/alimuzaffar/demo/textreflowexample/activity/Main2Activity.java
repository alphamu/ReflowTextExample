package com.alimuzaffar.demo.textreflowexample.activity;

import android.app.SharedElementCallback;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alimuzaffar.demo.textreflowexample.R;

import java.util.List;

import io.plaidapp.ui.transitions.ReflowText;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        // We can define transitions here.
        // However they are already defined in xml (in styles, as the theme for the activity)
        // this is just an example of how to do them in code.
        // Do this first thing, before calling setContentView.
        */
        /*
        Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.reflow_enter);
        Transition exitTransition = TransitionInflater.from(this).inflateTransition(R.transition.reflow_exit);
        getWindow().setSharedElementEnterTransition(enterTransition);
        getWindow().setSharedElementExitTransition(exitTransition);
        */
        setContentView(R.layout.activity_main2);
        final TextView textView = (TextView) findViewById(R.id.txt_main);
        textView.setTransitionName("hello_world"); //can set this in the xml layout as well.

        setEnterSharedElementCallback(new SharedElementCallback() {
            @Override
            public void onSharedElementStart(List<String> sharedElementNames, List<View>
                    sharedElements, List<View> sharedElementSnapshots) {
                ReflowText.setupReflow(getIntent(), textView);
            }

            @Override
            public void onSharedElementEnd(List<String> sharedElementNames, List<View>
                    sharedElements, List<View> sharedElementSnapshots) {
                ReflowText.setupReflow(new ReflowText.ReflowableTextView(textView));
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
