package com.example.loop.content.content_details.slides

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.loop.R


class DetailsSlideShowCard(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.item_details_slide_show, this, true)
    }
}