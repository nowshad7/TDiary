package com.example.nowsh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    private List<TaskModel> AllTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=(RecyclerView)findViewById(R.id.rView);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        AllTasks= new ArrayList<>();

        final DatabaseHandler db = new DatabaseHandler(this );
        AllTasks=db.getAllTask();

        adapter=new MyAdepter(AllTasks,this);
        recyclerview.setAdapter(adapter);

        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_nev);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.add :
                        Intent i=new Intent(MainActivity.this,AddTaskActivity.class);
                        startActivity(i);
                        break;
                    case R.id.done :
                        Intent j=new Intent(MainActivity.this,DoneActivity.class);
                        startActivity(j);
                        break;
                    case R.id.edit :
                        Intent k=new Intent(MainActivity.this,EditTaskActivity.class);
                        startActivity(k);
                        break;
                }
                return true;
            }
        });

        }
    }

