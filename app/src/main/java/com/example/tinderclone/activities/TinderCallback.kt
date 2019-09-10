package com.example.tinderclone.activities

import com.google.firebase.database.DatabaseReference

interface TinderCallback {

    fun onSignout()
    fun getUserId() : String
    fun getDatabase() : DatabaseReference

}