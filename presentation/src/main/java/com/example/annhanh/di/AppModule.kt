package com.example.annhanh.di

import com.example.annhanh.MainActivity
import com.example.meal_list_data.di.MealListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        MealListModule::class
    ]
)
interface AppModule {

    @ContributesAndroidInjector(modules = [
        ActivityModule::class
    ])
    fun mainActivityInjector(): MainActivity
}