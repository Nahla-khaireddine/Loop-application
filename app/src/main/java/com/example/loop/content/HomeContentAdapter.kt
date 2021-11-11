package com.example.loop.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.loop.R


class HomeContentAdapter(
    private var contentList: ArrayList<Content>
) :
    RecyclerView.Adapter<HomeContentAdapter.ContentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_content_card, parent, false)
        return ContentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val currentItem = contentList[position]
        setUpItemView(holder, currentItem)
        loadImageToView(holder, currentItem)
    }

    private fun setUpItemView(
        holder: ContentViewHolder,
        currentItem: Content
    ) {
        holder.itemTopline.text = currentItem.topline
        holder.itemHeadlineline.text = currentItem.headline
        holder.itemView.setOnClickListener { view ->
            val bundle = bundleOf(CONTENT_KEY to currentItem)
            view.findNavController().navigate(R.id.action_homeFragment_to_contentDetailsFragment, bundle)
        }
    }

    private fun loadImageToView(
        holder: ContentViewHolder,
        currentItem: Content
    ) {
        Glide.with(holder.itemView.context)
            .load(currentItem.imageURL)
            .dontAnimate()
            .into(holder.itemBackgroundImage)
    }



    override fun getItemCount(): Int {
        return contentList.size
    }

    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTopline: TextView = itemView.findViewById(R.id.itemTopline)
        val itemHeadlineline: TextView = itemView.findViewById(R.id.itemHeadline)
        val itemBackgroundImage: ImageView = itemView.findViewById(R.id.itemBackgroundImage)


    }


}
