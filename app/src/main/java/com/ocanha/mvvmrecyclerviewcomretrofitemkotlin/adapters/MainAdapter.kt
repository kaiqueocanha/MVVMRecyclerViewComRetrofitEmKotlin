package com.ocanha.mvvmrecyclerviewcomretrofitemkotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ocanha.mvvmrecyclerviewcomretrofitemkotlin.R
import com.ocanha.mvvmrecyclerviewcomretrofitemkotlin.databinding.ResItemLiveBinding
import com.ocanha.mvvmrecyclerviewcomretrofitemkotlin.models.Live

class MainAdapter(private val onItemClicked: (Live) -> Unit) : RecyclerView.Adapter<MainViewHolder>() {

    private var lives = mutableListOf<Live>()

    fun setMovieList(movies: List<Live>) {

        this.lives = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResItemLiveBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val live = lives[position]
        holder.bind(live, onItemClicked)
    }

    override fun getItemCount(): Int {
        return lives.size
    }
}

class MainViewHolder(val binding: ResItemLiveBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(live: Live, onItemClicked: (Live) -> Unit) {

        binding.title.text = live.title
        binding.author.text = live.author

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(live.thumbnailUrl)
            .into(binding.thumbnail)

        itemView.setOnClickListener {
            onItemClicked(live)
        }

    }

}