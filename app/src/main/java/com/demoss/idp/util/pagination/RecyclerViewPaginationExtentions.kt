package com.demoss.idp.util.pagination

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setOnNextPageListener(focus: Int, onScrolled: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            recyclerView.let {
                if (focus == RecyclerView.FOCUS_DOWN && dy > 0 && !recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                    onScrolled()
                } // TODO add variant for FOCUS_UP
            }
        }
    })
}
