package com.example.yesitlabq1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val context: Context, private var foodItemList: List<Food>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodItem = foodItemList[position]

        // Set food image using Picasso/Glide or any other image loading library
        holder.foodImage.setImageResource(foodItem.foodImage)

        // Set food name
        holder.foodName.text = foodItem.foodName
        holder.itemView.setOnClickListener {
            // Pass data to RecipeFragment when an item is clicked
            val listFragment = ListFragment()
            val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, listFragment)
            transaction.addToBackStack(null)
            transaction.commit()

            // Set the selected item in BottomNavigationView to 'list'
            (context as MainActivity).updateBottomNavigationSelectedItem(R.id.list)
        }
    }

    override fun getItemCount(): Int {
        return foodItemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage: ImageView = itemView.findViewById(R.id.foodImage)
        val foodName: TextView = itemView.findViewById(R.id.foodName)
    }
    fun updateData(newList: List<Food>) {
        foodItemList = newList
        notifyDataSetChanged()
    }

}
