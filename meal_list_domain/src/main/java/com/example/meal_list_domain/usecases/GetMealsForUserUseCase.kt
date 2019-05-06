package com.example.meal_list_domain.usecases

import com.example.core.ErrorThrowable
import com.example.core.Result
import com.example.core.UnknownError
import com.example.meal_list_domain.domain.MealListRepository
import com.example.meal_list_domain.domain.MealListRequest
import com.example.meal_list_domain.domain.MealSearchPage
import io.reactivex.Single
import javax.inject.Inject

class GetMealsForUserUseCase @Inject constructor(
    private val mealListRepository: MealListRepository
) {

    fun execute(
        userId : String,
        organizationId : String,
        longitude : Double,
        latitude : Double,
        radius : Double){
        getMeals(userId, organizationId, longitude, latitude, radius)
    }

    private fun getMeals(
        userId : String,
        organizationId : String,
        longitude : Double,
        latitude : Double,
        radius : Double
    ) : Single<Result<MealSearchPage>>{
        val request = MealListRequest(
            userId = userId,
            organizationId = organizationId,
            longitude = longitude,
            latitude = latitude,
            radius = radius
        )
        return mealListRepository.getMeals(request)
            .onErrorReturn { handleError(it) }
    }

    private fun handleError(it: Throwable) : Result<MealSearchPage> {
        return if (it is ErrorThrowable){
            Result.withError(it.error)
        } else {
            Result.OnError(UnknownError())
        }
    }
}