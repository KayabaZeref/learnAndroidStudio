package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        form = stringResource(R.string.signature_text),
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(
    birthdayIcon: Painter,
    message: String,
    form: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = birthdayIcon,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFF5722),
        )
        Text(
            text = form,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally),
            color = Color(0xFF9C27B0)
        )
    }
}

@Composable
fun GreetingImage(
    message: String,
    form: String,
    modifier: Modifier = Modifier,
) {
    val image = painterResource(R.drawable.simple_birthday_pattern_birthday_background)
    Box(
        modifier = modifier,
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            form = form,
            birthdayIcon = painterResource(R.drawable.birthday_cake),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
        ContactInformation(
            name = stringResource(R.string.contact_name),
            email = stringResource(R.string.contact_mail),
            phoneNumber = stringResource(R.string.contact_phonenumber),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
        )
    }
}

@Composable
fun ContactInformation(
    name: String,
    email: String,
    phoneNumber: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxWidth()){
        Image(
            painter = painterResource(R.drawable.simple_birthday_pattern_birthday_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = name, fontWeight = FontWeight.Bold, color = Color(0xFF5B1BC9))
        Text(text = email, color = Color(0xFF5B1BC9))
        Text(text = phoneNumber, color = Color(0xFF5B1BC9))
    }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            form = stringResource(R.string.signature_text),
        )

    }
}

