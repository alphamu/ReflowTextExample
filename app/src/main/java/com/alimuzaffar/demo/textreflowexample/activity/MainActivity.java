package com.alimuzaffar.demo.textreflowexample.activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alimuzaffar.demo.textreflowexample.R;

import io.plaidapp.ui.transitions.ReflowText;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.txt_main);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        ReflowText.addExtras(intent, new ReflowText.ReflowableTextView((TextView) view));
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, view, "hello_world");
        startActivity(intent, options.toBundle());
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
