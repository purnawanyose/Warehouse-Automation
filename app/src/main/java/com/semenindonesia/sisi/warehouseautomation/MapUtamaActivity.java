package com.semenindonesia.sisi.warehouseautomation;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.nineoldandroids.animation.ObjectAnimator;

public class MapUtamaActivity extends AppCompatActivity {
    TextView AUPC, AUPB, AUPA;
    public static String sbin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_utama);

        AUPC = (TextView) findViewById(R.id.AUPC);
        AUPB = (TextView) findViewById(R.id.AUPB);
        AUPA = (TextView) findViewById(R.id.AUPA);

        Bundle extras = getIntent().getExtras();
        sbin = extras.getString("sbin");
        String c = sbin.substring(1,3);
        Log.e("sdagjkl;f", "onCreate: "+c);

        for(char a : "ABCDEFGH".toCharArray()){
            Log.e("aabb","aabb"+a);
            if (c.equals(a+"1")){
                AUPC.setBackgroundColor(Color.BLUE);
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                AUPC.startAnimation(anim);

                AUPC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle extras = getIntent().getExtras();
                        sbin = extras.getString("sbin");

                        String c = sbin.substring(1,3);
                        Intent intent = new Intent(MapUtamaActivity.this, MappingAUPC.class );
                        intent.putExtra("sbin", c);
                        intent.putExtra("sbinFull", sbin);
                        startActivity(intent);
                    }
                });

            }
        }
        for(char aa : "IJKLMNOPQRSTUVWXYZ".toCharArray()){
            Log.e("aabb","aabb"+aa);
            if (c.equals(aa+"1")){
                AUPB.setBackgroundColor(Color.BLUE);
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                AUPB.startAnimation(anim);

                AUPB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle extras = getIntent().getExtras();
                        sbin = extras.getString("sbin");

                        String c = sbin.substring(1,3);
                        Intent intent = new Intent(MapUtamaActivity.this, MappingAUPB.class );
                        intent.putExtra("sbin", c);
                        intent.putExtra("sbinFull", sbin);
                        startActivity(intent);
                    }
                });

            }
        }
        for(char aaa : "ABCDEFG".toCharArray()){
            Log.e("aabb","aabb"+aaa);
            if (c.equals(aaa+"3")){
                AUPB.setBackgroundColor(Color.BLUE);
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                AUPB.startAnimation(anim);

                AUPB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle extras = getIntent().getExtras();
                        sbin = extras.getString("sbin");

                        String c = sbin.substring(1,3);
                        Intent intent = new Intent(MapUtamaActivity.this, MappingAUPB.class );
                        intent.putExtra("sbin", c);
                        intent.putExtra("sbinFull", sbin);
                        startActivity(intent);
                    }
                });

            }
        }
        for(char aaaa : "ABCDEFGHIJKLMNOPQRSTUVW".toCharArray()){
            Log.e("aabb","aabb"+aaaa);
            if (c.equals(aaaa+"2")){
                AUPA.setBackgroundColor(Color.BLUE);
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                AUPA.startAnimation(anim);

                AUPA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle extras = getIntent().getExtras();
                        sbin = extras.getString("sbin");

                        String c = sbin.substring(1,3);
                        Intent intent = new Intent(MapUtamaActivity.this, MappingAUPA.class );
                        intent.putExtra("sbin", c);
                        intent.putExtra("sbinFull", sbin);
                        startActivity(intent);
                    }
                });

            }
        }

    }
}
