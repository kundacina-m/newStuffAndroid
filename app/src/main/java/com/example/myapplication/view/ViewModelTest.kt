package com.example.myapplication.view

import androidx.lifecycle.ViewModel
import com.example.myapplication.Result
import com.example.myapplication.StateLiveData
import com.example.myapplication.domain.DomainModel
import com.example.myapplication.domain.InterceptorTest
import java.util.*
import kotlin.concurrent.schedule

class ViewModelTest : ViewModel() {


    var state = StateLiveData<String>()
    val interceptor = InterceptorTest()


    init {

        changeState()
    }


    private fun changeState() {


        Timer().schedule(500) {

            state.updateValue(Result.OnSuccess("Milan"))

        }


        Timer().schedule(1500) {

            state.updateValue(Result.OnError(Exception("Error")))

        }

        Timer().schedule(3500) {

            getData()

        }

    }

    fun getData() =
        interceptor.fetchData(mapper = ::domainToViewMapper) {
            state.updateValue(Result.OnSuccess(it.name))
        }


    private fun domainToViewMapper(domainModel: DomainModel) =
        ModelView(domainModel.name)

}