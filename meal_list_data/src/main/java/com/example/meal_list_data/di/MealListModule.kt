package com.example.meal_list_data.di

import com.example.meal_list_data.MealListRepositoryImpl
import com.example.meal_list_data.network.MealListApi
import com.example.meal_list_domain.domain.MealListRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(
    includes = [
        MealListApiModule::class,
        MealListRepositoryModule::class
    ]
)
interface MealListModule

@Module
class MealListApiModule {

    @Provides
    fun provideMealListApi(retrofit: Retrofit) : MealListApi {
        return retrofit.create(MealListApi::class.java)
    }
}

@Module
class MealListRepositoryModule {

    @Provides
    fun provideMealListRepository(
        mealListApi: MealListApi
    ): MealListRepository {
        return MealListRepositoryImpl(mealListApi)
    }
}