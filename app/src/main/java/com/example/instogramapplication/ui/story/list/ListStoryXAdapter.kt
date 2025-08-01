package com.example.instogramapplication.ui.story.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.instogramapplication.R
import com.example.instogramapplication.data.remote.model.ListStoryItem
import com.example.instogramapplication.databinding.ItemListStoryXBinding
import com.example.instogramapplication.databinding.ItemPostStoryBinding

class ListStoryXAdapter(
    private val context: Context,
    private val onItemClick: (ImageView, TextView, ListStoryItem) -> Unit,
    private val onAddStory: () -> Unit,
) : ListAdapter<ListStoryItem, ViewHolder>(DIFF_CALLBACK) {
    private var currentUserName = ""

    inner class ItemStoryViewHolder(private val item: ItemListStoryXBinding) :
        ViewHolder(item.root) {
        fun bind(listStory: ListStoryItem) {
            Glide.with(context)
                .load(listStory.photoUrl)
                .override(100)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.profile_placeholder)
                .circleCrop()
                .into(item.itemStoryX)
            item.storyUsername.text = listStory.name

            item.itemStoryX.setOnClickListener {
                onItemClick(
                    item.itemStoryX,
                    item.storyUsername,
                    listStory
                )
            }
        }
    }

    inner class ItemAddViewHolder(private val item: ItemPostStoryBinding) : ViewHolder(item.root) {
        fun bind(listStory: ListStoryItem?) {
            if (listStory != null) {
                Glide.with(context)
                    .load(listStory.photoUrl)
                    .override(100)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .circleCrop()
                    .placeholder(R.drawable.profile_placeholder)
                    .into(item.itemStoryX)

                item.itemStoryX.setOnClickListener {
                    onItemClick(
                        item.itemStoryX,
                        item.storyUsername,
                        listStory
                    )
                }
            } else {
                item.itemStoryX.setOnClickListener {
                    onAddStory()
                }
            }

            item.addStory.setOnClickListener {
                onAddStory()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_ADD_STORY -> {
                val binding =
                    ItemPostStoryBinding.inflate(
                        inflater,
                        parent,
                        false
                    )
                ItemAddViewHolder(binding)
            }

            TYPE_STORY -> {
                val binding =
                    ItemListStoryXBinding.inflate(
                        inflater,
                        parent,
                        false
                    )
                ItemStoryViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_ADD_STORY else TYPE_STORY
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val story = getItem(position)
        when (getItemViewType(position)) {
            TYPE_ADD_STORY -> {
                val myStories = currentList.filter { it.name == currentUserName }
                    .maxByOrNull { it.createdAt ?: "" }
                (holder as ItemAddViewHolder).bind(myStories)
            }

            TYPE_STORY -> {
                (holder as ItemStoryViewHolder).bind(story)
            }
        }
    }

    fun updateUserName(userName: String?) {
        if (!userName.isNullOrBlank()) {
            currentUserName = userName
            notifyItemChanged(0)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListStoryItem>() {
            override fun areItemsTheSame(oldItem: ListStoryItem, newItem: ListStoryItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ListStoryItem,
                newItem: ListStoryItem
            ): Boolean {
                return oldItem == newItem
            }

        }

        private const val TYPE_STORY = 1
        private const val TYPE_ADD_STORY = 0
    }
}