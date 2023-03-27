package com.example.submisionakhiraplikasi_mbti

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListMbtiAdapter(private val listMbti: ArrayList<MBTI>) : RecyclerView.Adapter<ListMbtiAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_mbti, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMbti.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, type) = listMbti[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.imgPhoto) // imageView mana yang akan diterapkan
        holder.tvName.text = name
        holder.tvDescription.text = description
        val mbti = MBTI(
            name, description, photo, type
        )
        holder.itemView.setOnClickListener {
            val intent =Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DATA_MBTI, mbti)
            holder.itemView.context.startActivity(intent)
        }

    }
}