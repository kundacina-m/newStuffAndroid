package com.example.myapplication

sealed class DataState<T>(val data :T?){


    class Loading<T>(data:T?):DataState<T>(data)
    class Success<T>( data :T?):DataState<T>(data)
    class Error<T>(val t: Throwable, data :T?):DataState<T>(data)

}