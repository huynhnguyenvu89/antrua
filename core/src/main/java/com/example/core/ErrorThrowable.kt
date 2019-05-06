package com.example.core

class ErrorThrowable (val error: Error): Throwable()

fun Error.toErrorThrowable(): ErrorThrowable = ErrorThrowable(this)