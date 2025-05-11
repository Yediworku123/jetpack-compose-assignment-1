@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.courselistapp.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.courselistapp.model.Course
import com.example.courselistapp.ui.components.CourseCard

@Composable
fun CourseListScreen(courses: List<Course>, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Course List") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(courses) { course ->
                var isExpanded by rememberSaveable { mutableStateOf(false) }

                CourseCard(
                    course = course,
                    isExpanded = isExpanded,
                    onClick = { isExpanded = !isExpanded }
                )
            }
        }
    }
}
