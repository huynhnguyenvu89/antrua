package com.example.meal_list_domain.domain

data class MealSearchPage(
    val totalMealCount: Int,
    val meals: List<MealListItem> = emptyList()
)

data class MealListItem(
    val meal: Meal,
    val restaurant: Restaurant
)

data class Meal (
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val cuisine: String,
    val isFavorite: Boolean,
    val recipes: Recipes
)

data class Recipes (
    val id: String,
    val name: String,
    val ingredients: List<Ingredient>
)

data class Restaurant (
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String
)

data class Ingredient (
    val id: String,
    val name: String
)