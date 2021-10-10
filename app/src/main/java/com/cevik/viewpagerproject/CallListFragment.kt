package com.cevik.viewpagerproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cevik.viewpagerproject.data.DataGenerator


class CallListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView=inflater.inflate(R.layout.fragment_call_list, container, false )
        val rvView=rootView.findViewById<RecyclerView>(R.id.rv)
        rvView.layoutManager=LinearLayoutManager(rootView.context,RecyclerView.VERTICAL,false)

        val adapter=CallListAdapter()
        adapter.callList=DataGenerator().generate(10)

        rvView.adapter=adapter


        return rootView
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CallListFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}