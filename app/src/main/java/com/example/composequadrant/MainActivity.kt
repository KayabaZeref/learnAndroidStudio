package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = modifier.weight(1f)) {
            ComposeQuadrantText(
                title = stringResource(R.string.top_left_title),
                description = stringResource(R.string.top_left_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFEADDFF),
            )
            ComposeQuadrantText(
                title = stringResource(R.string.top_right_title),
                description = stringResource(R.string.top_right_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFD0BCFF),
            )
        }
        Row(modifier = modifier.weight(1f)) {
            ComposeQuadrantText(
                title = stringResource(R.string.bottom_left_title),
                description = stringResource(R.string.bottom_left_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFB69DF8),
            )
            ComposeQuadrantText(
                title = stringResource(R.string.bottom_right_title),
                description = stringResource(R.string.bottom_right_description),
                modifier = Modifier.weight(1f),
                backgroundColor = Color(0xFFF6EDFF),
            )
        }
    }

}

@Composable
private fun ComposeQuadrantText(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = description,
            modifier = Modifier.padding(start = 16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        ComposeQuadrantApp()
    }
}