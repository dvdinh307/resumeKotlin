package com.example.resumeandroid.models.bases

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.Toast

/**
 * Declare all extension of projects.
 */
fun EditText.getValues(): String = this.text.toString()

inline fun <reified T : Activity> Activity.nextActivity(flag: Int?) {
    startActivity(Intent(this, T::class.java).apply {
        flag?.let {
            addFlags(it)
        }
    })
}

fun String.showLong(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}

fun String.showShort(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}


