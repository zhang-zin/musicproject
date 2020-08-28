package com.example.musicproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingAdapter<M, B : ViewDataBinding> constructor(val mContext: Context?) :
    RecyclerView.Adapter<BaseBindingAdapter.BaseBindingViewHolder>() {

    var mList: List<M> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder {
        val binding: B = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            getLayoutResId(viewType),
            parent,
            false
        )
        return BaseBindingViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder, position: Int) {
        val binding: B? = DataBindingUtil.getBinding(holder.itemView)
        onBindItem(binding, mList[position], holder)
        binding?.executePendingBindings()
    }

    abstract fun onBindItem(
        binding: B?,
        item: M?,
        holder: BaseBindingViewHolder
    )

    @LayoutRes
    protected abstract fun getLayoutResId(viewType: Int): Int

    class BaseBindingViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView)
}