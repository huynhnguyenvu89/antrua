package com.example.meal_list_domain.domain

import io.reactivex.Single
import com.example.core.Result

interface MealListRepository {

    fun getMeals(request: MealListRequest): Single<Result<MealSearchPage>>
}