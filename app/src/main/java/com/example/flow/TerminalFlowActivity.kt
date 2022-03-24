package com.example.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

class TerminalFlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terminal_flow)

        main()
    }

    //collect()


    //reduce()
    fun main() = runBlocking {
        val sum = (1..5).asFlow()
            .reduce { accumulator, value ->
                println("accumulator=$accumulator, value=$value")
                accumulator + value
            }
        println("Sum of 1..3 is $sum")
    }

    //fold()
//    fun main() = runBlocking {
//        val result = (1..5).asFlow()
//            .fold(100) { accumulator, value ->
//                println("accumulator=$accumulator, value=$value")
//                accumulator + value
//            }
//        println("Result is $result")
//    }

    //single()
}