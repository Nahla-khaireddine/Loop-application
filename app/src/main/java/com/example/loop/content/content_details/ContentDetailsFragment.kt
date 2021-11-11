package com.example.loop.content.content_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.ViewCompat
import androidx.core.view.updateMargins
import androidx.databinding.DataBindingUtil
import com.example.loop.R
import com.example.loop.content.CONTENT_KEY
import com.example.loop.content.Content
import com.example.loop.databinding.FragmentContentDetailsBinding
import com.example.loop.enableDarkToolbar

class ContentDetailsFragment : Fragment() {

    private lateinit var binding: FragmentContentDetailsBinding
    var viewModel = ContentDetailsViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_content_details, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enableDarkToolbar(binding.contentDetailsToolbar)
        viewModel.content.postValue(arguments?.getSerializable(CONTENT_KEY) as Content?)
        //addPaddingToToolbar()
        //setTranslucentStatusBarFlags()
    }

    private fun setTranslucentStatusBarFlags() {
        requireActivity().window.apply {
            setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }

    private fun addPaddingToToolbar() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.contentDetailsToolbar) { _, insets ->
            (binding.contentDetailsToolbar.layoutParams as ViewGroup.MarginLayoutParams).apply { this.updateMargins(top = insets.systemWindowInsetTop) }
            insets.consumeSystemWindowInsets()
        }
    }

    private fun removeTranslucentStatusBar() {
        requireActivity().window.apply { clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS) }
    }

    override fun onDestroyView() {
        removeTranslucentStatusBar()
        super.onDestroyView()
    }
}