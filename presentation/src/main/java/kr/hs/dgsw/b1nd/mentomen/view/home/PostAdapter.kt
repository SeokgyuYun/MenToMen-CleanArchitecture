package kr.hs.dgsw.b1nd.mentomen.view.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.mentomen.R
import kr.hs.dgsw.b1nd.mentomen.databinding.ItemHomeBinding

class PostAdapter(private val itemClick: (Post) -> Unit) : ListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffUtilCallback) {

    inner class PostViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            when (item.tag) {
                "ANDROID" -> binding.ivTag.setImageResource(R.drawable.ic_android)
                "IOS" -> binding.ivTag.setImageResource(R.drawable.ic_ios)
                "WEB" -> binding.ivTag.setImageResource(R.drawable.ic_web)
                "SERVER" -> binding.ivTag.setImageResource(R.drawable.ic_server)
                "DESIGN" -> binding.ivTag.setImageResource(R.drawable.ic_design)
            }

            binding.apply {
                this.item = item
                root.setOnClickListener { itemClick(item) }
                if (item.imgUrls.isNullOrEmpty()) cardView.visibility = View.GONE
                else {
                    cardView.visibility = View.VISIBLE
                    Glide.with(ivContent.context)
                        .load(item.imgUrls[0])
                        .into(binding.ivContent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_home,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object PostDiffUtilCallback : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean = oldItem == newItem
    }
}