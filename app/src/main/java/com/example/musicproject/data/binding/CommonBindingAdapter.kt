package com.example.musicproject.data.binding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.musicproject.R
import com.zj.architecture.utils.ClickUtils

@BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = false)
fun loadUrl(view: ImageView?, url: String?, placeHolder: Drawable) {
    view?.let {
        Glide.with(view.context).load(url).placeholder(placeHolder).into(view)
    }
}

@BindingAdapter(value = ["visible"], requireAll = false)
fun visible(view: View?, visible: Boolean) {
    view?.let {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }
}

@BindingAdapter(value = ["showDrawable", "drawableShowed"], requireAll = false)
fun showDrawable(
    view: ImageView,
    showDrawable: Boolean,
    drawableShowed: Int
) {
    view.setImageResource(if (showDrawable) drawableShowed else R.color.transparent)
}

@BindingAdapter(value = ["textColor"], requireAll = false)
fun setTextColor(textView: TextView, textColorRes: Int) {
    textView.setTextColor(textView.resources.getColor(textColorRes))
}

@BindingAdapter(value = ["imageRes"], requireAll = false)
fun setImageRes(imageView: ImageView, imageRes: Int) {
    imageView.setImageResource(imageRes)
}

@BindingAdapter(value = ["selected"], requireAll = false)
fun selected(view: View, select: Boolean) {
    view.isSelected = select
}

@BindingAdapter(value = ["onClickWithDebouncing"], requireAll = false)
fun onClickWithDebouncing(view: View?, clickListener: View.OnClickListener?) {
    ClickUtils.applySingleDebouncing(view, clickListener)
}

