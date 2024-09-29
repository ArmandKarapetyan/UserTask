package com.task.example.ui.fragments.users

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.task.domain.model.UiUsers
import com.task.example.R
import com.task.example.databinding.ItemDataBinding

class UserAdapter(private val item: (String) -> Unit) :
    ListAdapter<UiUsers, UserAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        return ItemViewHolder(
            ItemDataBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }

    inner class ItemViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UiUsers, context:Context) {
            with(binding) {
                userID.text = context.getString(R.string.user_id,  item.id)
                Glide.with(context)
                    .load(item.avatarUrl)
                    .circleCrop()
                    .into(avatar)
                root.setOnClickListener {
                    item(item.userName)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<UiUsers>() {
        override fun areItemsTheSame(oldItem: UiUsers, newItem: UiUsers): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UiUsers, newItem: UiUsers): Boolean {
            return oldItem == newItem
        }
    }
}
