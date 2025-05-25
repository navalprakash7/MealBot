package com.example.mealbot.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mealbot.DetailsActivity
import com.example.mealbot.databinding.PopularItemBinding

class MenuAdapter(
    private val menuItemsName: List<String>,
    private val menuItemsPrice: List<String>,
    private val menuImages: List<Int>,
    private val context: Context
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val intent = Intent(context, DetailsActivity::class.java).apply {
                        putExtra("MenuItemName", menuItemsName[position])
                        putExtra("MenuItemImage", menuImages[position])
                    }
                    context.startActivity(intent)
                }
            }
        }

        fun bind(position: Int) {
            binding.foodNamePopular.text = menuItemsName[position]
            binding.pricePopular.text = menuItemsPrice[position]
            binding.imageView6.setImageResource(menuImages[position])

            binding.addToCartPopular.setOnClickListener {
                Toast.makeText(context, "${menuItemsName[position]} added to cart", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
