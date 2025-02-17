package com.example.signatureapp.signature.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.alpha
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

/**
 * Created by akshay on 28/12/21
 * https://ak1.io
 */
//// DataStore Instance
//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
//
//// Preference Keys
//val themePreferenceKey = intPreferencesKey("list_theme")
//
//internal val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//internal const val PERMISSION_CODE = 100
//
//// Retrieving functions
///**
// * extension [isDarkThemeOn] checks the saved theme from preference
// * and returns boolean
// */
//fun Context.isDarkThemeOn() = dataStore.data
//    .map { preferences ->
//        // No type safety.
//        preferences[themePreferenceKey] ?: 0
//    }

fun Color.convertToOldColor(): Int {
    val color = this.toArgb()
    return android.graphics.Color.argb(
        color.alpha,
        color.red,
        color.green,
        color.blue
    )
}