package com.odavolt.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.odavolt.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
               CreateBizCard()
            }
        }
    }
}


@Composable
fun CreateBizCard (){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth()
            .background(color = Color(0xffffffff))

    ) {
         Card(
            modifier = Modifier.background(color = Color.White)
         ){
            Text(text = "Compose app")
         }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CreateBizCard()
}