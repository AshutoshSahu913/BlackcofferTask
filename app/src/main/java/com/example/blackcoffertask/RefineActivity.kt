package com.example.blackcoffertask

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.blackcoffertask.Adapters.PurposeAdapter
import com.example.blackcoffertask.Model.PurposeModel
import com.example.blackcoffertask.databinding.ActivityRefineBinding

class RefineActivity : AppCompatActivity() {
    private val binding: ActivityRefineBinding by lazy {
        ActivityRefineBinding.inflate(layoutInflater)
    }
    lateinit var adapter: PurposeAdapter
    var purposeList = ArrayList<PurposeModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backBtn.setOnClickListener {
            finish()
        }
        selectAvailability()
        purposeList.add(PurposeModel("Coffee"))
        purposeList.add(PurposeModel("Business"))
        purposeList.add(PurposeModel("Hobbies"))
        purposeList.add(PurposeModel("Friends"))
        purposeList.add(PurposeModel("Movies"))
        purposeList.add(PurposeModel("Dinning"))
        purposeList.add(PurposeModel("Dating"))
        purposeList.add(PurposeModel("Matrimony"))

        adapter = PurposeAdapter(purposeList = purposeList, context = this)
        binding.rvPurpose.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.rvPurpose.adapter = adapter

    }

    private fun selectAvailability() {
        val spinner: Spinner = binding.selectAvailability

        val availability = listOf(
            "Available | Hey Let Us Connect",
            "Away | Stay Discrete And Watch",
            "Busy | Do Not Disturb | Will Catch Up Later ",
            "SOS | Emergency! Need Assistance! HELP ",
        )

        ArrayAdapter(
            this@RefineActivity,
            R.layout.custom_spinner,
            availability
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

    }
}