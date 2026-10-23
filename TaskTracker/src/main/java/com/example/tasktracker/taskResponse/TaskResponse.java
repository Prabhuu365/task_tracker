package com.example.tasktracker.taskResponse;

public class TaskResponse {
    private String title;
    private boolean iscompleted;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return iscompleted;
    }
}
