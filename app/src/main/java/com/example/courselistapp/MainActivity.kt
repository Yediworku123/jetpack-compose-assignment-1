// MainActivity.kt
package com.example.courselistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.courselistapp.ui.screens.MyApp
import com.example.courselistapp.ui.theme.CourseListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseListAppTheme {
                MyApp()
            }
        }
    }
}
