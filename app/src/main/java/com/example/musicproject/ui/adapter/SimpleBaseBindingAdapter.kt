package com.example.musicproject.ui.adapter

import android.content.Context
import androidx.databinding.ViewDataBinding

abstract class SimpleBaseBindingAdapter<M, B : ViewDataBinding>(
    context: Context?,
    private val layout: Int
) : BaseBindingAdapter<M, B>(context) {
    override fun onBindItem(binding: B?, item: M?, holder: BaseBindingViewHolder) {
        onSimpleBindItem(binding, item, holder)
    }

    override fun getLayoutResId(viewType: Int): Int {
        return layout;
    }

    abstract fun onSimpleBindItem(
        binding: B?,
        item: M?,
        holder: BaseBindingViewHolder
    )

}