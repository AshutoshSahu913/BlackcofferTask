package com.example.blackcoffertask.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blackcoffertask.Adapters.BusinessesAdapter
import com.example.blackcoffertask.Model.PersonalModel
import com.example.blackcoffertask.R
import com.example.blackcoffertask.databinding.FragmentBusinessesBinding

class BusinessesFragment : Fragment() {

    lateinit var binding: FragmentBusinessesBinding
    lateinit var adapter: BusinessesAdapter
    var businessList = ArrayList<PersonalModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentBusinessesBinding.inflate(layoutInflater,container,false)

        setUpBusinessRecyclerView()
        return binding.root
    }

    companion object {

    }

    private fun setUpBusinessRecyclerView() {
        businessList.add(
            PersonalModel(
                image = R.drawable.img1,
                name = "Michael Murphy",
                address = "San Francisco, within 1 Km",
                showMessage = "Hi community! I am open to new connections",
                profession = "Wedding planner", score = 88
            )
        )
        businessList.add(
            PersonalModel(
                image = R.drawable.img1,
                name = "Michael Murphy",
                address = "San Francisco, within 1 Km",
                showMessage = "Hi community! I am open to new connections",
                profession = "Wedding planner",
                score = 88,
            )
        )
        businessList.add(
            PersonalModel(
                image = R.drawable.img2,
                name = "Jessica Smith",
                address = "New York, within 2 Km",
                showMessage = "Looking to expand my professional network.",
                profession = "Marketing Specialist",
                score = 90,
            )
        )
        businessList.add(
            PersonalModel(
                image = R.drawable.img3,
                name = "John Doe",
                address = "Los Angeles, within 3 Km",
                showMessage = "Let's catch up for some sports activities.",
                profession = "Graphic Designer",
                score = 78,
            )
        )
        businessList.add(
            PersonalModel(
                image = R.drawable.img4,
                name = "Emily Johnson",
                address = "Chicago, within 1 Km",
                showMessage = "Looking for someone to watch movies with.",
                profession = "Film Critic",
                score = 82,
            )
        )
        businessList.add(
            PersonalModel(
                image = R.drawable.img5,
                name = "David Brown",
                address = "Miami, within 5 Km",
                showMessage = "Anyone up for a workout session?",
                profession = "Fitness Trainer",
                score = 88,
            )
        )

        adapter = BusinessesAdapter(businessList = businessList, context = requireContext())
        binding.rvBusiness.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvBusiness.adapter = adapter
    }

}
