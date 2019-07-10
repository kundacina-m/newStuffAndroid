package com.example.myapplication

sealed class Result<out T>{

    data class OnSuccess<out T>(val data:T):Result<T>()
    data class OnError(val error:Throwable):Result<Nothing>()

}