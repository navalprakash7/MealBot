package com.example.mealbot.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.mealbot.R
import com.example.mealbot.adapter.PopularAdapter
import com.example.mealbot.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewAllMenu.setOnClickListener{
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = arrayListOf(
            SlideModel(R.drawable.banner1, ScaleTypes.FIT),
            SlideModel(R.drawable.banner2, ScaleTypes.FIT),
            SlideModel(R.drawable.banner3, ScaleTypes.FIT),
            SlideModel(R.drawable.banner4, ScaleTypes.FIT),
            SlideModel(R.drawable.banner5, ScaleTypes.FIT)
        )

        binding.imageSlider.setImageList(imageList, ScaleTypes.FIT)

        binding.imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                // Optional: Implement double-click functionality if needed
            }

            override fun onItemSelected(position: Int) {
                Toast.makeText(requireContext(), "Selected Image $position", Toast.LENGTH_SHORT).show()
            }
        })

        val foodName = listOf("Burger", "Pizza", "Sandwich", "Rice", "Pasta", "Fries", "Noodles", "Salad")
        val price = listOf("$5", "$8", "$6", "$4", "$7", "$3", "$6", "$5")
        val popularFoodImages = listOf(R.drawable.menu1, R.drawable.menu2, R.drawable.menu3, R.drawable.menu4,R.drawable.menu5, R.drawable.menu6, R.drawable.menu7, R.drawable.menu8)

        binding.PopularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.PopularRecyclerView.adapter = PopularAdapter(foodName, price, popularFoodImages,requireContext())


    }
}
