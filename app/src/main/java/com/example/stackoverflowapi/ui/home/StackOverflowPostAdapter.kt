package com.example.stackoverflowapi.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.stackoverflowapi.network.Items
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowapi.databinding.HolderStackoverflowPostBinding


class StackOverflowPostAdapter(val clickListener: Clicked): ListAdapter<Items,StackOverflowPostAdapter.PostViewHolder>(DiffCallback) {

    class PostViewHolder(private var binding: HolderStackoverflowPostBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(post: Items, clickListener: Clicked){
            binding.post = post
            binding.click = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Items>() {
        override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem.title == newItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(HolderStackoverflowPostBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val stackOverflow = getItem(position)
        holder.bind(getItem(position), clickListener)
        holder.bind(stackOverflow, clickListener)
    }
}

class Clicked(val clickListener: (postLink: String) -> Unit) {
    fun onLinkClick(post: Items) = clickListener(post.link)
}
