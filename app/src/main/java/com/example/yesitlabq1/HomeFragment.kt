package com.example.yesitlabq1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    private lateinit var foodAdapter: FoodAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewCategory: RecyclerView
    private lateinit var searchInput: EditText
    private lateinit var searchButton: ImageView
    private lateinit var bestFood: TextView
    private lateinit var foodCategory: TextView
    private lateinit var viewAllBestFood: TextView
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerViewCategory = view.findViewById(R.id.recyclerViewCategory)
        searchInput = view.findViewById(R.id.search_Input)
        searchButton = view.findViewById(R.id.search_Button)
        bestFood = view.findViewById(R.id.bestFood)
        foodCategory = view.findViewById(R.id.foodCategory)
        viewAllBestFood = view.findViewById(R.id.viewAllBestFood)
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation)

        val foodList = listOf(
            Food("Agra Pan Petha", R.drawable.agra_pan_petha),
            Food("Agra Petha", R.drawable.agra_petha),
            Food("Bacon Cheese Heaven", R.drawable.bacon_cheese_heaven),
            Food("Bacon-Wrapped Filet Mignon", R.drawable.bacon_wrapped_filet_mignon),
            Food("Berry Blast Smoothie", R.drawable.berry_blast_smoothie),
            Food("California Roll", R.drawable.california_roll),
            Food("Chaumin", R.drawable.chaumin),
            Food("Chicago Style Hot Dog", R.drawable.chicago_style_hot_dog),
            Food("Chicken Avocado Fliss", R.drawable.chicken_avocado_fliss),
            Food("Chicken Delight", R.drawable.chicken_delight),
            Food("Chili Cheese Dog", R.drawable.chili_cheese_dog),
            Food("Chole Bhature", R.drawable.chole_bhature),
            Food("Classic Beef Burger", R.drawable.classic_beef_burger),
            Food("Coconut Water", R.drawable.coconut_water),
            Food("Doodh Peda", R.drawable.doodh_peda),
            Food("Dragon Roll", R.drawable.dragon_roll),
            Food("Espresso Martini", R.drawable.espresso_martini),
            Food("Four Cheese Delight", R.drawable.four_cheese_delight),
            Food("Fresh Orange Juice", R.drawable.fresh_orange_juice),
            Food("Garlic Parmesan Chicken", R.drawable.garlic_parmesan_chicken),
            Food("Green Tea Latte", R.drawable.green_tea_latte),
            Food("Grilled Ribeye Steak", R.drawable.grilled_ribeye_steak),
            Food("Hawaiian BBQ Dog", R.drawable.hawaiian_bbq_dog),
            Food("Hawaiian Paradise", R.drawable.hawaiian_paradise),
            Food("Honey Mustard Glazed Tenders", R.drawable.honey_mustard_glazed_tenders),
            Food("Intro Pic", R.drawable.intro_pic),
            Food("Kaju Katli", R.drawable.kaju_katli),
            Food("Kimchi Hot Dog", R.drawable.kimchi_hot_dog),
            Food("Korean BBQ Short Ribs", R.drawable.korean_bbq_short_ribs),
            Food("Korean Fried Chicken", R.drawable.korean_fried_chicken),
            Food("Lemon Pepper Chicken", R.drawable.lemon_pepper_chicken),
            Food("Mango Tango Slush", R.drawable.mango_tango_slush),
            Food("Margherita Flatbread", R.drawable.margherita_flatbread),
            Food("Meal Test", R.drawable.mealtest),
            Food("Meat Feast Pizza", R.drawable.meat_feast_pizza),
            Food("Mediterranean Joy", R.drawable.mediterranean_joy),
            Food("Mint Lemonade", R.drawable.mint_lemonade),
            Food("Mushroom Swiss Delight", R.drawable.mushroom_swiss_delight),
            Food("Orange Background", R.drawable.orange_background),
            Food("Original Crispy Chicken", R.drawable.original_crispy_chicken),
            Food("Pani Puri", R.drawable.pani_puri),
            Food("Pasta Carbonara", R.drawable.pasta_carbonara),
            Food("Pepperoni Lovers", R.drawable.pepperoni_lovers),
            Food("Pretzel Bun Dog", R.drawable.pretzel_bun_dog),
            Food("Quinoa Salad Bowl", R.drawable.quinoa_salad_bowl),
            Food("Rainbow Roll", R.drawable.rainbow_roll),
            Food("Ranch Delight", R.drawable.ranch_delight),
            Food("Rasgulla", R.drawable.rasgulla),
            Food("Reuben Style Hot Dog", R.drawable.reuben_style_hot_dog),
            Food("Salmon Nigiri", R.drawable.salmon_nigiri),
            Food("Sashimi Platter", R.drawable.sashimi_platter),
            Food("Shrimp Scampi", R.drawable.shrimp_scampi),
            Food("Smoked BBQ Brisket", R.drawable.smoked_bbq_brisket),
            Food("Sondash", R.drawable.sondash),
            Food("Spicy Jalapeño Burger", R.drawable.spicy_jalapeno_burger),
            Food("Spicy Tuna Roll", R.drawable.spicy_tuna_roll),
            Food("Stuffed Bell Peppers", R.drawable.stuffed_bell_peppers),
            Food("Teriyaki Pineapple Pleasure", R.drawable.teriyaki_pineapple_pleasure),
            Food("Thai Red Curry", R.drawable.thai_red_curry),
            Food("Vegetarian Pad Thai", R.drawable.vegetarian_pad_thai),
            Food("Veggie Dog", R.drawable.veggie_dog),
            Food("Veggie Extravaganza", R.drawable.veggie_extravaganza),
            Food("Veggie Roll", R.drawable.veggie_roll),
            Food("Veggie Supreme", R.drawable.veggie_supreme)
        )


        val categoryList = listOf(
            Category(R.drawable.btn_1),
            Category(R.drawable.btn_2),
            Category(R.drawable.btn_3),
            Category(R.drawable.btn_4),
            Category(R.drawable.btn_5),
            Category(R.drawable.btn_6),
            Category(R.drawable.btn_7),
            Category(R.drawable.btn_8),
            Category(R.drawable.btn_9)
        )

        foodAdapter = FoodAdapter(requireContext(), foodList)
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = foodAdapter

        val categoryAdapter = CategoryAdapter(requireContext(), categoryList)
        recyclerViewCategory.layoutManager =
            GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
        recyclerViewCategory.adapter = categoryAdapter

        // Search functionality
        searchButton.setOnClickListener {
            val searchText = searchInput.text.toString().trim()

            // Check if search input is not empty
            if (searchText.isNotEmpty()) {
                // Filter the food list based on the entered text
                val filteredList = foodList.filter { food ->
                    food.foodName.contains(searchText, true)
                }

                foodAdapter.updateData(filteredList)

                recyclerViewCategory.visibility = View.GONE
                bestFood.visibility = View.GONE
                foodCategory.visibility = View.GONE
                viewAllBestFood.visibility = View.GONE
            } else {
                Toast.makeText(requireContext(), "Please enter a search term", Toast.LENGTH_LONG).show()
            }
        }



        // Navigate to HomeFragment when viewAllBestFood is clicked
        viewAllBestFood.setOnClickListener {
            val homeFragment = HomeFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container, homeFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            bottomNavigationView.selectedItemId = R.id.list
        }

        return view
    }
}
