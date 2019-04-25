package com.example.meal_list_data.model

data class Meal(
    val mealId: String,
    val mealName: String,
    val mealImageUrl: String,
    val storeId: String,
    val storeName: String,
    val storeAddress: String,
    val distance: Long,
    val isFavorite: Boolean = false
)

/**
 * DELETE ME: Testing purpose only
 * Use https://chex-triplebyte.herokuapp.com/api/cats?page=0
 * To fetch fake cat data
 */
data class Cat(
    val title: String,
    val timeStamp: String,
    val imageUrl: String,
    val description: String
)