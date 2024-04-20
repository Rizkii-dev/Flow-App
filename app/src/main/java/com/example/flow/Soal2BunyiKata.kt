package com.example.flow

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.flow.databinding.FragmentSoal2BunyiKataBinding
import com.example.flow.databinding.FragmentSoalBunyiKataBinding

class Soal2BunyiKata : Fragment() {

    private  lateinit var binding: FragmentSoal2BunyiKataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSoal2BunyiKataBinding.inflate(layoutInflater, container, false)

        binding.backButton.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.media_layout, MenuPenghapusBunyi())?.commit()
        }

        binding.aButton.setOnClickListener {
            MediaPlayer.create(context, R.raw.pertanyaan_kursi_roda).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, Soal2BunyiKata1())?.commit()
        }

        binding.bButton.setOnClickListener {
            MediaPlayer.create(context, R.raw.pertanyaan_kursi_roda).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, Soal2BunyiKata2())?.commit()
        }

        binding.cButton.setOnClickListener {
            MediaPlayer.create(context, R.raw.pertanyaan_kursi_roda).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, Soal2BunyiKata3())?.commit()
        }

        return binding.root
    }

}