package com.kosan.mybook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DescBookActivity extends AppCompatActivity {

    ImageView img;
    TextView nameText, pengarangText,descText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_book);

        Intent intent = getIntent();

        final String name = intent.getExtras().getString("name");
        final String peng = intent.getExtras().getString("pengarang");
        final String photo = intent.getExtras().getString("photo");
        final String desc = intent.getExtras().getString("desc");

        img= findViewById(R.id.img_photo);
        nameText= findViewById(R.id.tv_item_name);
        pengarangText = findViewById(R.id.tv_item_pengarang);
        descText=findViewById(R.id.tv_desc);

        Glide.with(this).load(photo).into(img);
        nameText.setText(name);
        pengarangText.setText(peng);
        descText.setText(desc);

        if(getSupportActionBar() !=null){
            getSupportActionBar().setTitle("Detail Novel");
        }


    }
}
