package com.example.ppapb_tugas9_buttonnavigation_zefanyadiegoforlandicco

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.navigation.fragment.findNavController
import com.example.ppapb_tugas9_buttonnavigation_zefanyadiegoforlandicco.databinding.FragmentPickerBinding

class PickerFragment : Fragment() {
    // Kelas PickerFragment bertindak sebagai fragmen yang memungkinkan pengguna memilih jenis tiket.

    private lateinit var binding: FragmentPickerBinding
    private var selectedItem: String? = null

    //Metode onCreateView() dipanggil saat tata letak fragmen perlu dibuat.//
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inisialisasi binding untuk menghubungkan tata letak XML dengan kode Kotlin.
        binding = FragmentPickerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    //Metode onViewCreated() dipanggil setelah tampilan fragmen telah selesai dibuat.//
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            // Menyiapkan daftar item yang akan ditampilkan dalam spinnerTicket.
            val spinnerItems = arrayOf("First Class Tiket", "Business Class Tiket", "Economy Class Tiket")
            // Membuat adapter untuk spinnerTicket.
            val ticketAdapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, spinnerItems)
            // Mengatur adapter untuk spinnerTicket.
            spinnerTicket.setAdapter(ticketAdapter)

            // Menetapkan onTouchListener untuk spinnerTicket.
            spinnerTicket.setOnTouchListener { v, event ->
                // Memeriksa apakah aksi sentuhan adalah ACTION_UP (ketika pengguna mengangkat jari dari layar).
                if (event.action == MotionEvent.ACTION_UP) {
                    // Mendapatkan ikon kanan (drawable) dari objek AutoCompleteTextView (spinnerTicket).
                    val rightDrawable = (v as AutoCompleteTextView).compoundDrawables[2]
                    // Memeriksa apakah sentuhan pengguna terjadi di dalam area ikon drop-down.
                    if (event.rawX >= (rightDrawable.bounds.left - v.right)) {
                        // Menampilkan daftar item spinner saat ikon drop-down diklik.
                        spinnerTicket.showDropDown()
                        // Mengembalikan nilai true untuk menunjukkan bahwa sentuhan telah ditangani.
                        return@setOnTouchListener true
                    }
                }
                // Mengembalikan nilai false jika aksi sentuhan bukan ACTION_UP atau tidak berada di dalam area ikon drop-down.
                false
            }

            // Menetapkan onItemClickListener untuk spinnerTicket.
            spinnerTicket.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                // Menyimpan item yang dipilih dari spinnerTicket ke dalam variabel selectedItem.
                selectedItem = ticketAdapter.getItem(position).toString()
            }

            // Menetapkan OnClickListener untuk elemen btnBuy.
            btnBuy.setOnClickListener {
                // Menyimpan data terpilih dalam LiveData dengan kunci "ticket".
                findNavController().apply {
                    previousBackStackEntry?.
                    savedStateHandle?.set("ticket", selectedItem ?: "Tiket")
                }.navigateUp() // Kembali ke tata letak sebelumnya.
            }
        }
    }
}
