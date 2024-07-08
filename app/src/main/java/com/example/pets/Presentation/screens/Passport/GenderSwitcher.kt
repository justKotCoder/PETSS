package com.example.pets.Presentation.screens.Passport
// todo 9. поменять название пакета

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pets.Presentation.theme.BlueBasic
import com.example.pets.Presentation.theme.Purple200

@Preview
@Composable
fun GenderSwitcherPreview() {
    GenderSwitcherWrapper()
}

@Composable
fun GenderSwitcherWrapper() {
    var mGender by remember {
        mutableStateOf("Самец")
    }

    var visibleGenderMale by remember {
        mutableStateOf(true)
    }

    GenderSwitcher(
        selectedGender = mGender,
        visibleGenderMale = visibleGenderMale,
    ) {
        mGender = it
        visibleGenderMale = mGender == "Самец"
    }
}

@Composable
fun GenderSwitcher(
    size: Dp = 120.dp,
    parentHeight: Dp = 45.dp,
    parentShape: CornerBasedShape = RoundedCornerShape(16.dp),
    paddingForOptions: Dp = 4.dp,
    selectedGender: String,
    visibleGenderMale: Boolean,
    onClick: (text: String) -> Unit,
) {
    // todo 10. почитать про interactionSource
    val interactionSourceMaleOption = remember {
        MutableInteractionSource()
    }

    val interactionSourceFemaleOption = remember {
        MutableInteractionSource()
    }

    Box(
        modifier = Modifier
            .width(size * 2)
            .height(parentHeight)
            .background(
                color = Color.White,
                shape = parentShape
            )
            .border(
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.Gray.copy(alpha = 0.1f)
                ),
                shape = parentShape
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .size(size)
                    .clickable(
                        interactionSource = interactionSourceMaleOption,
                        indication = null
                    ) {
                        onClick("Самец")
                        Log.i("GenderSwitcher: male choosen", "Выбрано: Самец")
                    }
                    .clip(shape = parentShape),
                contentAlignment = Alignment.Center
            ) {

                // todo 10. почитать про Row и RowScope
                this@Row.AnimatedVisibility(
                    visible = visibleGenderMale
                ) {

                    Box(
                        modifier = Modifier
                            .size(size)
                            .padding(
                                all = paddingForOptions
                            )
                            .background(
                                color = BlueBasic,
                                shape = parentShape
                            )
                            .clip(shape = parentShape),
                    ) {}

                }

                Text(
                    text = "Самец",
                    color = if (selectedGender == "Самец") Color.White
                    else Color.Black,
                    fontSize = 16.sp,
                )

            }

            Box(
                modifier = Modifier
                    .size(size)
                    .clickable(
                        interactionSource = interactionSourceFemaleOption,
                        indication = null
                    ) {
                        onClick("Самка")
                        Log.i("GenderSwitcher: female choosen", "Выбрано: Самка")
                    }
                    .clip(shape = parentShape),
                contentAlignment = Alignment.Center
            ) {

                this@Row.AnimatedVisibility(
                    visible = !visibleGenderMale
                ) {

                    Box(
                        modifier = Modifier
                            .size(size)
                            .padding(
                                all = paddingForOptions
                            )
                            .background(
                                color = Purple200,
                                shape = parentShape
                            )
                            .clip(shape = parentShape),
                    ) {}

                }

                Text(
                    text = "Самка",
                    color = if (selectedGender == "Самка") Color.White
                    else Color.Black,
                    fontSize = 16.sp,
                )

            }

        }

    }

}