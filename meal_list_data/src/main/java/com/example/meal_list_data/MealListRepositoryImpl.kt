package com.example.meal_list_data

import com.example.core.NetworkError
import com.example.meal_list_data.network.MealListApi
import com.example.meal_list_domain.domain.MealListRepository
import com.example.meal_list_domain.domain.MealListRequest
import com.example.meal_list_domain.domain.MealSearchPage
import com.example.core.Result
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class MealListRepositoryImpl @Inject constructor(
    private val mealListApi: MealListApi
) : MealListRepository {

    override fun getMeals(request: MealListRequest): Single<Result<MealSearchPage>> {
        return mealListApi.getMeals(
            userId = request.userId,
            organizationId = request.organizationId,
            longitude = request.longitude,
            latitude = request.latitude,
            radius = request.radius
        )
            .map { it.toDomain() }
            .map { Result.withValue(it) }
            .onErrorReturn { Result.OnError(NetworkError()) }
            .subscribeOn(Schedulers.io())
    }
}