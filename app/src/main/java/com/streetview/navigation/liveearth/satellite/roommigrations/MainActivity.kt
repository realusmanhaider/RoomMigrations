package com.streetview.navigation.liveearth.satellite.roommigrations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database = Room.databaseBuilder(this, AppDatabase::class.java, "user.db").build()


        //inserting data in room for first time
        for (i in 1..10) {
            CoroutineScope(Dispatchers.IO).launch {
                database.userDao().insert(User(name = "User$i", password =  "Password$i"))
                Log.d("User", "onCreate: User$i Password$i")
            }
        }


        CoroutineScope(Dispatchers.IO).launch {
            val users = database.userDao().getAllUsers()
            for (user in users){
                Log.d("User", "onCreate: $user ")
            }
        }




    }
}