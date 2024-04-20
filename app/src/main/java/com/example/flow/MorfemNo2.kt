package com.example.flow

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.flow.databinding.FragmentMorfemNo1Binding
import com.example.flow.databinding.FragmentMorfemNo2Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MorfemNo2 : Fragment() {

    private  lateinit var binding: FragmentMorfemNo2Binding

    private fun correctAnwer(){
        lifecycleScope.launch {
            MediaPlayer.create(context, R.raw.drumrollwav).start()
            delay(6_000)
            MediaPlayer.create(context, R.raw.correct).start()
            childFragmentManager.beginTransaction().replace(R.id.question_shower, Correct()).commit()
            childFragmentManager.beginTransaction().replace(R.id.question_shower2, Correct()).commit()
            delay(2_000)
            fragmentManager?.beginTransaction()?.replace(R.id.media_layout, MenuMorfem())?.commit()
        }
    }

    private fun wrongAnwer(){
        lifecycleScope.launch {
            MediaPlayer.create(context, R.raw.drumrollwav).start()
            delay(6_000)
            MediaPlayer.create(context, R.raw.wrong).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_shower, Wrong())?.commit()
            fragmentManager?.beginTransaction()?.replace(R.id.question_shower2, Wrong())?.commit()
            delay(2_000)
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, MorfemNo2())?.commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMorfemNo2Binding.inflate(layoutInflater, container, false)

        binding.button1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.duri).start()
        }

        binding.button2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.durian).start()
        }

        binding.anwerBtn1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.durian).start()
            correctAnwer()
        }

        binding.audioBtn1.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.durian).start()
        }

        binding.anwerBtn2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.duri).start()
            wrongAnwer()
        }

        binding.audioBtn2.setOnClickListener {
            MediaPlayer.create(this.context, R.raw.duri).start()
        }


        return binding.root
    }

}