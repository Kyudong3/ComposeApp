package com.kyudong3.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyudong3.composeapp.ui.theme.ComposeAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(imageVector = Icons.Default.Search, contentDescription = null)
        Text(
            text = "안드로이드!",
            modifier = modifier,
            color = Color.Green
        )
        // Text도 Composable 함수
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting2Preview() {
    ComposeAppTheme {
        Greeting2("Android")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.Yellow)
            .padding(
                start = 12.dp,
                end = 12.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "안드로이드!",
            modifier = modifier,
            color = Color.Green
        )
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        Greeting("Android")
    }
}

@Composable
fun TitleText() {
    Text(
        text = "",
        color = Color.Black,
        fontSize = 30.sp,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun ButtonExample() {
    Row(Modifier.fillMaxWidth()) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.weight(1.0f),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) { Text(text = "취소") }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.weight(2.0f),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) { Text(text = "확인") }
    }
}

@Preview
@Composable
fun ButtonExamplePreview() {
    ComposeAppTheme {
        ButtonExample()
    }
}

@Composable
fun SignInScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "One Market",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text(text = "로그인")
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    ComposeAppTheme {
        SignInScreen()
    }
}