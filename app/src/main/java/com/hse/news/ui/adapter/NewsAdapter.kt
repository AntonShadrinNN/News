package com.hse.news.ui.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hse.news.network.representation.NewsItem
import com.hse.news.R


class NewsAdapter : ListAdapter<NewsItem, NewsAdapter.NewsViewHolder>(NewsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)

        holder.bind(news)
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.description)
        val buttonOpenLink: Button = itemView.findViewById(R.id.readMore)

        fun bind(news: NewsItem) {
            titleTextView.text = news.title
            descriptionTextView.text = news.description
            buttonOpenLink.setOnClickListener {
                openLinkInBrowser(news.link)
            }
        }

        private fun openLinkInBrowser(link: String) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            itemView.context.startActivity(intent)
        }
    }

}
