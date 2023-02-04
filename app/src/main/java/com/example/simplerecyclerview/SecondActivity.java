package com.example.simplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    ImageView ivUserpic;
    TextView tvName;
    TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ivUserpic = findViewById(R.id.userpic);
        tvName = findViewById(R.id.name);
        tvPhone = findViewById(R.id.phone);
        Intent intent = getIntent();
        //User user = getIntent().getSerializableExtra("user");
        User user = getIntent().getParcelableExtra("user");
        switch (user.getSex()) {
            case MAN: this.ivUserpic.setImageResource(R.drawable.user_man); break;
            case WOMAN: this.ivUserpic.setImageResource(R.drawable.user_woman); break;
            case UNKNOWN: this.ivUserpic.setImageResource(R.drawable.user_unknown); break;
        }
        this.tvName.setText(user.getName());
        this.tvPhone.setText(user.getPhoneNumber());
    }
}