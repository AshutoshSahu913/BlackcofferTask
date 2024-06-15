package com.example.blackcoffertask.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blackcoffertask.Adapters.ServicesAdapter
import com.example.blackcoffertask.Model.PersonalModel
import com.example.blackcoffertask.R
import com.example.blackcoffertask.databinding.FragmentServicesBinding

class Servicesfragment : Fragment() {
    lateinit var binding: FragmentServicesBinding
    lateinit var adapter: ServicesAdapter
    var servicesList = ArrayList<PersonalModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentServicesBinding.inflate(layoutInflater, container, false)

        setUpServicesRecyclerView()
        return binding.root
    }


    private fun setUpServicesRecyclerView() {
        servicesList.add(
            PersonalModel(
                R.drawable.img1,
                "Michael Murphy",
                "San Francisco, within 1 Km",
                "Friendship",
                "Coffee",
                "Hangout",
                "Hi community! I am open to new connections",
                PersonalModel.Status.ACCEPTED
            )
        )
        servicesList.add(
            PersonalModel(
                R.drawable.img2,
                "Jessica Smith",
                "New York, within 2 Km",
                "Networking",
                "Tea",
                "Study",
                "Looking to expand my professional network.",
                PersonalModel.Status.PENDING
            )
        )
        servicesList.add(
            PersonalModel(
                R.drawable.img3,
                "John Doe",
                "Los Angeles, within 3 Km",
                "Friendship",
                "Smoothie",
                "Sports",
                "Let's catch up for some sports activities.",
                PersonalModel.Status.INVITED
            )
        )
        servicesList.add(
            PersonalModel(
                R.drawable.img4,
                "Emily Johnson",
                "Chicago, within 1 Km",
                "Hangout",
                "Juice",
                "Movie",
                "Looking for someone to watch movies with.",
                PersonalModel.Status.PENDING
            )
        )
        servicesList.add(
            PersonalModel(
                R.drawable.img5,
                "David Brown",
                "Miami, within 5 Km",
                "Networking",
                "Water",
                "Gym",
                "Anyone up for a workout session?",
                PersonalModel.Status.ACCEPTED
            )
        )
        adapter = ServicesAdapter(servicesList = servicesList, context = requireContext())
        binding.rvServices.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvServices.adapter = adapter
    }

}