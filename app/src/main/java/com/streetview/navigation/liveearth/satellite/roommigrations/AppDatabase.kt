package com.streetview.navigation.liveearth.satellite.roommigrations

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec


@Database(
    entities = [User::class],
    version = 3,
    exportSchema = true,
    autoMigrations = [AutoMigration(from = 1, to = 2),
        AutoMigration(
        from = 2, to = 3, spec = AppDatabase.Migration2To3::class // migration change in column needs migration spec
    ),]  //migration using autoMigrations
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    //migration class that auto migrates
    //changing column name
    @RenameColumn(tableName = "User", fromColumnName = "created", toColumnName = "createdAt")
    class Migration2To3 : AutoMigrationSpec

}