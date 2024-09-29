package com.example.applicationwithauthorization

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Login(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF253334))
            .padding(horizontal = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Sign in",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Email",
            fontSize = 20.sp,
            color = Color(0xFFBEC2C2)
        )
        Divider(
            color = Color(0xFFBEC2C2),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 5.dp)
        )

        Text(
            text = "Пароль",
            fontSize = 20.sp,
            color = Color(0xFFBEC2C2)
        )
        Divider(
            color = Color(0xFFBEC2C2),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 5.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            val customColor = Color(0xFF7C9A92)
            Button(
                onClick = { navController.navigate("Main") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = customColor,
                    contentColor = Color.White
                ),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(70.dp)
            ) {
                Text(
                    text = "Sign in",
                    fontSize = 22.sp
                )
            }
            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = "Registr",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
                    .clickable{
                        navController.navigate("Registration")
                    }
            )

            Button(
                onClick = { navController.navigate("Profile") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = customColor,
                    contentColor = Color.White
                ),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(70.dp)
            ) {
                Text(
                    text = "Профиль",
                    fontSize = 22.sp
                )
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Spacer(modifier = Modifier.height(570.dp))
        Image(
            painter = painterResource(id = R.drawable.clipboard),
            contentDescription = "",
            modifier = Modifier
                .size(2000.dp)
        )
    }
}