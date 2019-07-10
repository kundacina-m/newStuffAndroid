package com.example.myapplication

import androidx.lifecycle.MutableLiveData

class StateLiveData<T> : MutableLiveData<DataState<T>>(){


    init {
        setLoading()
    }

    fun updateValue(result: Result<T>) {

        when (result) {
            is Result.OnSuccess -> {
                postValue(DataState.Success(result.data))
            }
            is Result.OnError -> {
                postValue(DataState.Error(result.error, getOldData()))
            }
        }

    }

    fun setLoading() = postValue(DataState.Loading(getOldData()))

    private fun getOldData() = value?.data

}