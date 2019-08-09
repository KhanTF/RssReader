package ru.rage.rssreader.presentation.base.common.decorator

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class DeletionSwipeItemTouchHelperCallback(private val callback: DeletionSwipeCallback) : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or  ItemTouchHelper.RIGHT){

    interface DeletionSwipeCallback{
        fun onDelete(position: Int)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        callback.onDelete(viewHolder.adapterPosition)
    }

}