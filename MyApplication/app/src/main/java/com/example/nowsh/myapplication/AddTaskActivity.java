package com.example.nowsh.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity {
    EditText editTask,editDate,editTime ,editTextId;
    ImageView mDate;
    ImageView AddTaskImg;
    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        mDate =(ImageView)findViewById(R.id.calendar);
        editTask = (EditText)findViewById(R.id.InputTask);
        editDate = (EditText)findViewById(R.id.InputDate);
        editTime = (EditText)findViewById(R.id.InputTime);

        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c= Calendar.getInstance();
                int Day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);
                dpd=new DatePickerDialog(AddTaskActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {
                        editDate.setText(mDay+"/"+(mMonth+1)+"/"+mYear);
                    }
                },Day,month,year);
                dpd.show();
            }
        });

        AddTaskImg =(ImageView)findViewById(R.id.img_add_task);
        final DatabaseHandler db=new DatabaseHandler(this);
        AddTaskImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TaskName= editTask.getText().toString();
                String TaskDate= editDate.getText().toString();
                String TaskTime= editTime.getText().toString();

                if(TaskName.equals("") || TaskDate.equals("")|| TaskTime.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addTask(new TaskModel(TaskName,TaskDate,TaskTime));
                    Toast.makeText (getApplicationContext(),"New Task Is Added.",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(AddTaskActivity.this,MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}
