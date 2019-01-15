package com.how2java.pojo;

public class Page {
    private int start = 0;
    private int count = 5;
    private int last = 0;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

//    传统分页使用
    public void calculateLast(int total){
        if(total%count == 0){
            last = total - count;
        } else {
            last = total - total%count;
        }
    }

}
