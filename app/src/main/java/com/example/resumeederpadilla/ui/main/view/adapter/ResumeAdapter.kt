package com.example.resumeederpadilla.ui.main.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.resumeederpadilla.R
import com.example.resumeederpadilla.model.ExperienceItem

class ResumeAdapter : ListAdapter<ExperienceItem, ResumeAdapter.ExperienceViewHolder>(DIFF_CALLBACK) {

    private lateinit var mContext : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        mContext = parent.context
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.eperience_item, parent, false)
        return ExperienceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val experience = getItem(position)
        holder.mTvDescription.text = String.format(mContext.getString(R.string.experience_des), experience.description)
        holder.mTvBetween.text = String.format(mContext.getString(R.string.experience_between), experience.between)
        holder.mTvTitle.text = experience.place
    }

    inner class ExperienceViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val mTvTitle: TextView = itemView.findViewById(R.id.mTvPlace)
        val mTvBetween : TextView = itemView.findViewById(R.id.mTvBetween)
        val mTvDescription : TextView = itemView.findViewById(R.id.mTvDescription)

    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<  ExperienceItem>() {

            override fun areItemsTheSame(oldItem:   ExperienceItem, newItem:   ExperienceItem) =
                oldItem.description == newItem.description

            override fun areContentsTheSame(oldItem:   ExperienceItem, newItem:   ExperienceItem) =
                oldItem== newItem

        }

    }

}