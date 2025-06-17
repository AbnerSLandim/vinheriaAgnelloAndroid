package com.example.vinheriaagnello.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vinheriaagnello.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.logovinheria), // substitua pelo nome correto
                contentDescription = "Logo Vinheria",
                modifier = Modifier.height(40.dp),
                contentScale = ContentScale.Fit
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF9C0009),
            titleContentColor = Color.White
        )
    )
}
