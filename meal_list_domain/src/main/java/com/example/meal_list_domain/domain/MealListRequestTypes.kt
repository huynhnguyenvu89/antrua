package com.example.meal_list_domain.domain


/**
 * Request object to query a list of meals for a registered user
 *
 * @userId unique ID for a registered user, must not be null
 * @organizationId unique ID belongs to a user's organization, could be null
 * @longitude longitude of user's preferred search location
 * @latitude latitude of user's preferred search location
 * @radius a search area radius value, 500 meters by default
 */
data class MealListRequest(
    val userId: String,
    val organizationId: String?,
    val longitude: Double?,
    val latitude: Double?,
    val radius: Double = 500.0
)