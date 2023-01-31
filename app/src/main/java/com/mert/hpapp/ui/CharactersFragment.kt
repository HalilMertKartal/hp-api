package com.mert.hpapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mert.hpapp.mainRecyclerView.MainRVAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_characters.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CharactersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharactersFragment : Fragment() {
    private var TAG = "CharactersFragment"
    lateinit var mainViewModel: MainActivityViewModel
    lateinit var mainRVAdapter: MainRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // RV'nin adapter'ını burada yapmazsak patlıyor
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        callApi()
        initRecyclerView()
        Log.d("CharactersFragment", "CharactersFragment launched")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment characters_fragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CharactersFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    // Observe the  list in viewModel and call the api with data returned
    private fun callApi() {
        // Call api
        // Owner is MainActivity
        mainViewModel.getCharList().observe(viewLifecycleOwner) {
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
            layoutManager = LinearLayoutManager(activity)

            // Create a divider line
            val decoration = DividerItemDecoration(activity?.applicationContext, StaggeredGridLayoutManager.VERTICAL)
            // Add the line to the item
            addItemDecoration(decoration)

        }
    }
}