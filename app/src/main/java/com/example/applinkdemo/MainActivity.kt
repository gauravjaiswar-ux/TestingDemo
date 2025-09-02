package com.example.applinkdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.applinkdemo.ui.theme.AppLinkDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLinkDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val lambda: (Int) -> Int = { number -> number * number }

                    val sum : (Int,Int) -> Int = { a,b -> a+b}

                    val multiplyBy2 : (Int) -> Int = { it * 2 }

                    multiplyBy2("")

                    sum(4,3)

                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
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
    AppLinkDemoTheme {
        Greeting("Android")
    }
}