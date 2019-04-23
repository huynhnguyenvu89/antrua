package com.example.meal_list_data.network

import com.example.meal_list_data.model.MealListResponse
import io.reactivex.Single

interface MealListApi {

    fun getMeals(

    ): Single<MealListResponse>

}