package com.example.krishnakartheek.myapptest;

public class ListModel {

    String data;
    boolean isChecked;

    public ListModel(String data) {
        this.data = data;
        this.isChecked=isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
