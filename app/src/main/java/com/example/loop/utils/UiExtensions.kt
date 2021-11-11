package com.example.loop

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.enableDarkToolbar(toolbar: Toolbar) {
    toolbar.setNavigationIcon(R.drawable.ic_toolbar_back_white)
    toolbar.setNavigationOnClickListener {
        findNavController().navigateUp()
    }
}
