package com.example.nowsh.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditTaskActivity extends AppCompatActivity {
    EditText editTask,editDate,editTime ;
    TextView counter;
    ImageView save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        editTask = (EditText)findViewById(R.id.InputTask);
        editDate = (EditText)findViewById(R.id.InputDate);
        editTime = (EditText)findViewById(R.id.InputTime);
        counter=(TextView) findViewById(R.id.Counter_ID);
        save=(ImageView)findViewById(R.id.save);
        final DatabaseHandler db=new DatabaseHandler(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID=counter.getText().toString();
                String TaskName= editTask.getText().toString();
                String TaskDate= editDate.getText().toString();
                String TaskTime= editTime.getText().toString();

                if(TaskName.equals("") || TaskDate.equals("")|| TaskTime.equals("")|| ID.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.EditTask(new TaskModel(Integer.parseInt(ID),TaskName,TaskDate,TaskTime));
                    Toast.makeText (getApplicationContext(),"New Task Is Added.",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(EditTaskActivity.this,MainActivity.class);
                    startActivity(i);
                }
            }
        });


    }
}
