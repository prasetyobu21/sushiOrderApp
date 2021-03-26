package com.dicoding.orderfoodapp

object FoodMenuData {
    private val foodName = arrayOf(
            "Salmon Sashimi",
            "Tuna Sashimi",
            "Unagi Set",
            "Tamago",
            "Salmon Sushi",
            "Tuna Sushi",
            "Beef Teriyaki",
            "Chicken Teriyaki",
            "Chicken Katsu",
            "Natto",
            "Fruit Punch",
            "Strawberry Splash",
            "Ocha",
            "Milk Tea"
    )

    private val foodDetail = arrayOf(
            "Fresh salmon cut with shoyu (japanese soy sauce) and washabi",
            "Tuna salmon cut with shoyu (japanese soy sauce) and washabi",
            "Grilled eel with japanese spice and rice",
            "Japanese street food, made with high quality egg",
            "Fresh salmon cut and japanese rice wrapped in nori with shoyu (japanese Soy Sauce) and washabi",
            "Fresh tuna cut and japanese Rice wrapped in nori with shoyu (japanese Soy Sauce) and washabi",
            "Smoky beef with teriyaki Sauce",
            "Smoky chicken with teriyaki Sauce",
            "Fried chicken with bread crumb and japanese spice",
            "Japanese food made from soybeans that have been fermented. Served with seaweed and quail egg yolk",
            "Tutti Frutti syrup with fresh orange, strawberry, and pineapple",
            "Strawberry syrup with soda and fresh strawberry cuts",
            "Japanese tea",
            "Tea with milk"
    )

    private val foodImages = intArrayOf(
            R.drawable.salmon_sashimi,
            R.drawable.tuna_sashimi,
            R.drawable.unagi,
            R.drawable.tamago,
            R.drawable.salmon_sushi,
            R.drawable.tuna_sushi,
            R.drawable.beef_teriyaki,
            R.drawable.chicken_teriyaki,
            R.drawable.chicken_katsu,
            R.drawable.natto,
            R.drawable.fruit_punch,
            R.drawable.strawberry_splash,
            R.drawable.ocha,
            R.drawable.milk_tea
    )

    private val foodPrice = doubleArrayOf(
            9.99, //salmon sashimi
            9.99, //tuna sashimi
            5.3, //unagi set
            1.4, // tamago
            9.99, //salmon sushi
            9.99, //tuna sushi
            4.5, // beef teriyaki
            3.2, //chicken teriyaki
            1.9, //chicken katsu,
            2.3, //natto
            1.4, //fruit punch
            1.0, //strawberry splash
            0.7, //ocha
            1.0 //milk tea
    )

    private val foodCategory = arrayOf(
            "Main Course",
            "Main Course",
            "Main Course",
            "Side Dish",
            "Main Course",
            "Main Course",
            "Main Course",
            "Main Course",
            "Side Dish",
            "Side Dish",
            "Drink",
            "Drink",
            "Drink",
            "Drink"
    )

    val listData: ArrayList<FoodMenu>
        get() {
            val list = arrayListOf<FoodMenu>()
            for(position in foodName.indices){
                val food = FoodMenu()
                food.name = foodName[position]
                food.detail = foodDetail[position]
                food.photo = foodImages[position]
                food.price = foodPrice[position]
                food.category = foodCategory[position]
                list.add(food)
            }
            return list
        }

}