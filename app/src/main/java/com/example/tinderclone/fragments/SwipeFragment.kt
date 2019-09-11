package com.example.tinderclone.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.example.tinderclone.R
import com.example.tinderclone.activities.TinderCallback
import com.example.tinderclone.util.User
import com.google.firebase.database.DatabaseReference

/**
 * A simple [Fragment] subclass.
 */
class SwipeFragment : Fragment() {

    private var callback: TinderCallback? = null
    private lateinit var  userId: String
    private lateinit var userDatabase: DatabaseReference
    private var cardsAdapter : ArrayAdapter<User>? = null
    private var rowItems  = ArrayList<User>()

    fun setCallback(callback: TinderCallback) {
        this.callback = callback
        userId = callback.onGetUserId()
        userDatabase = callback.getDatabase()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_swipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        cardsAdapter =
    }


}
