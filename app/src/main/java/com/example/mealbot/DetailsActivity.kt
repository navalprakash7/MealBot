package com.example.mealbot

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mealbot.databinding.ActivityDetailsBinding
import com.google.firebase.auth.FirebaseAuth

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    // List of food names matching your menu order and string resource numbering
    private val menuFoodName = listOf(
        "Burger", "Pizza", "Sandwich", "Rice", "Pasta", "Fries", "Noodles", "Salad", "Wrap", "Steak",
        "Taco", "Soup", "Kebab", "Dosa", "Curry", "Paneer", "Biryani", "Momos", "Hotdog", "Sushi"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get data passed from previous activity
        val foodName = intent.getStringExtra("MenuItemName")
        val foodImage = intent.getIntExtra("MenuItemImage", 0)

        // Set food name and image in UI
        binding.detailFoodName.text = foodName
        binding.detailFoodImage.setImageResource(foodImage)

        if (foodName != null) {
            val index = menuFoodName.indexOf(foodName) + 1 // +1 because resource names start at 1
            if (index > 0) {
                // Get description and ingredients string resource IDs dynamically
                val descResId = resources.getIdentifier("product${index}_description", "string", packageName)
                val ingResId = resources.getIdentifier("product${index}_ingredients", "string", packageName)

                val description = if (descResId != 0) getString(descResId) else "Description not available."
                val ingredientsRaw = if (ingResId != 0) getString(ingResId) else "Ingredients not available."
                val ingredients = ingredientsRaw.replace("\\n", "\n")

                // Set description and ingredients text
                binding.descriptionTextVIew.text = description
                binding.ingredientsTextView.text = ingredients
            } else {
                binding.descriptionTextVIew.text = "Description not available."
                binding.ingredientsTextView.text = "Ingredients not available."
            }
        } else {
            binding.descriptionTextVIew.text = "Description not available."
            binding.ingredientsTextView.text = "Ingredients not available."
        }

        // Back button finishes the activity
        binding.buttonBackDetail.setOnClickListener {
            finish()
        }
        binding.detailAddToCart.setOnClickListener {
            val name = binding.detailFoodName.text.toString()
            Toast.makeText(this, "$name added to cart", Toast.LENGTH_SHORT).show()
        }

    }
}
