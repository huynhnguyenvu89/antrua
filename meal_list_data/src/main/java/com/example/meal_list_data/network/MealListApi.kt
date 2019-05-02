package com.example.meal_list_data.network

import com.example.meal_list_data.model.CatListResponse
import com.example.meal_list_data.model.MealListResponse
import io.reactivex.Single
import io.reactivex.annotations.NonNull
import io.reactivex.annotations.Nullable
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

    /**
     * Get a list of meals for a registered user
     * @userId unique ID for a registered user, must not be null
     * @organizationId unique ID belongs to a user's organization, could be null
     * @longitude longitude of user's preferred search location
     * @latitude latitude of user's preferred search location
     * @radius a search area radius value, default to be 500 meters
     */
    @GET("/mobileapp/v1/search?deviceType=ANDROID")
    fun getMeals(
        @NonNull @Query("userId") userId: String,
        @Nullable @Query("organizationId") organizationId: String?,
        @Query("longitude") longitude: Double?,
        @Query("latitude") latitude: Double?,
        @Query("radius") radius: Double
    ): Single<MealListResponse>

}