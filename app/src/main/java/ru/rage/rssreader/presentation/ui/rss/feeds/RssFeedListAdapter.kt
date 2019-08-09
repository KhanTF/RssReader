package ru.rage.rssreader.presentation.ui.rss.feeds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rss_feed.view.*
import ru.rage.rssreader.R
import ru.rage.rssreader.presentation.model.RssFeedModel

class RssFeedListAdapter : RecyclerView.Adapter<RssFeedListAdapter.RssFeedViewHolder>() {

    var listener : ((RssFeedModel)->Unit)?=null

    var list: List<RssFeedModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssFeedViewHolder {
        return RssFeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rss_feed, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RssFeedViewHolder, position: Int) {
        holder.bind()
    }


    inner class RssFeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() = itemView.apply {
            val model = list[adapterPosition]
            title.text = model.title
            setOnClickListener {
                listener?.invoke(model)
            }
        }
    }

}