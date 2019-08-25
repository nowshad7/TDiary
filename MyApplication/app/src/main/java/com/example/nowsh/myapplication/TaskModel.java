package com.example.nowsh.myapplication;

/**
 * Created by nowsh on 2/4/2018.
 */

public class TaskModel {
    int _id;
    String _Task;
    String _date;
    String _time;

    public TaskModel()
    {

    }


    public TaskModel(int _id, String _Task, String _date, String _time) {
        this._id = _id;
        this._Task = _Task;
        this._date = _date;
        this._time = _time;
    }


    public TaskModel(String _Task, String _date, String _time) {
        this._Task = _Task;
        this._date = _date;
        this._time = _time;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_Task() {
        return _Task;
    }

    public void set_Task(String _Task) {
        this._Task = _Task;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public String get_time() {
        return _time;
    }

    public void set_time(String _time) {
        this._time = _time;
    }
}