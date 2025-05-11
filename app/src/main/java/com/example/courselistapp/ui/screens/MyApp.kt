package com.example.courselistapp.ui.screens

import com.example.courselistapp.ui.screens.CourseListScreen
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.courselistapp.model.Course

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val courses = listOf(
        Course("Mathematics", "MATH101", "3", "Intro to Math", "None"),
        Course("Physics", "PHYS101", "4", "Intro to Physics", "Math 101"),
        Course("Computer Science", "CS101", "4", "Intro to Programming", "None"),
        Course("Algorithms", "CS201", "3", "Data structures and algorithms", "CS101")
    )

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(navController = navController, startDestination = "welcome") {
                composable("welcome") {
                    WelcomeScreen(onViewCoursesClick = {
                        navController.navigate("courseList")
                    })
                }
                composable("courseList") {
                    CourseListScreen(courses = courses, navController = navController)
                }

            }
            }
        }
    }


@Composable
fun WelcomeScreen(onViewCoursesClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to Course List App",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onViewCoursesClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1E1E2F)  // Blue-black color
            )
        ) {
            Text("View Courses", color = Color.White)  // Text color set to white for better contrast
        }
    }
}