package com.example.ppapb_tugas9_buttonnavigation_zefanyadiegoforlandicco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ppapb_tugas9_buttonnavigation_zefanyadiegoforlandicco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Kelas MainActivity berfungsi sebagai aktivitas utama dalam aplikasi ini.

    private lateinit var binding: ActivityMainBinding

    //Metode onCreate() digunakan saat pembuatan aktivitas ini.Ini merupakan awal dari eksekusi aktivitas.//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Melakukan inisialisasi terhadap binding guna mengaitkan tata letak XML dengan kode Kotlin.
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Menetapkan tata letak utama aktivitas dengan menggunakan layout root yang terkandung dalam binding.
        setContentView(binding.root)

        // Memanfaatkan binding untuk memperoleh referensi ke elemen-elemen antarmuka pengguna dari tata letak.
        with(binding) {
            // Mencari NavController untuk mengontrol navigasi antara fragmen.
            val navController = findNavController(R.id.nav_host_fragment)

            // Mengkonfigurasi BottomNavigationView agar dapat berinteraksi dengan NavController.
            bottonNavigationView.setupWithNavController(navController)
        }
    }
}
