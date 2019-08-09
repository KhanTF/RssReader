package ru.rage.rssreader.presentation.ui.rss.subscriptions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rss_subscription.view.*
import ru.rage.rssreader.R
import ru.rage.rssreader.presentation.base.common.decorator.DeletionSwipeItemTouchHelperCallback
import ru.rage.rssreader.presentation.model.RssUrlModel

class RssSubscriptionListAdapter : RecyclerView.Adapter<RssSubscriptionListAdapter.RssViewHolder>(), DeletionSwipeItemTouchHelperCallback.DeletionSwipeCallback {

    interface RssListCallback{
        fun onRssUrl(rssUrlModel: RssUrlModel)
        fun onDelete(rssUrlModel: RssUrlModel)
    }

    var callback: RssListCallback?=null

    var list: List<RssUrlModel> = emptyList()
        set(value) {
            val callback = DiffUtilCallback(list,value)
            val result = DiffUtil.calculateDiff(callback)
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssViewHolder {
        return RssViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rss_subscription,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RssViewHolder, position: Int) {
        holder.bind()
    }

    override fun onDelete(position: Int) {
        val changedData = ArrayList(list)
        val model = changedData[position]
        changedData.remove(model)
        list = changedData
        callback?.onDelete(model)
    }

    inner class RssViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() = itemView.apply{
            val model = list[adapterPosition]
            title.setText(model.name)
            url.setText(model.url)
            setOnClickListener {
                callback?.onRssUrl(model)
            }
        }
    }

    private class DiffUtilCallback(private val old: List<RssUrlModel>, private val new: List<RssUrlModel>): DiffUtil.Callback(){
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return old[oldItemPosition].url == new[newItemPosition].url
        }

        override fun getOldListSize(): Int {
            return old.size
        }

        override fun getNewListSize(): Int {
            return new.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return old[oldItemPosition].name == new[newItemPosition].name
        }

    }

}