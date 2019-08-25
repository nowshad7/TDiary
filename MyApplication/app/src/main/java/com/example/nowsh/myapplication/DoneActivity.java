package com.example.nowsh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DoneActivity extends AppCompatActivity {
    EditText Counter;
    TextView completed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        Counter = (EditText) findViewById(R.id.Counter_no);
        completed = (TextView) findViewById(R.id.completed);
        final DatabaseHandler db = new DatabaseHandler(this);


        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TaskIdValue = Counter.getText().toString();
                if (TaskIdValue.equals("")) {
                    Toast.makeText(getApplicationContext(), "Information Missing", Toast.LENGTH_SHORT).show();
                } else {
                    db.deleteTask(Integer.parseInt(TaskIdValue));
                    Toast.makeText(getApplicationContext(), TaskIdValue + " is Completed", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(DoneActivity.this,MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
