package com.lizzars.cursos_psg_oficial.common.adapter_common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lizzars.cursos_psg_oficial.R

class IntroSlideAdapter(
    private var image: List<Int>,
    private var title: List<Int>,
    private var description: List<Int>,
) : RecyclerView.Adapter<IntroSlideAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.iv_icon)
        val itemTitle: TextView = itemView.findViewById(R.id.tv_titulo)
        val itemDescription: TextView = itemView.findViewById(R.id.tv_description)

        init {
            itemImage.setOnClickListener { v: View ->
                val position = adapterPosition
                Toast.makeText(
                    itemView.context,
                    "iso click en el itel #${position + 1}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.template_intro_slide, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.itemImage.setImageResource(image[position])
        holder.itemTitle.setText(title[position])
        holder.itemDescription.setText(description[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }
}