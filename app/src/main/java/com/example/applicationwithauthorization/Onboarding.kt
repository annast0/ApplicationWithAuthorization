package com.example.applicationwithauthorization

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Onboarding(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.screen),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .height(500.dp)
                .align(Alignment.TopCenter)
                .size(200.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Привет",
                fontSize = 40.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 70.dp),
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Normal
            )
            Text(
                text = "Наслаждайся отборочными.\nБудь внимателен.\nДелай хорошо.",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 0.dp),
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
        }
        val customColor = Color(0xFF7C9A92)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate("Login")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = customColor,
                    contentColor = Color.White
                ),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp),
                modifier = Modifier
                    .padding(top = 500.dp)
                    .size(width = 300.dp, height = 60.dp)
            ) {
                Text(
                    text = "Войти в аккаунт",
                    fontSize = 22.sp
                )
            }
            Text(
                text = "Еще нет аккаунта? Зарегистрируйтесь",
                color = customColor,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 0.dp)
                    .clickable {
                        navController.navigate("Registration")
                    }
            )
        }

    }
}
