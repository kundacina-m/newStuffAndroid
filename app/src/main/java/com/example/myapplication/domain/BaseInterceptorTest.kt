package com.example.myapplication.domain

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

abstract class BaseInterceptorTest<Params,D>{

    protected val compositeDisposable  =CompositeDisposable()

    abstract fun buildCall(params: Params):Single<D>

    fun <T> execute(params:Params): Mapper<D, T> {

        return Mapper(
             buildCall(params))

    }

    fun execute(params: Params,  callback: (D) -> Unit){

        compositeDisposable.add(buildCall(params).subscribe{
            it-> callback.invoke(it)
        })
    }



    inner class Mapper<D, V>(private val call: Single<D>) {

        fun map(mapper: (D) -> V, callback: (V) -> Unit) {
           compositeDisposable.add(call.subscribe {
                it-> callback.invoke(mapper(it))

            })


        }


    }

    fun clear(){
        compositeDisposable.clear()
    }
}