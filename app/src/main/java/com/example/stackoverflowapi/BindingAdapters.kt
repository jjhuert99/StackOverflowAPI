package com.example.stackoverflowapi

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowapi.network.Items
import com.example.stackoverflowapi.ui.home.StackOverflowPostAdapter

@BindingAdapter("postHolder")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Items>?){
    val adapter = recyclerView.adapter as StackOverflowPostAdapter
    adapter.submitList(data)
}
