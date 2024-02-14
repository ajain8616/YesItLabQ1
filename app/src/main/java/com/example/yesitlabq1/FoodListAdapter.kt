package com.example.yesitlabq1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodListAdapter(private val context: Context, private val foodList: List<Food>) :
    RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_food_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodItem = foodList[position]

        holder.foodImage.setImageResource(foodItem.foodImage)
        holder.foodName.text = foodItem.foodName

        // Set click listener to handle item click
        holder.itemView.setOnClickListener {
            // Pass data to RecipeFragment when an item is clicked
            val recipeFragment = HomeFragment()
            val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, recipeFragment)
            transaction.addToBackStack(null)
            transaction.commit()

            // Set the selected item in BottomNavigationView to 'list'
            (context as MainActivity).updateBottomNavigationSelectedItem(R.id.home)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage: ImageView = itemView.findViewById(R.id.bestFoodImage)
        val foodName: TextView = itemView.findViewById(R.id.bestFoodName)
    }
}
