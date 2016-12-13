package com.example.twoscrollview;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity implements ScrollView.OnScrollChangeListener{

    ScrollView scrollView1;
    ScrollView scrollView2;
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView1 = (ScrollView)findViewById(R.id.scroll_view_1);
        scrollView2 = (ScrollView)findViewById(R.id.scroll_view_2);
        scrollView1.setOnScrollChangeListener(this);
//        scrollView2.setOnScrollChangeListener(this);

        textView1 = (TextView)findViewById(R.id.text_view_1);
        textView2 = (TextView)findViewById(R.id.text_view_2);
    }

    @Override
    public void onScrollChange(View view, int i, int i1, int i2, int i3) {
        Log.e("XX_XX_XX", "i : " + i + " , " + "i1 : " + i1 + " , " + "i2 : " + i2 + " , " + "i3 : " + i3);
//        Log.e("XX_XX_XX", "textView1.getMeasuredHeight() : " + textView1.getHeight());
//        Log.e("XX_XX_XX", "textView2.getMeasuredHeight() : " + textView2.getHeight());
        float w1 = textView1.getHeight();
        float w2 = textView2.getHeight();
        float factor = w2/w1;
        Log.e("XX_XX_XX", "factor : " + factor);
        scrollView2.setScrollY((int)(factor * i3));
    }
}
