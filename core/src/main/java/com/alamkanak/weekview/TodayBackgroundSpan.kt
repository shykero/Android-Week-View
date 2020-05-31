package com.alamkanak.weekview

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.Align
import android.graphics.Paint.FontMetricsInt
import android.text.style.ReplacementSpan
import kotlin.math.roundToInt
import kotlin.math.sqrt


class TodayBackgroundSpan : ReplacementSpan() {
    private var textColor = 0

    override fun draw(canvas: Canvas, text: CharSequence, start: Int, end: Int, x: Float, top: Int, y: Int, bottom: Int, paint: Paint) {
        val paintText = Paint()
        paintText.isAntiAlias = true
        paintText.textSize = 36f
        paintText.textAlign = Align.CENTER
        paintText.color = textColor
        val spSize = 12
        var relation = sqrt((canvas.width * canvas.height).toDouble())
        relation /= 250
        paintText.textSize = (spSize * relation).toFloat()

        canvas.drawText(text, start, end, x, y.toFloat()+50, paintText)
    }

    override fun getSize(paint: Paint, text: CharSequence?, start: Int, end: Int, fm: FontMetricsInt?): Int {
        return paint.measureText(text, start, end).roundToInt()
    }

    init {
        textColor = Color.rgb(245, 128, 104)
    }
}