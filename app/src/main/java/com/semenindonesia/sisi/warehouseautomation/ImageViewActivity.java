package com.semenindonesia.sisi.warehouseautomation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.semenindonesia.sisi.warehouseautomation.R.layout.activity_image_view;

public class ImageViewActivity extends AppCompatActivity {

    private Button btnA;
    private TextView tvA;
    private ImageView utamaa;
    private ImageView utamab;
    private ImageView utamac;
    private ImageView utamad;
    private ImageView utamae;
    private ImageView utamaf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_image_view);
        btnA = (Button) findViewById(R.id.btnA);
        tvA = (TextView) findViewById(R.id.tvA);
        utamaa = (ImageView) findViewById(R.id.utamaa);
        utamab = (ImageView) findViewById(R.id.utamab);
        utamac = (ImageView) findViewById(R.id.utamac);
        utamad = (ImageView) findViewById(R.id.utamad);
        utamae = (ImageView) findViewById(R.id.utamae);
        utamaf = (ImageView) findViewById(R.id.utamaf);


        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvA.getText().equals("A")) {
                    utamaa.setImageResource(R.drawable.keduaa);
                    utamae.setImageResource(R.drawable.keduae);

                }
            }
        });

        utamaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImageViewActivity.this, RincianRakActivity.class );
                startActivity(intent);



            }
        });

    }

}
