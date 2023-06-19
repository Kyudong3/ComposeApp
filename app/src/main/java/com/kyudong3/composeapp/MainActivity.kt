package com.kyudong3.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kyudong3.composeapp.ui.list.Developer
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

//@Preview(showBackground = true)
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

//@Preview
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

//@Preview
//@Composable
//fun SignInScreenPreview() {
//    ComposeAppTheme {
//        SignInScreen()
//    }
//}

@Composable
fun DeveloperTypeSurvey() {
    val developers = listOf(
        Developer(R.string.android),
        Developer(R.string.ios),
        Developer(R.string.web),
        Developer(R.string.server)
    )
    Column(
        modifier = Modifier.selectableGroup()
    ) {
        var selectedType: Developer by remember { mutableStateOf(developers.first()) }
        developers.forEach {
            RadioTextButton(
                text = stringResource(id = it.type),
                selected = (selectedType == it),
                onClick = { selectedType = it }
            )
        }
    }
}

@Composable
fun RadioTextButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .selectable(
                selected = selected,
                onClick = onClick,
                role = Role.RadioButton
            ),
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(
            width = 1.dp,
            color = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.outline
            }
        )
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            RadioButton(selected = selected, onClick = null)
            Text(
                text = text,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun DeveloperTypeSurveyPreview() {
    ComposeAppTheme {
        DeveloperTypeSurvey()
    }
}

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    text: String
) {
    Button(
        onClick = {},
        modifier = modifier.fillMaxWidth().height(52.dp),
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) Blue else Gray
        )
    ) {
        Text(
            text = text,
            color = if (enabled) Color.White else Gray,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    ComposeAppTheme {
        PrimaryButton(
            onClick = {},
            enabled = true,
            text = "확인"
        )
    }
}

@Composable
fun ProductDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(24.dp))

        val horizontalPadding = Modifier.padding(horizontal = 16.dp)
        Text(
            "twg. official",
            modifier = horizontalPadding
        )

        Spacer(Modifier.height(16.dp))
        Row {
            Text(
                "[19차 리오더] 페이크 레더 숏 테일러 자켓 블랙(1 color)",
                modifier = horizontalPadding.then(
                    Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
            )
            Icon(
                Icons.Default.Favorite,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            )
        }

        Spacer(Modifier.height(24.dp))
        Row(modifier = horizontalPadding) {
            Text("정상가")
            Text(
                "99,800원",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(Modifier.height(24.dp))
        Divider(
            thickness = 1.dp,
            color = Color.LightGray
        )
        Text(
            "상품 설명",
            modifier = Modifier.padding(16.dp)
        )
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ProductDetailScreenPreview() {
//    ComposeAppTheme {
//        ProductDetailScreen()
//    }
//}

@Composable
fun CounterButton() {
    var count by remember { mutableStateOf(0) }
    ClickCounter(clicks = count) {
        count += 1
    }
}

@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Column {
        Text("Recomposition Test")
        Button(onClick = onClick) {
            Text("I've been clicked $clicks times")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterButtonPreview() {
    ComposeAppTheme {
        CounterButton()
    }
}
