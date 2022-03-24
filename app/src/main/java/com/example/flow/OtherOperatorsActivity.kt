package com.example.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Math.log

class OtherOperatorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_operators)

        main()
    }

    //onCompletion()
    //這邊刻意用成異常後輸出
//    fun main() = runBlocking {
//        (1..5).asFlow()
//            .onCompletion { e -> println("Completion: $e") }
//            .collect {
//                println("Value is $it")
//                if (it == 3) {
//                    throw Exception("Error")
//                }
//            }
//    }

    //onEach()
//    fun main() = runBlocking {
//        ('a'..'c').asFlow()
//            .onEach { println("Check: $it") }
//            .map { it.toInt() }
//            .collect {
//                println("Value is $it")
//            }
//    }

    //catch()
//    fun main() = runBlocking {
//        (1..5).asFlow()
//            .onEach { if (it > 3) throw Exception("Value should not larger than 3") }
//            .catch { e -> println("Caught exception: $e") }
//            .onCompletion { println("Completion") }
//            .collect { println("Value is $it") }
//    }

    //take
//    fun main() = runBlocking {
//
//        (1..5).asFlow()
//            .take(2)
//            .collect { println(it) }
//    }

    //filter
//    val demoFlow = flow {
//        listOf(9, 5, 2, 7).forEach {
//            emit(it)
//        }
//    }
//
//    fun main() {
//        runBlocking {
//            demoFlow.filter {
//                it % 2 == 1
//            }.collect {
//                println(it)
//            }
//        }
//    }
    //buffer()
    val demoFlow = flow {
        listOf(9, 5, 2, 7).forEach {
            delay(1000)
            emit(it)
        }
    }

    fun main() {
        runBlocking {
            launch(Dispatchers.IO) {
                for(i in 1..8) {
                    delay(1000)
                    println("$i 秒経過")

                }
            }
            demoFlow
                .buffer()
                .collect {
                    delay(1000)
                    println("collect $it")
                }
        }
    }
}