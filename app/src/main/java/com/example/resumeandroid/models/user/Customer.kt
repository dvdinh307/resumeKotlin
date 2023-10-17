package com.example.resumeandroid.models.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.resumeandroid.models.database.DatabaseString

@Entity(tableName = DatabaseString.TABLE_CUSTOMER)
data class Customer(var name: String, var age: Int, var jobs: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
