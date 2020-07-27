package com.learnpainless.speechtextrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tts = TextToSpeech(this) {
            Log.i("MainActivity", "onCreate: $it")
        }
        tts.language = Locale.US
        val adapter = SpeechAdapter(tts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.list = arrayListOf(
            "Apple",
            "Avocados",
            "Bananas",
            "Blueberries",
            "Cherries",
            "Clementine",
            "Cucumbers",
            "Grapes",
            "Guava",
            "Mango",
            "Orange",
            "Pineapple"
        )
    }
}