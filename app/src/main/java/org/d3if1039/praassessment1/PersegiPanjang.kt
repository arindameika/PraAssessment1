package org.d3if1039.praassessment1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.d3if1039.praassessment1.databinding.FragmentPersegiPanjangBinding

private const val LUAS = "luas"
private const val KELILING = "keliling"

class PersegiPanjang : Fragment() {

    private lateinit var binding: FragmentPersegiPanjangBinding
    private var luas = 0.0
    private var keliling = 0.0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_persegi_panjang, container, false)
        binding.btHitung.setOnClickListener {
            cekInputan()
        }
        binding.btShare.setOnClickListener {
            Toast.makeText(activity, "Hasil Berhasil Dikirim", Toast.LENGTH_SHORT).show()
        }
        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun cekInputan() {
        when{
            binding.tfPanjang.text.isEmpty()->
                Toast.makeText(activity,"Masukkan Panjang terlebih dahulu", Toast.LENGTH_SHORT).show()
            binding.tfLebar.text.isEmpty()->
                Toast.makeText(activity, "Masukkan Lebar Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            else ->
                hasilHitungan()
        }
    }

    private fun hasilHitungan(){
        var panjang = binding.tfPanjang.text.toString().toDouble()
        var lebar = binding.tfLebar.text.toString().toDouble()

        luas = panjang * lebar
        keliling = 2 * (panjang + lebar)

        binding.hasilLuasPP.text = luas.toString()
        binding.hasilKelPP.text = keliling.toString()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble(LUAS, luas)
        outState.putDouble(KELILING, keliling)
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        if (savedInstanceState!=null){
            luas = savedInstanceState.getDouble(LUAS)
            keliling = savedInstanceState.getDouble(KELILING)

            binding.hasilLuasPP.text = luas.toString()
            binding.hasilKelPP.text = keliling.toString()
        }
        super.onViewStateRestored(savedInstanceState)
    }
}
