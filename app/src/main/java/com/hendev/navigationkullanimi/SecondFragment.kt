package com.hendev.navigationkullanimi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val args = SecondFragmentArgs.fromBundle(it)

            val uid = args.kullaniciAdi
            val no = args.number
            val resit = args.resit

            txtFrg2id.text = uid
            txtFrg2Number.text = no.toString()

            if (resit){
                txtFrg2Mail.text = "Kullanıcı Sözleşmesini İmzaladı ${args.strIki} ve ${args.strUc}"
            }else{
                txtFrg2Mail.text = "Yaşınız Uygun Değil Uygulama Kapatılacak"
            }
        }

        btnFrg2Go.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}