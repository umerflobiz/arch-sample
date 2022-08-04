package com.flobiz.android.coreui.widget

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.flobiz.android.coreui.R
import com.google.android.material.button.MaterialButton

/**
 * A [MaterialButton] subclass with loading state. Customize it at the theme level
 * with [R.attr.loadingButtonStyle] attribute.
 */
class LoadingButton(context: Context, attrs: AttributeSet) : MaterialButton(context, attrs) {

    /**
     * Setting this flag to `true` will show the loading animation, `false` will hide the animation
     * and displays the text.
     */
    var isLoading: Boolean = false
        set(value) {
            updateUiState(isLoading = value)
            isClickable = !value
            field = value
        }

    private var btnText: CharSequence? = text
    private val loaderColor: Int

    init {
        val ta = context.obtainStyledAttributes(
            attrs,
            R.styleable.LoadingButton,
            R.attr.loadingButtonStyle,
            R.style.Widget_ArchSample_LoadingButton
        )
        loaderColor = ta.getColor(R.styleable.LoadingButton_loaderColor, Color.WHITE)
        ta.recycle()
    }

    private val progressDrawable: CircularProgressDrawable by lazy {
        CircularProgressDrawable(context).apply {
            setColorSchemeColors(loaderColor)
            setStyle(CircularProgressDrawable.LARGE)
            strokeCap = Paint.Cap.ROUND
        }
    }

    private val animator: ValueAnimator by lazy {
        ValueAnimator.ofInt(0, 100).apply {
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                invalidate()
            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        progressDrawable.setBounds(0, paddingTop, width, height - paddingBottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (isLoading) canvas?.let { progressDrawable.draw(it) }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        progressDrawable.stop()
        animator.cancel()
    }

    private fun updateUiState(isLoading: Boolean) {
        if (isLoading) {
            text = null
            animator.start()
            progressDrawable.start()
        } else {
            progressDrawable.stop()
            animator.cancel()
            text = btnText
        }
    }

    /**
     * Sets the text respecting the current loading state, i.e. if button is currently loading,
     * the new text will be displayed after loading is finished.
     */
    fun setButtonText(text: CharSequence?) {
        btnText = text
        if (isLoading.not()) this.text = text
    }
}
