package com.example.core

/**
 * Super type of all errors.
 */
sealed class Error(
    val message: String,
    val throwable: Throwable?
)

/**
 * An unknown error. This type should be used only as a last resort when a more meaningful [Error] cannot be used.
 * @see Error
 */
open class UnknownError(
    message: String = "Unknown Error",
    throwable: Throwable? = null
) : Error(message, throwable)

/**
 * A network operation error
 * @see Error
 */
open class NetworkError(
    message: String = "Network Error",
    throwable: Throwable? = null
) : Error(message, throwable)
