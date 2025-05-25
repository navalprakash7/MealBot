package com.example.mealbot.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mealbot.DetailsActivity
import com.example.mealbot.databinding.PopularItemBinding

class PopularAdapter(
    private val items: List<String>,
    private val prices: List<String>,
    private val images: List<Int>,
    private val requiredContext: Context
) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(items[position], prices[position], images[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(requiredContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName", items[position])
            intent.putExtra("MenuItemImage", images[position])
            requiredContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size

    class PopularViewHolder(private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, price: String, imageRes: Int) {
            binding.foodNamePopular.text = item
            binding.pricePopular.text = price
            binding.imageView6.setImageResource(imageRes)

            binding.addToCartPopular.setOnClickListener {
                Toast.makeText(binding.root.context, "$item added to cart", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
