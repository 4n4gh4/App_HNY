package com.example.hny

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hny.ui.theme.HnyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HnyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        text1 = stringResource(R.string.greeting1),
                        text2 = " & ",
                        text3 = stringResource(R.string.greeting2)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(text1: String, text2: String, text3: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = text1,
            fontSize = 46.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Left
        )
        Text(
            text = text2,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = text3,
            fontSize = 46.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Right,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
fun GreetingImage(text1: String, text2: String, text3: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)

    Box(modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = "Background decoration for the greeting",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Greeting(
            text1 = text1,
            text2 = text2,
            text3 = text3,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HnyTheme {
        GreetingImage(
            text1 = "Merry Christmas!",
            text2 = " & ",
            text3 = "Happy New Year!"
        )
    }
}
