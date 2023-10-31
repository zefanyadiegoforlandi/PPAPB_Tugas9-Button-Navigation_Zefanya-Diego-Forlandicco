package com.example.ppapb_tugas9_buttonnavigation_zefanyadiegoforlandicco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ppapb_tugas9_buttonnavigation_zefanyadiegoforlandicco.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding

    //Metode onCreateView() dipanggil saat tata letak fragmen dibuat.Ini adalah langkah awal dalam menciptakan tampilan fragmen.//
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Melakukan inisialisasi terhadap binding untuk menghubungkan tata letak XML dengan kode Kotlin.
        binding = FragmentOrderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    //Metode onViewCreated() dipanggil setelah tampilan fragmen selesai dibuat.Ini adalah tempat dimana interaksi dan pengamatan elemen tampilan dilakukan.//
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            // Menetapkan OnClickListener untuk elemen JnsTicket.
            JnsTicket.setOnClickListener {
                // Membuat objek aksi untuk berpindah dari OrderFragment ke PickerFragment.
                val action = OrderFragmentDirections.actionOrderFragmentToPickerFragment()

                // Melakukan navigasi ke PickerFragment.
                findNavController().navigate(action)
            }

            // Mengamati perubahan data dalam LiveData dengan kunci "ticket".
            findNavController().currentBackStackEntry?.
            savedStateHandle?.getLiveData<String>("ticket")?.observe(viewLifecycleOwner) {
                    res -> JnsTicket.setText(res) // Mengatur teks pada JnsTicket dengan data dari LiveData.
            }

            // Menetapkan OnClickListener untuk elemen btnBuyticket.
            btnBuy.setOnClickListener {
                // Navigasi kembali ke tata letak sebelumnya.
                findNavController().navigateUp()
            }
        }
    }
}
