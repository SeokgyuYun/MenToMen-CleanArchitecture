package kr.hs.dgsw.b1nd.mentomen.view.comment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.b1nd.domain.model.Comment
import kr.hs.dgsw.b1nd.mentomen.R
import kr.hs.dgsw.b1nd.mentomen.databinding.ItemCommentBinding

class CommentAdapter(
    private val userId: Int,
    private val deleteItem: (Comment) -> Unit)
    : ListAdapter<Comment, CommentAdapter.CommentViewHolder>(CommentDiffUtilCallback) {

    inner class CommentViewHolder(private val binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Comment) {
            binding.apply {
                this.item = item
                if (item.userId == userId) btnMore.visibility = View.VISIBLE
                else btnMore.visibility = View.GONE
                btnMore.setOnClickListener { deleteItem(item) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_comment,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object CommentDiffUtilCallback : DiffUtil.ItemCallback<Comment>() {
        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean = oldItem == newItem
    }
}