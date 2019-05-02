package com.example.meal_list_data

import com.example.meal_list_data.model.MealListResponse
import com.example.meal_list_domain.domain.MealSearchPage

internal fun MealListResponse.toDomain(): MealSearchPage {
    return MealSearchPage(
        totalMealCount = totalMealCount
    )
}