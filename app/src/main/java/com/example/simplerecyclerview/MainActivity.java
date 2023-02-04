package com.example.simplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    RecyclerView rv;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // Чтение из файла
        InputStream stream = getResources().openRawResource(R.raw.users);
        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        users = gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());

        CustomRecycleAdapter adapter = new CustomRecycleAdapter(this, users, this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(User item) {
        Intent intent = new Intent(this, SecondActivity.class);
        //intent.putExtra("user", (Serializable) item);
        intent.putExtra("user", (Parcelable) item);
        startActivity(intent);
    }
}