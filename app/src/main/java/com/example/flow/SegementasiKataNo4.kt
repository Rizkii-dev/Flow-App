package com.example.flow

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.flow.databinding.FragmentSegementasiKataNo1Binding
import com.example.flow.databinding.FragmentSegementasiKataNo4Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SegementasiKataNo4 : Fragment() {

    private  lateinit var binding: FragmentSegementasiKataNo4Binding

    private fun correctAnwer(){
        lifecycleScope.launch {
            MediaPlayer.create(context, R.raw.drumrollwav).start()
            delay(6_000)
            MediaPlayer.create(context, R.raw.correct).start()
            childFragmentManager.beginTransaction().replace(R.id.question_shower, Correct()).commit()
            delay(2_000)
            fragmentManager?.beginTransaction()?.replace(R.id.media_layout, MenuSegmentasiKata())?.commit()
        }
    }

    private fun wrongAnwer(){
        lifecycleScope.launch {
            MediaPlayer.create(context, R.raw.drumrollwav).start()
            delay(6_000)
            MediaPlayer.create(context, R.raw.wrong).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_shower, Wrong())?.commit()
            delay(2_000)
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, SegementasiKataNo4())?.commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSegementasiKataNo4Binding.inflate(layoutInflater, container, false)

        binding.audioQuestion.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.adik_tidur_di_kamar).start()
        }

        binding.anwerBtn1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no1).start()
            wrongAnwer()
        }

        binding.audioBtn1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no1).start()
        }

        binding.anwerBtn2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no3).start()
            wrongAnwer()
        }

        binding.audioBtn2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no3).start()
        }

        binding.anwerBtn3.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no4).start()
            correctAnwer()
        }

        binding.audioBtn3.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no4).start()
        }

        return binding.root
    }

}