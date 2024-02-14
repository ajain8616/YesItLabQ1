package com.example.yesitlabq1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
    private val context: Context,
    private val cartItems: List<CartItem>
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(context)
        val cartItemView = inflater.inflate(R.layout.cart_list_item, parent, false)
        return CartViewHolder(cartItemView)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cartItem = cartItems[position]

        // Set data to views
        holder.titleView.text = cartItem.title
        holder.priceEachItem.text = String.format("$%.2f", cartItem.price)
        holder.totalEachItem.text = String.format("$%.2f", cartItem.price * cartItem.quantity)
        holder.imageView.setImageResource(cartItem.imageUrl)
        holder.countTexView.text = cartItem.quantity.toString()

        // Add click listeners for increment and decrement buttons if needed
        holder.decrementButton.setOnClickListener {
            if (cartItem.quantity > 1) {
                cartItem.quantity--
                holder.countTexView.text = cartItem.quantity.toString()
                holder.totalEachItem.text = String.format("$%.2f", cartItem.price * cartItem.quantity)
            }
        }

        holder.incrementButton.setOnClickListener {
            cartItem.quantity++
            holder.countTexView.text = cartItem.quantity.toString()
            holder.totalEachItem.text = String.format("$%.2f", cartItem.price * cartItem.quantity)
        }
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.titleView)
        val priceEachItem: TextView = itemView.findViewById(R.id.priceEachItem)
        val totalEachItem: TextView = itemView.findViewById(R.id.totalEachItem)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val decrementButton: ImageButton = itemView.findViewById(R.id.decrementButton)
        val incrementButton: ImageButton = itemView.findViewById(R.id.incrementButton)
        val countTexView: TextView = itemView.findViewById(R.id.countTexView)
    }
}
