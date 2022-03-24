package com.example.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class FlatteningFlowsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flattening_flows)

        main()
    }

    //flatMapConcat()
//    fun double(value: Int) = flow {
//        emit(value)
//        delay(100)
//        emit(value)
//    }
//
//    fun main() = runBlocking {
//        (1..3).asFlow()
//            .flatMapConcat { double(it) }
//            .collect { println(it) }
//    }

    //flatMapMerge()
//    fun double(value: Int) = flow {
//        emit(value)
//        delay(100)
//        emit(value)
//    }
//
//    fun main() = runBlocking {
//        (1..3).asFlow()
//            .flatMapMerge { double(it) }
//            .collect { println(it) }
//    }


    //flatMapLatest()
    fun currTime() = System.currentTimeMillis()

    var start: Long = 0

    fun main() = runBlocking {

        (1..5).asFlow()
            .onStart { start = currTime() }
            .onEach { delay(100) }
            .flatMapLatest {
                flow {
                    emit("$it: First")
                    delay(500)
                    emit("$it: Second")
                }
            }
            .collect {
                println("$it at ${System.currentTimeMillis() - start} ms from start")
            }
    }

}