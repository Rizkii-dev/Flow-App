package com.example.flow

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.flow.databinding.FragmentNo1PencampuranKataBagianABinding
import com.example.flow.databinding.FragmentNo3PencampuranHurufBagianABinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class No1PencampuranKataBagianA : Fragment() {

    private  lateinit var binding: FragmentNo1PencampuranKataBagianABinding

    private fun correctAnwer(){
        lifecycleScope.launch {
            MediaPlayer.create(context, R.raw.drumrollwav).start()
            delay(6_000)
            MediaPlayer.create(context, R.raw.correct).start()
            childFragmentManager.beginTransaction().replace(R.id.question_shower, Correct()).commit()
            delay(2_000)
            fragmentManager?.beginTransaction()?.replace(R.id.media_layout, MenuPencampuranBunyiKata())?.commit()
        }
    }

    private fun wrongAnwer(){
        lifecycleScope.launch {
            MediaPlayer.create(context, R.raw.drumrollwav).start()
            delay(6_000)
            MediaPlayer.create(context, R.raw.wrong).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_shower, Wrong())?.commit()
            delay(2_000)
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, No1PencampuranKataBagianA())?.commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNo1PencampuranKataBagianABinding.inflate(layoutInflater, container, false)

        binding.anwerBtn1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.sikat_wc).start()
            wrongAnwer()
        }

        binding.audioBtn1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.sikat_wc).start()
        }

        binding.anwerBtn2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.sikat_gigi).start()
            correctAnwer()
        }

        binding.audioBtn2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.sikat_gigi).start()
        }

        binding.anwerBtn3.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.gosok_gigi).start()
            wrongAnwer()
        }

        binding.audioBtn3.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.gosok_gigi).start()
        }

        return binding.root
    }

}