package com.demoss.idp.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T,
        VH : BaseRecyclerViewAdapter.BaseViewHolder<T>,
        DiffUtilCallback : BaseRecyclerViewAdapter.BaseDiffUtilCallback<T>> : RecyclerView.Adapter<VH>() {

    abstract val viewHolderFactory: (view: View) -> VH
    abstract val layoutResId: Int
    abstract val data: MutableList<T>
    abstract val diffUtilCallbackClazz: Class<DiffUtilCallback>?

    // RV Adapter functions ============================================================================================
    final override fun getItemCount(): Int = data.size

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = viewHolderFactory(
        LayoutInflater.from(parent.context)
            .inflate(layoutResId, parent, false)
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindData(data[position])
    }

    // Basic DiffUtil usage functions ==================================================================================
    open fun addData(list: List<T>) {
        dispatchData(data.toMutableList() + list.toMutableList())
    }

    open fun refresh(list: List<T>) {
        data.clear()
        notifyDataSetChanged()
        dispatchData(list.toMutableList())
    }

    // DiffUtil applying ===============================================================================================
    private fun dispatchData(list: List<T>) {
        diffUtilCallbackClazz?.let {
            // if clazz is not null
            with(it.newInstance()) {
                // callback instance
                newList = list
                oldList = data
                with(DiffUtil.calculateDiff(this)) {
                    // diff result
                    data.clear()
                    data.addAll(list)
                    dispatchUpdatesTo(this@BaseRecyclerViewAdapter)
                }
            }
        }
    }

    // Abstract classes ================================================================================================
    abstract class BaseDiffUtilCallback<T>(var oldList: List<T>, var newList: List<T>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size
    }

    abstract class BaseViewHolder<T>(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bindData(item: T)
    }
}