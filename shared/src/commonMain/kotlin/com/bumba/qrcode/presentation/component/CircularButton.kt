package com.bumba.qrcode.presentation.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumba.qrcode.presentation.util.Platform.ANDROID
import com.bumba.qrcode.presentation.util.getPlatform

@Composable
fun CircularButton(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Composable
fun CircularButton(
    backgroundColor: Color = Color(25, 25, 28).copy(alpha = 0.7f),
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    iconColor: Color = Color.White,
    sizeIcon: Dp = 30.dp,
    onClick: () -> Unit,
) {
    CircularButton(
        modifier = modifier.animateContentSize(),
        content = {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                modifier = Modifier.size(sizeIcon),
                tint = iconColor
            )
        },
        backgroundColor = backgroundColor,
        onClick = onClick
    )
}

@Composable
fun BackButton(onClick: () -> Unit) {
    CircularButton(
        imageVector = if (getPlatform() == ANDROID)
            Icons.Default.ArrowBack else Icons.Default.ArrowBackIosNew,
        onClick = onClick
    )
}