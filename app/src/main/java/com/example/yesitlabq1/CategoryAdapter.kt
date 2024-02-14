package com.example.yesitlabq1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    private val context: Context,
    private val categoryList: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    companion object {
        const val VIEW_TYPE_CATEGORY = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(context)
        val categoryView = inflater.inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(categoryView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.categoryImage.setImageResource(IconPicker.getIcon(position + 1))
        holder.categoryImage.setBackgroundColor(ColorPicker.getColor(position + 1))
        holder.itemView.setOnClickListener {
            // Handle category item click
            val recipeFragment = ListFragment()
            val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, recipeFragment)
            transaction.addToBackStack(null)
            transaction.commit()

            // Set the selected item in BottomNavigationView to 'list'
            (context).updateBottomNavigationSelectedItem(R.id.list)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_CATEGORY
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage: ImageView = itemView.findViewById(R.id.categoryImage)
    }
}
