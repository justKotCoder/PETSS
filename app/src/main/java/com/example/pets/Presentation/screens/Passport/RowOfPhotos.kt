package com.example.pets.Presentation.screens.Passport

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pets.R

@Preview
@Composable
fun RowOfPhotosPreview() {

}

@Composable
fun RowOfPhotos() {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Box(
//            modifier = Modifier
//                .height(110.dp)
//                .width(110.dp)
//                .padding(
//                    start = 8.dp,
//                    top = 8.dp,
//                    bottom = 8.dp
//                )
//                .background(
//                    color = colorResource(id = R.color.gr),
//                    shape = RoundedCornerShape(16.dp)
//                )
//                .border(
//                    border = BorderStroke(
//                        width = 2.dp,
//                        color = Color.Black
//                    ),
//                    shape = RoundedCornerShape(16.dp)
//                ),
//            contentAlignment = Alignment.TopCenter,
//        ) {
//            Icon(
//                painter = painterResource(
//                    id = R.drawable.icon_plus
//                ),
//                contentDescription = "Add photo",
//                modifier = Modifier
//                    .padding(top = 25.dp)
//            )
//            // todo 6. Как под капотом работают Layout - ы в Compose?
//            Text(
//                text = "Добавить фото",
//                textAlign = TextAlign.Center,
//                fontSize = 14.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(
//                        start = 10.dp,
//                        top = 50.dp,
//                        end = 10.dp
//                    )
//            )
//        }
//    }
}