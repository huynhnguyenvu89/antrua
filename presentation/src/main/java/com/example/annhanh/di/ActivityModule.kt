package com.example.annhanh.di

import android.support.v7.app.AppCompatActivity
import com.example.annhanh.MainActivity
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        MealListFragmentModule::class
    ]
)
interface ActivityModule {

    @Binds
    fun bindsMainActivity(activity: MainActivity): AppCompatActivity
}