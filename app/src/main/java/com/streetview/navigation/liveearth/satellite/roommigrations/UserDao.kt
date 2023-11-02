package com.streetview.navigation.liveearth.satellite.roommigrations

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(user: User)

    @Query("SELECT * from user")
    suspend fun getAllUsers(): List<User>


}