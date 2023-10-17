package com.example.resumeandroid.models.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.resumeandroid.models.database.DatabaseString

@Entity(tableName = DatabaseString.TABLE_USER)
data class User(var name: String, var pwd: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
