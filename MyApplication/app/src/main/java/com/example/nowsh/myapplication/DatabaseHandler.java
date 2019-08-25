package com.example.nowsh.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nowsh on 2/5/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="TaskTable.db";
    private static final String TABLE_NAME="TaskList";
    private static final String KEY_ID="id";
    private static final String KEY_TASK="task";
    private static final String KEY_DATE="date";
    private static final String KEY_TIME="time";

    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY ,TASK TEXT,DATE TEXT,TIME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addTask(TaskModel TaskModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(KEY_TASK, TaskModel.get_Task());
        value.put(KEY_DATE, TaskModel.get_date());
        value.put(KEY_TIME, TaskModel.get_time());

        db.insert(TABLE_NAME, null,value);

        db.close();

    }

    public TaskModel getSingleTask(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT ID,TASK,DATE,TIME FROM TASKS WHERE ID = "+id+" OR TASK ='A'";
        Cursor cursor=db.rawQuery(query, null);
        TaskModel MyTask= null;

        if(cursor.moveToFirst())
        {
            MyTask=new TaskModel(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3));
        }

        return MyTask;
    }

    public List<TaskModel> getAllTask()
    {
        List<TaskModel> mytaskList=new ArrayList<>();

        String selectquery="SELECT * FROM "+ TABLE_NAME;// where phoneno LIKE '017%'";

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                TaskModel task= new TaskModel(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                mytaskList.add(task);
            }while(cursor.moveToNext());
        }

        return mytaskList;
    }

    public void EditTask(TaskModel TaskModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(KEY_TASK, TaskModel.get_Task());
        value.put(KEY_DATE, TaskModel.get_date());
        value.put(KEY_TIME, TaskModel.get_time());

        db.update(TABLE_NAME,value, KEY_ID+"=?",new String[]{String.valueOf(TaskModel.get_id())});

        db.close();

    }

    public void deleteTask(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query = "DELETE From "+TABLE_NAME+" WHERE  ID="+id;
        db.execSQL(query);
        db.close();
    }

}
