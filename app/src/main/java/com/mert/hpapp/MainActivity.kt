package com.mert.hpapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout.HORIZONTAL
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.mert.hpapp.mainRecyclerView.MainRVAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var TAG = "MainActivity"
    lateinit var mainViewModel: MainActivityViewModel
    lateinit var mainRVAdapter: MainRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        callApi()
        initRecyclerView()
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    // Observe the  list in viewModel and call the api with data returned
    private fun callApi() {
        // Call api
        mainViewModel.getCharList().observe(this) {
            if (it != null) {
                // adapter's list = it (observed livedata array)
                // notifydatasetchanged
                mainRVAdapter.charHPList = it
                mainRVAdapter.notifyDataSetChanged()
            } else {
                // Error occurred while getting data from network
                Log.d(TAG, "API NETWORK ERROR")
            }
        }
        mainViewModel.callApi()

    }

    private fun initRecyclerView() {
        // Bind the recycler view here with view binding by using apply
        RV_charList.apply {
            // assign the adapter
            mainRVAdapter = MainRVAdapter()
            adapter = mainRVAdapter
            // assign the linear layout manager
            layoutManager = LinearLayoutManager(this@MainActivity)

            // Create a divider line
            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            // Add the line to the item
            addItemDecoration(decoration)

        }

    }
}