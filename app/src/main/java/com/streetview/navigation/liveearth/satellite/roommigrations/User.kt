package com.streetview.navigation.liveearth.satellite.roommigrations

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    val password: String,
    @ColumnInfo(name = "created", defaultValue = "0")    //created new column and then did migration for it
    val createdAt: Long = System.currentTimeMillis()
)
