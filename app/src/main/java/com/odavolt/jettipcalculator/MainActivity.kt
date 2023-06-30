package com.odavolt.jettipcalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odavolt.jettipcalculator.ui.theme.JetTipcalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTipcalculatorTheme {

                MyApp {
                    HeaderCard()
                    TipTextField()
                }

            }
        }
    }
}

@Composable

fun MyApp(content:@Composable ()-> Unit){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        Column(verticalArrangement = Arrangement.Top,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier
                   .fillMaxSize()
                   .padding(10.dp)


        ) {
            content()
        }
    }
}

@Composable
fun HeaderCard(){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .clip(shape = RoundedCornerShape(20.dp)),
        color = Color.Cyan


    ) {
        
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
           
            Text(text = "Total per person", fontSize = 14.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text(text = "$133.00", fontSize = 30.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }

    }
}


@Composable

fun TipTextField(){
    val textValueState = remember {
        mutableStateOf("")
    }

    TextField(
        modifier = Modifier
            .padding(10.dp)
            .border(width = 2.dp, color = Color(color = 0xFF800000))
            .background(color = Color.Transparent)
            .clip(shape = RoundedCornerShape(6.dp))
        ,
        textStyle = TextStyle(color = Color(0xFF800000)),
        singleLine = true,
        placeholder = {
                      Text(text = "Enter name")
        },
        leadingIcon = { Icon(imageVector = Icons.Default.Add , contentDescription ="leading icon" ) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value =textValueState.value , onValueChange = { value ->
            Log.d("Inputx", value)
        textValueState.value = value
    })
}


@Composable
@Preview(showBackground = true)

fun DefaultPrev(){
    MyApp {
        HeaderCard()
        TipTextField()
    }
}







