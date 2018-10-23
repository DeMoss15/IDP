package com.demoss.idp.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    abstract val data: MutableList<T>

    override fun getItemCount(): Int = data.size

    private inline fun <reified DiffCallback: MyDiffCallback<T>>dispatchData(list: List<T>) {
        val result = DiffUtil.calculateDiff(DiffCallback(data, list))
        data.clear()
        data.addAll(list)
        result.dispatchUpdatesTo(this)
    }

    fun addData(list: List<T>) {
        dispatchData(data.toMutableList() + list.toMutableList())
    }

    abstract class MyDiffCallback<T>(oldList: List<T>, newList: List<T>): DiffUtil.Callback()
}