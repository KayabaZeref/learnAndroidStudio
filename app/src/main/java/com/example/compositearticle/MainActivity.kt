package com.example.compositearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compositearticle.ui.theme.CompositeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositeArticleTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   CompositeArticle()
                }
            }
        }
    }
}

@Composable
fun CompositeArticle(){
    GreetingImage(
        headline = stringResource(R.string.title_compose_tutorial),
        secondText = stringResource(R.string.second_description),
        thirdText = stringResource(R.string.third_description),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}
@Composable
private fun GreetingImage(
    headline: String,
    secondText: String,
    thirdText: String,
    imagePainter: Painter ,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Image(
            painter = imagePainter,
            contentDescription = null,
        )
        GreetingText(
            headline = headline,
            secondText = secondText,
            thirdText = thirdText,
            modifier = modifier
        )
    }
}

@Composable
private fun GreetingText(
    headline: String,
    secondText: String,
    thirdText: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {

        Text(
            text = headline,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = secondText,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
        )
        Text(
            text = thirdText,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CompositeArticleTheme {
        GreetingImage(
            headline = "Jetpack Compose tutorial\n",
            secondText = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\n",
            thirdText = "In this tutorial, you build a simple UI component with Compose, and learn how it can be used to build complex UIs.",
            imagePainter = painterResource(R.drawable.bg_compose_background)
        )
    }
}