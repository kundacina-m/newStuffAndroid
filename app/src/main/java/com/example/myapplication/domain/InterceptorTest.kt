package com.example.myapplication.domain

import com.example.myapplication.view.ModelView
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class InterceptorTest {

    val repositoryTest = RepositoryTest()

    fun fetchData(mapper: (DomainModel) -> ModelView, callback: (ModelView) -> Unit) =
        repositoryTest.fetchData().sub {
            callback.invoke(mapper(it))
        }

}

fun <T> Single<T>.sub(callback: (T) -> Unit) =
    this.subscribeOn(Schedulers.io())
        .subscribe { it ->
            callback.invoke(it)
        }

