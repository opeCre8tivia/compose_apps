package com.odavolt.tapaddmoney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odavolt.tapaddmoney.ui.theme.TapAddMoneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TapAddMoneyTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    color = Color(0xFF546E7A)

                ) {


                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                    }

                    CreateCircle()
                }

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CreateCircle() {
   Card(modifier = Modifier
       .size(150.dp)
       .background(color = Color.White),
       shape = CircleShape,
       elevation = 8.dp,
   ) {

       Box(contentAlignment = Alignment.Center) {

           Text(text = "Tap", fontSize = 14.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, color = Color.Black)
       }

   }
}

