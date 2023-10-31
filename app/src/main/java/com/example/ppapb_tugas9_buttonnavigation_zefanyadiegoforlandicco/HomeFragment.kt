package com.example.ppapb_tugas9_buttonnavigation_zefanyadiegoforlandicco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment : Fragment() {
    //Kelas HomeFragment adalah sebuah fragmen yang digunakan untuk menampilkan konten di halaman beranda.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Metode onCreateView() digunakan untuk menginisialisasi tata letak fragmen.

        // Mengembalikan tata letak fragmen yang telah diinisialisasi dari file XML 'fragment_home'.
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}
