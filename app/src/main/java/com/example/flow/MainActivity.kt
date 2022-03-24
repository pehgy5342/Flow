package com.example.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main()
    }

    //基本Flow範例
    fun getSequence(): Flow<Int> = flow {
        for (i in 1..3) {
            delay(100)
            emit(i) //將結果送到flow裡
        }
    }

    fun main() = runBlocking {
        getSequence()
            .collect { value -> //接收emit()發送出來的值
                println(value)
            }
    }

    //flow()
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

    //asFlow()
//    fun main() = runBlocking {
//        val f = (1..3).asFlow()
//        println("1. Start to collect")
//        f.collect { value ->
//            println("Collected $value")
//        }
//        println("2. Start to collect")
//        f.collect { value ->
//            println("Collected $value")
//        }
//    }


    //flowOf()
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


}