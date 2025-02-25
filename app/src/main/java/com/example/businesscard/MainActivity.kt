package com.example.businesscard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFDAE5DB))
) {
    Box(modifier = Modifier) {
        BasicInfo(
            icon = painterResource(R.drawable.ic_android_black_24dp),
            fullName = stringResource(R.string.full_name),
            jobTitle = stringResource(R.string.job_title),
            modifier = modifier
        )
        ContactInfo(
            phoneNumberIcon = painterResource(R.drawable.baseline_local_phone_24),
            nickNameIcon = painterResource(R.drawable.baseline_account_circle_24),
            emailIcon = painterResource(R.drawable.baseline_alternate_email_24),
            phoneNumber = stringResource(R.string.phone_number),
            nickName = stringResource(R.string.nickname),
            email = stringResource(R.string.email),
        )
    }
}

@Composable
fun BasicInfo(icon: Painter, fullName: String, jobTitle: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = icon,
            modifier = Modifier.size(100.dp),
            contentDescription = null,
        )
        Text(
            text = fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(bottom = 12.dp),
        )
        Text(
            text = jobTitle,
            fontSize = 25.sp,
            color = Color(0xFF246408),
        )
    }
}

@Composable
fun ContactInfo(
    phoneNumberIcon: Painter,
    nickNameIcon: Painter,
    emailIcon: Painter,
    phoneNumber: String,
    nickName: String,
    email: String,
    modifier: Modifier = Modifier.fillMaxSize().fillMaxWidth(),
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(modifier = Modifier.padding(bottom = 12.dp)) {
            Image(
                painter = phoneNumberIcon,
                contentDescription = null,

            )
            Text(
                text = phoneNumber,
                modifier = Modifier.padding(start = 12.dp),
            )
        }
        Row(modifier = Modifier.padding(bottom = 12.dp)) {
            Image(
                painter = nickNameIcon,
                contentDescription = null,
            )
            Text(
                text = nickName,
                modifier = Modifier.padding(start = 12.dp),
            )
        }
        Row(modifier = Modifier.padding(bottom = 12.dp)) {
            Image(
                painter = emailIcon,
                contentDescription = null,
            )
            Text(
                text = email,
                modifier = Modifier.padding(start = 12.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()

    }
}