package com.example.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class ComposingMultipleFlowsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_composing_multiple_flows)
        main()
    }

    //zip()
    fun main() = runBlocking {
        val nums = (1..3).asFlow()
            .onEach { delay(29) }
        val strs = flowOf('a', 'b', 'c', 'd')
            .onEach { delay(37) }
        nums.zip(strs) { a, b -> "$a -> $b" }
            .collect { println(it) }
    }

    //combine()
//    fun main() = runBlocking {
//        val nums = (1..3).asFlow()
//            .onEach { delay(29) }
//        val strs = flowOf('a', 'b', 'c', 'd')
//            .onEach { delay(37) }
//        nums.combine(strs) { a, b -> "$a -> $b" }
//            .collect { println(it) }
//    }

}