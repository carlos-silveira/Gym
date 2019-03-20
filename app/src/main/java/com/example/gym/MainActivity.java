package com.example.gym;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout layoutanim;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutanim= findViewById(R.id.layoutanim);
        Animation myAnim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        layoutanim.startAnimation(myAnim);
        t1=findViewById(R.id.txtTitle);
        t1.setText("EFFORT GYM".toUpperCase());
        TextPaint paint = t1.getPaint();
        float width = paint.measureText("EFFORT GYM");
        Shader textShader = new LinearGradient(0,0,width,t1.getTextSize(),
                new int[]{
                        Color.parseColor("#F97C3C"),
                        Color.parseColor("#FDB54E"),
                        Color.parseColor("#64B678"),
                        Color.parseColor("#478AEA"),
                        Color.parseColor("#8446CC"),
                },null,Shader.TileMode.CLAMP);
        t1.getPaint().setShader(textShader);
        startActivity(new Intent(MainActivity.this,content_menu.class));
    }
}
