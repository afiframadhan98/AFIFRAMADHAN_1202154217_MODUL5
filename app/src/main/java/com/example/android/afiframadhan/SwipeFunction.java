package com.example.android.afiframadhan;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;


public class SwipeFunction extends ItemTouchHelper.SimpleCallback {
    RecyclerViewAdapter adapter;

    public SwipeFunction(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public SwipeFunction(RecyclerViewAdapter adapter){
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT);
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.dismissData(viewHolder.getAdapterPosition());       // Jika di Geser (Ke kiri), maka Data akan di hilangkan
    }
}
