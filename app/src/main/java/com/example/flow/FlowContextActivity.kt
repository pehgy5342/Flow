package com.example.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

class FlowContextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_context)

        main()
    }

       //在沒有指定 context 的形況下，是在Dispatchers.Main 下被呼叫
//    fun main() = runBlocking {
//        (1..2).asFlow()
//            .onEach { println("onEach1: $it is on ${Thread.currentThread().name}") }
//            .onEach { println("onEach2: $it is on ${Thread.currentThread().name}") }
//            .onEach { println("onEach3: $it is on ${Thread.currentThread().name}") }
//            .collect { println("collect: $it is on ${Thread.currentThread().name}") }
//    }


    //flowOn()
//    fun main() = runBlocking {
//        (1..2).asFlow()
//            .onEach { println("onEach1: $it is on ${Thread.currentThread().name}") }
//            .onEach { println("onEach2: $it is on ${Thread.currentThread().name}") }
//            .flowOn(Dispatchers.IO)
//            .onEach { println("onEach3: $it is on ${Thread.currentThread().name}") }
//            .collect { println("collect: $it is on ${Thread.currentThread().name}") }
//    }

    //callbackFlow()
//    fun getUser(): Flow<String> = callbackFlow {
//        val callback = object : GetUserCallback {
//            override fun onNextValue(value: String) {
//                offer(value)
//            }
//
//            override fun onApiError(cause: Throwable) {
//                close(cause)
//            }
//
//            override fun onCompleted() {
//                close()
//            }
//        }
//        getUserApi.register(callback)
//        awaitClose { getUserApi.unregister(callback) }
//    }

    //Exceptions
    fun main() = runBlocking {
        val nums = (1..2).asFlow()
            .onEach { check(it < 2) }
        try {
            nums.collect { println(it) }
        } catch (e: Exception) {
            println("Caught exception: $e")
        }
    }

}