package com.example.ppapb_tugas9_buttonnavigation_zefanyadiegoforlandicco

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ppapb_tugas9_buttonnavigation_zefanyadiegoforlandicco.databinding.FragmentTicketBinding

class TicketFragment : Fragment() {
    // Kelas TicketFragment berperan sebagai fragmen yang memungkinkan pengguna untuk memilih tiket.

    private lateinit var binding: FragmentTicketBinding

    //Metode onCreateView() akan dipanggil saat tata letak fragmen pertama kali dibuat.//
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inisialisasi binding untuk menghubungkan tata letak dengan fragmen menggunakan data binding.
        binding = FragmentTicketBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    //Metode onViewCreated() akan dipanggil setelah tata letak fragmen telah selesai dibuat.//
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            // Membuat tindakan (action) untuk tombol btnBuyticket.
            val action = TicketFragmentDirections.actionTicketFragmentToOrderFragment()
            btnBuyticketShutup.setOnClickListener {
                // Melakukan navigasi ke fragmen OrderFragment saat tombol diklik.
                findNavController().navigate(action)
            }
        }
    }
}
