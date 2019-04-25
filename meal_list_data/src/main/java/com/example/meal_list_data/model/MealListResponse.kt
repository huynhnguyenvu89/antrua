package com.example.meal_list_data.model

data class MealListResponse(
    val meals : List<Meal> = emptyList()
)

/**
 * DELETE ME: Testing purpose only
 * Use https://chex-triplebyte.herokuapp.com/api/cats?page=0
 * To fetch fake cat data
 */
data class CatListResponse(
    val cats : List<Cat> = emptyList()
)
