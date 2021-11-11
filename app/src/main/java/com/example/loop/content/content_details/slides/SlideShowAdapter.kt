package com.example.loop.content.content_details.slides

import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.loop.R

class SlideShowAdapter <T>(private val navController: NavController) :
    RecyclerView.Adapter<SlideShowAdapter.DetailsSlideShowViewHolder>() {
    private var sildes: MutableList<Slide> = mutableListOf()

    override fun onBindViewHolder(holder: DetailsSlideShowViewHolder, position: Int) {
        holder.setupView(sildes[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsSlideShowViewHolder {
        val item = DetailsSlideShowCard(parent.context, null)
        item.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return DetailsSlideShowViewHolder(item, navController)
    }

    override fun getItemCount(): Int {
        return sildes.count()
    }

    fun setContentList(slides: List<Slide>) {
        this.sildes.addAll(slides)
        notifyDataSetChanged()
    }

    class DetailsSlideShowViewHolder(
        itemView: DetailsSlideShowCard,
        private val navController: NavController
    ) : RecyclerView.ViewHolder(itemView) {

        fun setupView(slide: Slide) {
            itemView.setOnClickListener {
                navController.navigate(
                    ContentDetailsFragmentDirections.actionContentDetailsFragmentToZoomImageFragment(
                        slide.background!!
                    )
                )
            }
            Glide.with(itemView.context)
                .load("${slide.background}")
                .listener(GlideRequestListener())
                .placeholder(R.color.transparent)
                .into(itemView.slideShowImage)
        }
    }


}
