package com.example.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class FlatteningFlowsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flattening_flows)

        main()
    }

    //flatMapConcat()
    fun double(value: Int) = flow {
        emit(value)
        delay(100)
        emit(value)
    }

    fun main() = runBlocking {
        (1..3).asFlow()
            .flatMapConcat { double(it) }
            .collect { println(it) }
    }

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

}