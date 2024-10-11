package com.example.todo.ui

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.viewmodel.TodoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TodoScreen()
                }
            }
        }
    }
}
@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()) {
    TodoList(todoViewModel.todos)
}

@Composable
fun TodoList(todos: List<String>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(todos) {todo ->
            Text(
                text=todo,
                modifier = Modifier.padding(top=4.dp,bottom=4.dp)
            )
            HorizontalDivider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoTheme {
        Greeting("Android")
    }
}