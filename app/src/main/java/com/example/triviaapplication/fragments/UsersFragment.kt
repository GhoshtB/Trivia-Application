package com.example.triviaapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaapplication.MainActivity
import com.example.triviaapplication.R
import com.example.triviaapplication.adapter.UserAdapter
import com.example.triviaapplication.model.User


class UsersFragment : Fragment() {

    lateinit var rvUsers:RecyclerView
    lateinit var tvSplash:TextView
    val userAdapter =UserAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_users, container, false)
        rvUsers=view.findViewById(R.id.rvUsers)
        tvSplash=view.findViewById(R.id.tvSplash)

        rvUsers.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(activity!!.applicationContext)
            adapter=userAdapter
        }
        (activity as MainActivity).userViewmodel.callDataBase()

        (activity as MainActivity).userViewmodel.userDatas.observe(this.viewLifecycleOwner, Observer{
            data->
            print(data.toString())
            userAdapter.setList(data)
        })

        tvSplash.setOnClickListener {
            childFragmentManager.popBackStack()
        }
        return view
    }

}