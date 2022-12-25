package com.example.submissioncomposedicoding.ui.screen.about

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.submissioncomposedicoding.R

@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun AboutScreen() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
    ) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 4.dp,
        ) {
            Column(
                modifier = Modifier
                    .height(300.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CreateImageProfile()
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(16.dp),
                ) {
                    CreateBio()
                }
            }
        }
    }
}

@Composable
private fun CreateBio() {
    Text(
        text = "Farouq An Najaby",
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.h5.copy(
            fontWeight = FontWeight.ExtraBold
        ),
    )
    Text(
        text = "rouqfarouq@gmail.com",
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.body1.copy(
            fontWeight = FontWeight.Light
        ),
    )
    Text(
        text = "Android developer @Olsera.com",
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.body1.copy(
            fontWeight = FontWeight.Light
        ),
    )
}

@Composable
private fun CreateImageProfile() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.farouq),
            contentDescription = "imgProfile",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}