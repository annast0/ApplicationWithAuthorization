package com.example.applicationwithauthorization

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun Profile(navController: NavController) {
    val context = LocalContext.current
    var photoUri by remember { mutableStateOf<Uri?>(null) }
    val imagesList = remember { mutableStateListOf<Any>(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4) }

    val takePictureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            photoUri?.let { uri ->
                imagesList.add(uri)
            }
        }
    }

    fun createImageFile(): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir = context.getExternalFilesDir(null)
        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF253334))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = rememberAsyncImagePainter(R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(70.dp)
            )

            Spacer(modifier = Modifier.height(50.dp))
            // Изображение профиля
            Image(
                painter = rememberAsyncImagePainter(R.drawable.da93b0a73e803ae6f34f81d1692f695a),
                contentDescription = "menu",
                modifier = Modifier
                    .size(190.dp)
                    .clip(CircleShape)
                    .clickable{
                        navController.navigate("Menu")
                    }
            )
            Text(
                text = "Эмиль",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
        Column(modifier = Modifier
            .padding(start = 10.dp, top = 40.dp),
            horizontalAlignment = Alignment.Start) {
            Image(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "menu",
                modifier = Modifier
                    .size(45.dp)
                    .clickable {
                        navController.navigate("Menu")
                    }
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 290.dp, top = 40.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "exit",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier
                    .clickable {
                        navController.navigate("Main")
                    }
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(380.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(imagesList) { imageItem ->
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.Gray)
                            .clickable {
                                val uri = when (imageItem) {
                                    is Int -> Uri.parse("android.resource://com.example.applicationwithauthorization/$imageItem")
                                    is Uri -> imageItem
                                    else -> null
                                }
                                uri?.let {
                                    val encodedUri = Uri.encode(it.toString())
                                    navController.navigate("Photo?photoUri=$encodedUri")
                                }
                            }
                    ) {
                        when (imageItem) {
                            is Int -> {
                                Image(
                                    painter = painterResource(id = imageItem),
                                    contentDescription = "Image",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            is Uri -> {
                                Image(
                                    painter = rememberAsyncImagePainter(imageItem),
                                    contentDescription = "Image",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
            item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.Green)
                            .clickable {
                                val photoFile = createImageFile() // Создаем файл изображения
                                val newUri = FileProvider.getUriForFile(
                                    context,
                                    "${context.packageName}.fileprovider",
                                    photoFile
                                )
                                photoUri = newUri
                                takePictureLauncher.launch(newUri) // Запускаем камеру с безопасным URI
                            }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Image",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .padding(start = 60.dp, top = 670.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.logov2),
            contentDescription = "logo",
            modifier = Modifier.size(40.dp)
                .clickable {
                    navController.navigate("Main")
                }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(717.dp))
        Image(
            painter = painterResource(id = R.drawable.music),
            contentDescription = "logo",
            modifier = Modifier.size(40.dp)
                .clickable {
                    navController.navigate("Music")
                }
        )
    }
    Column(
        modifier = Modifier
            .padding(start = 255.dp, top = 672.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.profilev2),
            contentDescription = "logo",
            modifier = Modifier.size(30.dp)
        )
    }
}
