package com.almy.gato.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(text: String,modifier: Modifier){
    Text(
        text = text,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = modifier
    )
}


@Composable
fun CustomText(text: String){
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        modifier = Modifier.padding(5.dp)
    )
}
