package com.example.ppapb_tugas9_buttonnavigation_zefanyadiegoforlandicco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ProfileFragment : Fragment() {
    // Kelas ProfileFragment adalah fragmen yang berfungsi untuk menampilkan profil pengguna.

    //Metode ini dipanggil saat tata letak fragmen dibuat.//
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Mengembalikan tata letak untuk fragmen.
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}
