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
        String c = sbin.substring(0,2);
        Log.e("sdagjkl;f", "onCreate: "+c);


        String s1 = "ABCDEFG";
        String s2 = "HIJKLMNOPQRSTUVWXYZ";
        String s3 = "ABCDEFGHIJKLMNOPQRSTUVW";


        for (int i = 0; i < s1.length(); i++) {
            Log.e("hjhjhjhjhh", "onCreate: "+s2.charAt(i));
            if (c.equals(s1.charAt(i)+"1")){
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

                        String c = sbin.substring(0,2);
                        Intent intent = new Intent(MapUtamaActivity.this, MappingAUPC.class );
                        intent.putExtra("sbin", c);
                        startActivity(intent);
                    }
                });

            }else if(c.equals(s2.charAt(i)+"1")){
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
//                        Bundle extras = getIntent().getExtras();
//                        sbin = extras.getString("sbin");
//                        String c = sbin.substring(0,2);
                        Intent intent = new Intent(MapUtamaActivity.this, MappingAUPB.class );
//                        intent.putExtra("sbin", c);
                        startActivity(intent);
                    }
                });

            }else if(c.equals(s1.charAt(i)+"3")){
                AUPB.setBackgroundColor(Color.BLUE);
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                AUPB.startAnimation(anim);

           /*     AUPB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MapUtamaActivity.this, MappingUtamaActivity.class );
                        startActivity(intent);
                    }
                });*/

            }else if(c.equals(s3.charAt(i)+"2")){
                AUPA.setBackgroundColor(Color.BLUE);
                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50); //You can manage the blinking time with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);
                AUPA.startAnimation(anim);

              /*  AUPA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MapUtamaActivity.this, MappingUtamaActivity.class );
                        startActivity(intent);
                    }
                });*/

            }else{

            }
        }

    }
}
