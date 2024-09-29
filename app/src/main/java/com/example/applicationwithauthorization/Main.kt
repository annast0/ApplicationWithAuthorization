// Main.kt
package com.example.applicationwithauthorization

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Main(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF253334))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally // Центрирование по горизонтали
        ) {
            Spacer(modifier = Modifier.height(50.dp)) // Отступ сверху
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(70.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 60.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "menu",
                modifier = Modifier
                    .size(55.dp)
                    .clickable{
                        navController.navigate("Menu")
                    }
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 290.dp, top = 60.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.elipse),
                contentDescription = "menu",
                modifier = Modifier
                    .size(55.dp)
                    .clickable{
                        navController.navigate("Profile")
                    }
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(170.dp))
            Text(
                text = "С возвращением, Эмиль!",
                color = Color.White,
                fontSize = 35.sp, // Изменено на sp для текста
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Каким ты себя ощущаешь сегодня?",
                color = Color(0xFFFFFFB2),
                fontSize = 25.sp, // Изменено на sp для текста
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier
                .padding(start = 20.dp, top = 150.dp))
            Image(painter = painterResource(id = R.drawable.feelings),
                contentDescription = "feelings",
                modifier = Modifier
                    .size(350.dp))
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier
                .padding(start = 20.dp, top = 330.dp))
            Image(painter = painterResource(id = R.drawable.medatition),
                contentDescription = "feelings",
                modifier = Modifier
                    .size(250.dp))
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier
                .padding(start = 20.dp, top = 480.dp))
            Image(painter = painterResource(id = R.drawable.cardio_madatition),
                contentDescription = "feelings",
                modifier = Modifier
                    .size(250.dp))
        }
        Column(
            modifier = Modifier
                .padding(start = 60.dp, top = 660.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(50.dp)) // Отступ сверху
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(50.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(717.dp)) // Отступ сверху
            Image(
                painter = painterResource(id = R.drawable.music),
                contentDescription = "logo",
                modifier = Modifier.size(40.dp)
                    .clickable{
                        navController.navigate("Music")
                    }
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 255.dp, top = 672.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(50.dp)) // Отступ сверху
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "logo",
                modifier = Modifier.size(30.dp)
                    .clickable{
                        navController.navigate("Profile")
                    }
            )
        }
    }
}
