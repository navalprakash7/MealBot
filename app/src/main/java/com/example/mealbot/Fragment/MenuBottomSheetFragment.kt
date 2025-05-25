package com.example.mealbot.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealbot.R
import com.example.mealbot.adapter.MenuAdapter
import com.example.mealbot.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }

        val menuFoodName = listOf("Burger", "Pizza", "Sandwich", "Rice", "Pasta", "Fries", "Noodles", "Salad", "Wrap", "Steak", "Taco", "Soup", "Kebab", "Dosa", "Curry", "Paneer", "Biryani", "Momos", "Hotdog", "Sushi")
        val menuItemPrice = listOf("$5", "$8", "$6", "$4", "$7", "$3", "$6", "$5", "$4", "$9", "$4", "$5", "$7", "$3", "$6", "$8", "$9", "$4", "$3", "$10")
        val menuImage = listOf(
            R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4, R.drawable.menu5,
            R.drawable.menu6, R.drawable.menu7, R.drawable.menu8, R.drawable.menu9, R.drawable.menu10,
            R.drawable.menu11, R.drawable.menu12, R.drawable.menu13, R.drawable.menu14, R.drawable.menu15,
            R.drawable.menu16, R.drawable.menu17, R.drawable.menu18, R.drawable.menu19, R.drawable.menu20
        )

        val adapter = MenuAdapter(
            menuFoodName,
            menuItemPrice,
            menuImage,
            requireContext()
        )

        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }
}
