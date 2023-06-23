package com.odavolt.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odavolt.bizcard.ui.theme.BizCardTheme
import com.odavolt.bizcard.ui.theme.Shapes

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
            .fillMaxHeight()
            .background(color = Color(0xffffffff))

    ) {
         Card(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp),
            shape = RoundedCornerShape(20.dp),
             elevation = 50.dp,
             backgroundColor = Color.White,

         ){
          Column(
              modifier = Modifier.padding(10.dp),
              verticalArrangement = Arrangement.Top,
              horizontalAlignment = Alignment.CenterHorizontally,

          ){
              //profile picture
               ProfilePicture()
              Divider()

              InfoCard()


          }

         }
    }
}

@Composable
private fun InfoCard() {

    val showPortfolio = remember {
        mutableStateOf(true)
    }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Miles P.",
            color = Color.Blue,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Android Developer",
        )
        Text(
            text = "@compose",
            modifier = Modifier.padding(3.dp)
        )
        
        Button(onClick = {
            showPortfolio.value = !showPortfolio.value
        }) {
            Text(text = "Portfolio",color=Color.White, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        }


        if(showPortfolio.value){
            Content()
        }else {
            Box(){

            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
    ){
       Surface(
           modifier = Modifier
               .padding(6.dp)
               .fillMaxHeight()
               .fillMaxWidth(),
           border = BorderStroke(2.dp, color= Color.LightGray),
           shape = RoundedCornerShape(6.dp),
           elevation = 8.dp
       ) {

           ProfileContent(data = listOf("Profile 1","Profile 2","Profile 3","profile 5","profile 6", "profile 8","profile 9"))

       }
    }
}

@Composable
fun ProfileContent(data:List<String>) {
      LazyColumn{
          items(data){item ->
              Card(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                  Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                     ProfilePicture(modifier = Modifier.size(100.dp))
                      Column(modifier = Modifier.align(alignment = Alignment.CenterVertically).padding(10.dp)) {

                          Text(text = item, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                          Text(text = "Professional stuff", style = MaterialTheme.typography.body2)

                      }
                  }
              }
          }
      }
}


@Composable

fun ProfilePicture(modifier:Modifier = Modifier){
    Surface(modifier = modifier
        .size(140.dp),
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = Color.LightGray),
        elevation = 4.dp,
        color = Color.LightGray

    ) {
        Image(painter = painterResource(id = R.drawable.profile_image),
            contentDescription ="Profile picture" ,
            contentScale = ContentScale.Crop,
            modifier = modifier.size(135.dp)

        )
    }
}

@Composable
//@Preview(showBackground = true)
fun DefaultPreview() {
    CreateBizCard()
}