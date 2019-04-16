package com.vuhuynh.location_data

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.support.annotation.RequiresPermission
import com.google.android.gms.location.LocationServices
import com.vuhuynh.location_domain.LocationProvider
import io.reactivex.Observable
import io.reactivex.Single

@SuppressLint("MissingPermission")
class GoogleLocationProvider(private val context: Context) : LocationProvider {

    @RequiresPermission(
        anyOf = [ Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION ])
    override fun getLastKnownLocation(): Single<Location> {
        return Single.create { emitter ->
            LocationServices.getFusedLocationProviderClient(context)
                .lastLocation
                .addOnSuccessListener {
                    if (it == null){
                        emitter.onError(LocationProvider.NoLocationException())
                    } else if (!emitter.isDisposed) {
                        emitter.onSuccess(it)
                    }
                }
                .addOnFailureListener {
                    emitter.onError(it)
                }
        }
    }

    @RequiresPermission(
        anyOf = [ Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION ])
    override fun getLocation(accuracy: LocationProvider.Accuracy, maxWaitTime: Long?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @RequiresPermission(
        anyOf = [ Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION ])
    override fun getLocationAvailability(): Single<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @RequiresPermission(
        anyOf = [ Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION ])
    override fun getLocations(accuracy: LocationProvider.Accuracy, fastestInternal: Long): Observable<Location> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}