package com.learnpainless.speechtextrecyclerview

import android.os.Build
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_item_speech.view.*

class SpeechAdapter (private val tts: TextToSpeech): RecyclerView.Adapter<SpeechAdapter.SpeechViewHolder>() {
    var list: ArrayList<String> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class SpeechViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        init {
            itemView.btnPlay.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(list[adapterPosition], TextToSpeech.QUEUE_FLUSH, null, list[adapterPosition])
                }
                else {
                    tts.speak(list[adapterPosition], TextToSpeech.QUEUE_FLUSH, null)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeechViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_speech, parent, false)
        return SpeechViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SpeechViewHolder, position: Int) {
        holder.itemView.name.text = list[position]
    }
}