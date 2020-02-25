package org.d3if1039.praassessment1


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import org.d3if1039.praassessment1.databinding.FragmentSegitigaBinding
import kotlin.math.pow
import kotlin.math.sqrt

private const val LUAS = "luas"
private const val KELILING = "keliling"

class Segitiga : Fragment() {

    private lateinit var binding: FragmentSegitigaBinding
    private var luas = 0.0
    private var keliling = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_segitiga, container, false)
        binding.btHitung.setOnClickListener {

        }
        
        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun cekInputan() {
        when{
            binding.tfAlas.text.isEmpty()->
                Toast.makeText(activity,"Masukkan Alas terlebih dahulu", Toast.LENGTH_SHORT).show()
            binding.tfTinggi.text.isEmpty()->
                Toast.makeText(activity, "Masukkan Tinggi Terlebih Dahulu", Toast.LENGTH_SHORT).show()
            else ->
                hasilHitungan()
        }
    }

    private fun hasilHitungan(){
        var alas = binding.tfAlas.text.toString().toDouble()
        var tinggi = binding.tfTinggi.text.toString().toDouble()
        var sisiMiring = sqrt(alas.pow(2) + tinggi.pow(2))

        luas = (alas * tinggi)/2
        keliling = alas + tinggi +sisiMiring

        binding.hasilLuasSgt.text = luas.toString()
        binding.hasilKelSgt.text = keliling.toString()

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

            binding.hasilLuasSgt.text = luas.toString()
            binding.hasilKelSgt.text = keliling.toString()
        }
        super.onViewStateRestored(savedInstanceState)
    }

}
