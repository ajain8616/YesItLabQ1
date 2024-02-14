package com.example.yesitlabq1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class CartFragment : Fragment() {

    private lateinit var cartAdapter: CartAdapter
    private lateinit var amountScoreView: TextView
    private lateinit var deliveryPriceView: TextView
    private lateinit var taxPriceView: TextView
    private lateinit var totalPriceView: TextView
    private lateinit var placeOrderView: TextView
    private lateinit var bottomNavigationView: BottomNavigationView

    // Declare cartItems as a property
    private val cartItems = listOf(
        CartItem("Agra Pan Petha", 10.99, 2, R.drawable.agra_pan_petha),
        CartItem("Agra Petha", 19.99, 1, R.drawable.agra_petha),
        CartItem("Bacon Cheese Heaven", 15.50, 3, R.drawable.bacon_cheese_heaven),
        CartItem("Bacon-Wrapped Filet Mignon", 29.99, 1, R.drawable.bacon_wrapped_filet_mignon),
        CartItem("Berry Blast Smoothie", 7.99, 2, R.drawable.berry_blast_smoothie),
        CartItem("California Roll", 12.75, 1, R.drawable.california_roll),
        CartItem("Chaumin", 9.49, 2, R.drawable.chaumin),
        CartItem("Chicago Style Hot Dog", 5.99, 3, R.drawable.chicago_style_hot_dog),
        CartItem("Chicken Avocado Fliss", 14.99, 1, R.drawable.chicken_avocado_fliss),
        CartItem("Chicken Delight", 18.75, 2, R.drawable.chicken_delight),
        CartItem("Chili Cheese Dog", 6.99, 1, R.drawable.chili_cheese_dog),
        CartItem("Chole Bhature", 8.99, 2, R.drawable.chole_bhature)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        amountScoreView = view.findViewById(R.id.amountScoreView)
        deliveryPriceView = view.findViewById(R.id.deliveryPriceView)
        taxPriceView = view.findViewById(R.id.taxPriceView)
        totalPriceView = view.findViewById(R.id.totalPriceView)
        placeOrderView = view.findViewById(R.id.placeOrderView)
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation)

        // Initialize the CartAdapter
        cartAdapter = CartAdapter(requireContext(), cartItems)

        // Set up the RecyclerView with the CartAdapter
        val recyclerView: RecyclerView = view.findViewById(R.id.cartRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = cartAdapter

        calculateTotal()

        // Set up click listener for placeOrderView
        placeOrderView.setOnClickListener {

        }

        return view
    }

    private fun calculateTotal() {
        // Calculate the total amount
        val totalAmount = cartItems.sumByDouble { it.price * it.quantity }

        // Set the values to the TextViews
        amountScoreView.text = getString(R.string.amount_score, totalAmount)

        // Add delivery price (assuming delivery price is fixed, modify as needed)
        val deliveryPrice = 5.0
        deliveryPriceView.text = getString(R.string.delivery_price, deliveryPrice)

        // Set tax price (assuming tax is fixed, modify as needed)
        val taxPrice = 2.0
        taxPriceView.text = getString(R.string.tax_price, taxPrice)

        // Calculate the total price
        val totalPrice = totalAmount + deliveryPrice + taxPrice
        totalPriceView.text = getString(R.string.total_price, totalPrice)
    }
}
