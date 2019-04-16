package com.vuhuynh.location_domain

import android.Manifest
import android.location.Location
import android.support.annotation.RequiresPermission
import io.reactivex.Observable
import io.reactivex.Single
import java.lang.Exception

interface LocationProvider {

    enum class Accuracy {
        /* Passive listener, waits for location update from other apps */
        NOT_APPLIED,
        /* ~6 miles accuracy */
        LOW,
        /* ~350ft accuracy */
        BALANCED,
        /* The best available accuracy, but drain battery */
        HIGH_ACCURACY
    }

    @RequiresPermission(
        anyOf = [ Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION ])
    fun getLastKnownLocation(): Single<Location>

    @RequiresPermission(
        anyOf = [ Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION ])
    fun getLocation(accuracy: Accuracy = Accuracy.BALANCED,
                    maxWaitTime: Long? = null)

    @RequiresPermission(
        anyOf = [ Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION ])
    fun getLocationAvailability(): Single<Boolean>

    @RequiresPermission(
        anyOf = [ Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION ])
    fun getLocations(accuracy: Accuracy = Accuracy.BALANCED,
                     fastestInternal: Long) : Observable<Location>

    class NoLocationException: Exception()
}