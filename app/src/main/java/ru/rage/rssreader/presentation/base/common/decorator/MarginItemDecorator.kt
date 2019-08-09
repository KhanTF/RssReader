package ru.rage.rssreader.presentation.base.common.decorator

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class MarginItemDecorator(
    private val top: Int = 0,
    private val bottom: Int = 0,
    private val start: Int = 0,
    private val end: Int = 0,
    private val space: Int = 0
) : RecyclerView.ItemDecoration() {

    constructor(margin: Int) : this(margin, margin, margin, margin, margin)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val adapter = parent.adapter
        when (val count = adapter?.itemCount ?: 0) {
            0 -> super.getItemOffsets(outRect, view, parent, state)
            1 -> outRect.set(start, top, end, bottom)
            else -> when (position) {
                0 -> outRect.set(start, top, end, space)
                count - 1 -> outRect.set(start, 0, end, bottom)
                else -> outRect.set(start, 0, end, space)
            }
        }
    }

}
