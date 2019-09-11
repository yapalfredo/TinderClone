package com.example.tinderclone.activities

import com.google.firebase.database.DatabaseReference

interface TinderCallback {

    fun onSignout()
    fun onGetUserId() : String
    fun getDatabase() : DatabaseReference
    fun profileComplete()
    fun startActivityForPhoto()

}