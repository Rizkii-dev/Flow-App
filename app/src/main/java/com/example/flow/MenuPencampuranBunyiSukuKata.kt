package com.example.flow

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.flow.databinding.FragmentMenuPencampuranBunyiKataBinding
import com.example.flow.databinding.FragmentMenuPencampuranBunyiSukuKataBinding

class MenuPencampuranBunyiSukuKata : Fragment() {

    private  lateinit var binding: FragmentMenuPencampuranBunyiSukuKataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuPencampuranBunyiSukuKataBinding.inflate(layoutInflater, container, false)

        binding.backButton.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.media_layout, Menu())?.commit()
        }

        binding.soal1.setOnClickListener {
            MediaPlayer.create(context, R.raw.nomor1_pencampuran_bunyi_suku_kata).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, No1PencampuranSukuKata())?.commit()
        }

        binding.soal2.setOnClickListener {
            MediaPlayer.create(context, R.raw.nomor2_pencampuran_bunyi_suku_kata).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, No2PencampuranSukuKata())?.commit()
        }

        binding.soal3.setOnClickListener {
            MediaPlayer.create(context, R.raw.nomor3_pencampuran_bunyi_suku_kata).start()
            fragmentManager?.beginTransaction()?.replace(R.id.question_layout, No3PencampuranSukuKata())?.commit()
        }

        return binding.root
    }

}