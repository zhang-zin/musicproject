package com.example.musicproject.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.example.musicproject.R

/**
 * 对主界面重要的自定义ImageView
 */
class ForegroundImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {
    private var mForeground: Drawable? = null

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.ForegroundImageView)
        val foreground =
            a.getDrawable(R.styleable.ForegroundImageView_android_foreground)
        foreground?.let { setForeground(it) }
        a.recycle()
    }

    fun setForegroundResource(drawableResId: Int) {
        foreground = context.resources.getDrawable(drawableResId)
    }


    override fun setForeground(drawable: Drawable) {
        if (mForeground === drawable) {
            return
        }
        if (mForeground != null) {
            mForeground!!.callback = null
            unscheduleDrawable(mForeground)
        }
        mForeground = drawable
        drawable.callback = this
        if (drawable.isStateful) {
            drawable.state = drawableState
        }
        requestLayout()
        invalidate()
    }

    override fun verifyDrawable(who: Drawable): Boolean {
        return super.verifyDrawable(who) || who === mForeground
    }

    override fun jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState()
        if (mForeground != null) {
            mForeground!!.jumpToCurrentState()
        }
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        if (mForeground != null && mForeground!!.isStateful) {
            mForeground!!.state = drawableState
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (mForeground != null) {
            mForeground!!.setBounds(0, 0, measuredWidth, measuredHeight)
            invalidate()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (mForeground != null) {
            mForeground!!.setBounds(0, 0, w, h)
            invalidate()
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        if (mForeground != null) {
            mForeground!!.draw(canvas)
        }
    }

}