package com.example.yesitlabq1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private lateinit var allFoodAdapter: FoodListAdapter
    private lateinit var recyclerViewAllFood: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerViewAllFood = view.findViewById(R.id.recyclerViewAllFood)

        val allFoodList = listOf(
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


        allFoodAdapter = FoodListAdapter(requireContext(), allFoodList)

        // Use GridLayoutManager with span count 2 for a grid with 2 columns
        recyclerViewAllFood.layoutManager =  GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        recyclerViewAllFood.adapter = allFoodAdapter

        return view
    }
}
