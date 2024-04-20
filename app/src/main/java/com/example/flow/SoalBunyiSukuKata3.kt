package com.example.flow

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.flow.databinding.FragmentSoalBunyiSukuKata2Binding
import com.example.flow.databinding.FragmentSoalBunyiSukuKata3Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SoalBunyiSukuKata3 : Fragment() {

    private  lateinit var binding: FragmentSoalBunyiSukuKata3Binding

    private fun correctAnwer(){
        lifecycleScope.launch {
            MediaPlayer.create(context, R.raw.drumrollwav).start()
            delay(6_000)
            MediaPlayer.create(context, R.raw.correct).start()
            childFragmentManager.beginTransaction().replace(R.id.question_shower, Correct()).commit()
            delay(2_000)
            fragmentManager?.beginTransaction()?.replace(R.id.media_layout, MenuBunyiSukuKata())?.commit()
        }
    }

    private fun wrongAnwer(){
        lifecycleScope.launch {
            MediaPlayer.create(context, R.raw.drumrollwav).start()
            delay(6_000)
            MediaPlayer.create(context, R.raw.wrong).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_shower, Wrong())?.commit()
            delay(2_000)
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, SoalBunyiSukuKata3())?.commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSoalBunyiSukuKata3Binding.inflate(layoutInflater, container, false)

        binding.anwerBtn1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.piring).start()
            wrongAnwer()
        }

        binding.audioBtn1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.piring).start()
        }

        binding.anwerBtn2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.ring).start()
            correctAnwer()
        }

        binding.audioBtn2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.ring).start()
        }

        binding.anwerBtn3.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.pir).start()
            wrongAnwer()
        }

        binding.audioBtn3.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.pir).start()
        }

        return binding.root
    }

}