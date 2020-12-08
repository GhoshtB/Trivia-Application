package com.example.triviaapplication.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.triviaapplication.MainActivity
import com.example.triviaapplication.R
import com.example.triviaapplication.databinding.FragmentSplashBinding
import com.example.triviaapplication.launchFragment
import com.example.triviaapplication.model.User
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class SplashFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentSplashBinding
    var colors =""
    var players =""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view= inflater.inflate(R.layout.fragment_splash, container, false)
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_splash, container, false)
binding.users= User("","","","")
        setListener()

        Handler().postDelayed({
            binding.tvSplash.visibility = View.GONE
            binding.llName.visibility = View.VISIBLE
        }, 3000)


//        view.findViewById(rgcricketer.checkedRadioButtonId)
        return binding.root
    }

    private fun setListener() {

        binding.rdGreen.setOnClickListener {
            colors+=" Green"
         }
        binding.rdWhite.setOnClickListener {
            colors+=" White"
        }
        binding.rdOrange.setOnClickListener {
            colors+=" Orange"
         }
        binding.rdYellow.setOnClickListener {
            colors+=" Yellow"
        }

        binding.btnName.setOnClickListener {
            if (!binding.etName.text.toString().isNullOrEmpty()) {
                binding.llName.visibility = GONE
                binding.llcricketer.visibility = VISIBLE
                binding.users!!.name=binding.etName.text.toString()
            }else{
                showToast("Name is Empty")
            }
        }

        binding.btnBPlayer.setOnClickListener {
            if (binding.rdAdam.isChecked || binding.rdJacques.isChecked || binding.rdVirat.isChecked || binding.rdSachin.isChecked){
                binding.llcricketer.visibility = GONE
                binding.llflag.visibility = VISIBLE
//                binding.users!!.player=binding.root.findViewById<TextView>(binding.rgcricketer.id).text.toString()
                if (binding.rdSachin.isChecked){
                    binding.users!!.player="Sachin Tendulkar"
                    players="Sachin Tendulkar"
                }else if (binding.rdVirat.isChecked){
                    binding.users!!.player="Virat Kolli"
                    players="Virat Kolli"

                }else if (binding.rdAdam.isChecked){
                    binding.users!!.player="Adam Gilchirst"
                    players="Adam Gilchirst"

                }else if (binding.rdJacques.isChecked){
                    binding.users!!.player="Jacques Kallis"
                    players="Jacques Kallis"

                }
            }else{
                showToast("Select Cricketer")
            }
        }


        binding.btnflag.setOnClickListener {
            if (binding.rdGreen.isChecked || binding.rdOrange.isChecked || binding.rdWhite.isChecked || binding.rdYellow.isChecked) {
                binding.llflag.visibility = GONE
                binding.llHISTORY.visibility = VISIBLE
            }else{
                showToast("Select More Than One Color")
            }

/*colors=""
            if (binding.rdGreen.isChecked){
                colors+=" Green"
            }else if (binding.rdWhite.isChecked){
                colors+=" White"
            }else if (binding.rdYellow.isChecked){
                colors+=" Yellow"
            }else if (binding.rdOrange.isChecked){
                colors+=" Orange"
            }*/
            binding.users!!.flagColor=colors
            print("flagColor${binding.users.toString()}")

            binding.tvName.text= "Name : ${binding.etName.text.toString()}"
            binding.tvcricketer.text= "Who is the best cricketer in the world? : ${players}"
            binding.tvflag.text= "What are the colors in the national flag? : ${colors.replace(" ",",")}"

            callUserDb()
        }

        binding.btnFINISH.setOnClickListener {
            binding.llHISTORY.visibility = GONE
            binding.llName.visibility = VISIBLE
        }
        binding.btnHISTORY.setOnClickListener {
            (activity as MainActivity).launchFragment(UsersFragment(),R.id.flContainer)
        }
    }

    private fun callUserDb() {


        (activity as MainActivity).userViewmodel.insertUsers(User(name = binding.users!!.name,player = binding.users!!.player,flagColor = binding.users!!.flagColor,time = getDateTime()!!))
    }

    private fun showToast(s: String) {
        Toast.makeText(activity,s,Toast.LENGTH_SHORT).show()
    }

fun setPlayers(flag:Int){
    binding.users!!.player=""
    if (flag==0){
        binding.users!!.player="Sachin Tendulkar"
    }else if (flag==1){
        binding.users!!.player="Virat Kolli"

    }else if (flag==2){
        binding.users!!.player="Adam Gilchirst"

    }else if (flag==3){
        binding.users!!.player="Jacques Kallis"

    }
}

    private fun getDateTime(): String? {
        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = Date()
        return dateFormat.format(date)
    }

    fun callFunction(){
        colors=""
        if (binding.rdGreen.isChecked){
            colors+=" Green"
        }else if (binding.rdWhite.isChecked){
            colors+=" White"
        }else if (binding.rdYellow.isChecked){
            colors+=" Yellow"
        }else if (binding.rdOrange.isChecked){
            colors+=" Orange"
        }
    }

}