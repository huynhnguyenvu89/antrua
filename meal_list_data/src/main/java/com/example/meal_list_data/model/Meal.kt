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