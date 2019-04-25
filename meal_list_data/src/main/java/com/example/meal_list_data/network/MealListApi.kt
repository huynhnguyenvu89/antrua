package com.example.meal_list_data.network

import com.example.meal_list_data.model.CatListResponse
import com.example.meal_list_data.model.MealListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MealListApi {

    /**
     * DELETE ME: Testing purpose only
     * Use https://chex-triplebyte.herokuapp.com/api/cats?page=0
     * To fetch fake cat data
     */
    @GET("api/cats?")
    fun getCats(
        @Query("page") page: Int
    ): Single<CatListResponse>

    @GET("/mobileapp/v1/search?deviceType=ANDROID")
    fun getMeals(
        @Query("userId") userId: String,
        @Query("organizationId") organizationId: String?,
        @Query("longitude") longitude: Double?,
        @Query("latitude") latitude: Double?,
        @Query("radius") radius: String?
    ): Single<MealListResponse>

}