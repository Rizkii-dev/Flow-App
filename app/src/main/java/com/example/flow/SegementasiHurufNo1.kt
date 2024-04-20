package com.example.flow

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.flow.databinding.FragmentNo1PencampuranHurufBagianABinding
import com.example.flow.databinding.FragmentSegementasiHurufNo1Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SegementasiHurufNo1 : Fragment() {

    private  lateinit var binding: FragmentSegementasiHurufNo1Binding

    private fun correctAnwer(){
        lifecycleScope.launch {
            MediaPlayer.create(context, R.raw.drumrollwav).start()
            delay(6_000)
            MediaPlayer.create(context, R.raw.correct).start()
            childFragmentManager.beginTransaction().replace(R.id.question_shower, Correct()).commit()
            delay(2_000)
            fragmentManager?.beginTransaction()?.replace(R.id.media_layout, MenuSegmentasiHuruf())?.commit()
        }
    }

    private fun wrongAnwer(){
        lifecycleScope.launch {
            MediaPlayer.create(context, R.raw.drumrollwav).start()
            delay(6_000)
            MediaPlayer.create(context, R.raw.wrong).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_shower, Wrong())?.commit()
            delay(2_000)
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, SegementasiHurufNo1())?.commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSegementasiHurufNo1Binding.inflate(layoutInflater, container, false)

        binding.audioQuestion.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.j_u_s).start()
        }

        binding.anwerBtn1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no1).start()
            wrongAnwer()
        }

        binding.audioBtn1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no1).start()
        }

        binding.anwerBtn2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no2).start()
            wrongAnwer()
        }

        binding.audioBtn2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no2).start()
        }

        binding.anwerBtn3.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no3).start()
            correctAnwer()
        }

        binding.audioBtn3.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.no3).start()
        }

        return binding.root
    }

}