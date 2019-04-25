package com.example.meal_list_data.di

import com.example.meal_list_data.network.MealListApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MealListModule {

    @Provides
    fun provideMealListApi(retrofit: Retrofit) : MealListApi {
        return retrofit.create(MealListApi::class.java)
    }
}