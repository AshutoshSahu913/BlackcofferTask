package com.example.blackcoffertask.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blackcoffertask.Adapters.PersonalAdapter
import com.example.blackcoffertask.Model.PersonalModel
import com.example.blackcoffertask.Model.PersonalModel.Status
import com.example.blackcoffertask.R
import com.example.blackcoffertask.databinding.FragmentPersonalBinding

class PersonalFragment : Fragment() {

    lateinit var binding: FragmentPersonalBinding
    var productList = ArrayList<PersonalModel>()
    lateinit var adapter: PersonalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPersonalBinding.inflate(inflater, container, false)
        setUpPersonalRecyclerView()
        return binding.root
    }

    private fun setUpPersonalRecyclerView() {
        productList.add(
            PersonalModel(
                R.drawable.img1,
                "Michael Murphy",
                "San Francisco, within 1 Km",
                "Friendship",
                "Coffee",
                "Hangout",
                "Hi community! I am open to new connections",
                Status.ACCEPTED
            )
        )
        productList.add(
            PersonalModel(
                R.drawable.img2,
                "Jessica Smith",
                "New York, within 2 Km",
                "Networking",
                "Tea",
                "Study",
                "Looking to expand my professional network.",
                Status.PENDING
            )
        )
        productList.add(
            PersonalModel(
                R.drawable.img3,
                "John Doe",
                "Los Angeles, within 3 Km",
                "Friendship",
                "Smoothie",
                "Sports",
                "Let's catch up for some sports activities.",
                Status.INVITED
            )
        )
        productList.add(
            PersonalModel(
                R.drawable.img4,
                "Emily Johnson",
                "Chicago, within 1 Km",
                "Hangout",
                "Juice",
                "Movie",
                "Looking for someone to watch movies with.",
                Status.PENDING
            )
        )
        productList.add(
            PersonalModel(
                R.drawable.img5,
                "David Brown",
                "Miami, within 5 Km",
                "Networking",
                "Water",
                "Gym",
                "Anyone up for a workout session?",
                Status.ACCEPTED
            )
        )
        adapter = PersonalAdapter(personalList = productList, context = requireContext())
        binding.rvPersonal.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvPersonal.adapter = adapter
    }

    companion object {}
}
