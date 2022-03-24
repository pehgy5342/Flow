package com.example.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking


class IntermediateFlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intermediate_flow)

        main()
    }

    //map
    fun main() = runBlocking {
        (1..3).asFlow()
            .map { "Hello $it" }
            .collect { println(it) }
    }

    //filter()
//    fun main() = runBlocking {
//        (1..10).asFlow()
//            .filter { it % 2 == 0 }
//            .collect { println(it) }
//    }


    //filterNot()
//    fun main() = runBlocking {
//        (1..10).asFlow()
//            .filterNot { it % 2 == 0 }
//            .collect { println(it) }
//    }


    //transform()
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

}