package com.example.nowsh.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nowsh on 2/4/2018.
 */

public class MyAdepter extends RecyclerView.Adapter<MyAdepter.ViewHolder> {
    private List<TaskModel> TaskItem;
    private Context context;
    DatabaseHandler db;





    public MyAdepter(List<TaskModel> taskItem, Context context) {
        TaskItem = taskItem;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TaskModel TaskModel=TaskItem.get(position);
        holder.TaskName.setText("Task : "+TaskModel.get_Task());
        holder.TaskDate.setText("Date : "+TaskModel.get_date());
        holder.TaskTime.setText("Time : "+TaskModel.get_time());
        holder.Id.setText( String.valueOf(TaskModel.get_id()));
        holder.Counter.setText("Counter");
    }

    @Override
    public int getItemCount() {
        return TaskItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView TaskName;
        public TextView TaskDate;
        public TextView TaskTime;
        public TextView Id;
        public TextView Counter;

        public ViewHolder(View itemView) {
            super(itemView);
            TaskName=(TextView)itemView.findViewById(R.id._task);
            TaskDate=(TextView)itemView.findViewById(R.id._date);
            TaskTime=(TextView)itemView.findViewById(R.id._time);
            Id=(TextView)itemView.findViewById(R.id._id);
            Counter=(TextView)itemView.findViewById(R.id._counter);
        }


        }
    }





