package com.example.loop.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.loop.ContentService
import com.example.loop.R
import com.example.loop.databinding.FragmentHomeBinding

val CONTENT_KEY = "content-key"
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var contentService: ContentService = ContentService()
    private lateinit var newRecyclerView: RecyclerView
    private  var newArrayList: ArrayList<Content> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeToolbar.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_contentDetailsFragment)
        }
        newRecyclerView = binding.homeRecyclerView
        contentService.fetchContent(requireContext()).forEach{
            newArrayList.add(it)
        }
        newRecyclerView.adapter = HomeContentAdapter(newArrayList)

    }



}