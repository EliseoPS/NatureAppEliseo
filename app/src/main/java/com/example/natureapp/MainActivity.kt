package com.example.natureapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.natureapp.ui.theme.NatureAppTheme
import com.example.natureapp.utils.articuloList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NatureAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    natureList(

                    )
                }
            }
        }
    }
}

@Composable
fun natureList(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ){
            items(articuloList){art ->
                Card(
                    modifier = Modifier.fillMaxSize()
                ){
                    Box(){
                        Column(){
                            AsyncImage(
                                model = art.image, contentDescription = "DESCRIPCOPM",
                                modifier = Modifier.fillMaxWidth()
                            )
                            Text(text = art.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                            Text(text = art.description, fontSize = 12.sp)
                        }
                    }
                }

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NatureAppTheme {
        natureList()
    }
}