package com.hse.news.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hse.news.network.representation.NewsItem

/**
 * Callback to optimize RecycleView updates
 */
class NewsDiffCallback : DiffUtil.ItemCallback<NewsItem>() {
    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem == newItem
    }
}