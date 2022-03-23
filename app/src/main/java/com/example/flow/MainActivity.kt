package com.example.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flow()
    }

    fun getSequence(): Flow<Int> = flow {
        for (i in 1..3) {
            delay(100)
            emit(i)
        }
    }

    fun flow() = runBlocking {
        getSequence().collect {
            Log.d("my flow", it.toString())
        }
    }

//    fun getSequence(): Flow<Int> = flow {
//        for (i in 1..3) {
//            delay(100)
//            println("Emit $i")
//            emit(i)
//        }
//    }
//
//    fun main() = runBlocking {
//        val f = getSequence()
//        println("Start to collect")
//        f.collect { value ->
//            println("Collected $value")
//        }
//    }


//    fun main() = runBlocking {
//        val f = flowOf(1, 2, 3)
//        println("1. Start to collect")
//        f.collect { value ->
//            println("Collected $value")
//        }
//        println("2. Start to collect")
//        f.collect { value ->
//            println("Collected $value")
//        }
//    }

//    fun main() = runBlocking {
//        (1..3).asFlow()
//            .map { "Hello $it" }
//            .collect { println(it) }
//    }

//    fun main() = runBlocking {
//        (1..10).asFlow()
//            .filterNot { it % 2 == 0 }
//            .collect { println(it) }
//    }

//    fun main() = runBlocking {
//        (1..10).asFlow()
//            .transform {
//                if (it % 2 == 0) {
//                    emit(it)
//                    emit(it)
//                }
//            }
//            .collect { println(it) }
//    }

//    fun main() = runBlocking {
//
//        (1..5).asFlow()
//            .transform {
//                emit(it * 2)
//                delay(100)
//                emit("emit $it")
//            }
//            .collect { println(it) }
//    }

    fun reduce() = runBlocking {
        val sum = (1..5).asFlow()
            .reduce { accumulator, value ->
                println("accumulator=$accumulator, value=$value")
                accumulator + value
            }
        println("Sum of 1..3 is $sum")
    }

    fun fold() = runBlocking {
        val result = (1..5).asFlow()
            .fold(100) { accumulator, value ->
                println("accumulator=$accumulator, value=$value")
                accumulator + value
            }
        println("Result is $result")
    }

//    fun double(value: Int) = flow {
//        emit(value)
//        delay(100)
//        emit(value)
//    }
//
//    fun flatMapConcat() = runBlocking {
//        (1..3).asFlow()
//            .flatMapConcat { double(it) }
//            .collect { println(it) }
//    }


    fun double(value: Int) = flow {
        emit(value)
        delay(100)
        emit(value)
    }

    fun flatMapMerge() = runBlocking {
        (1..3).asFlow()
            .flatMapMerge { double(it) }
            .collect { println(it) }
    }


}