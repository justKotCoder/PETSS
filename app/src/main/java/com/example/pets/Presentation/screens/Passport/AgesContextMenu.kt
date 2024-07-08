package com.example.pets.Presentation.screens.Passport
// todo 8. Поменять название пакета

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.pets.Presentation.theme.PetsTheme
import com.example.pets.R
import com.wajahatkarim.flippable.FlipAnimationType
import com.wajahatkarim.flippable.Flippable
import com.wajahatkarim.flippable.rememberFlipController

@Preview(showBackground = true)
@Composable
fun AgesContextMenuPreview() {
    PetsTheme {
        AgesContextMenu()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AgesContextMenu(
    height: Dp = 44.dp,
    shape: CornerBasedShape = RoundedCornerShape(16.dp),
) {

    var selectedAge by remember {
        mutableStateOf("1")
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    var mExpanded by remember {
        mutableStateOf(false)
    }

    val pressOffset by remember {
        mutableStateOf(DpOffset.Zero)
    }

    val ages = (1..30).toList()

    val controller = rememberFlipController()

    BasicTextField(
        value = selectedAge,
        onValueChange = { selectedAge = it },
        interactionSource = interactionSource,
        readOnly = true,
        modifier = Modifier
            .width(100.dp)
            .height(height)
            .background(
                color = Color.White,
                shape = shape
            )
            .border(
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.Gray.copy(alpha = 0.1f)
                ),
                shape = shape
            )
            .clip(
                shape = shape
            )
            .onGloballyPositioned { coordinates ->
                mTextFieldSize = coordinates.size.toSize()
            },
        textStyle = TextStyle(
            fontSize = dimensionResource(
                id = R.dimen.text_size
            )
                .value
                .sp,
        ),
    ) { innerTextField ->

        TextFieldDefaults.TextFieldDecorationBox(
            value = selectedAge,
            visualTransformation = VisualTransformation.None,
            innerTextField = innerTextField,
            singleLine = true,
            enabled = true,
            interactionSource = interactionSource,
            colors = TextFieldDefaults.textFieldColors(
                textColor = colorResource(id = R.color.black),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.White
            ),
            contentPadding = PaddingValues(
                start = 24.dp,
                top = 8.dp,
                bottom = 8.dp
            ),
            trailingIcon = {
                Flippable(
                    frontSide = {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = stringResource(
                                id = R.string.content_description_expanded_ages
                            )
                        )
                    },
                    backSide = {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowUp,
                            contentDescription = stringResource(
                                id = R.string.content_description_expanded_ages
                            )
                        )
                    },
                    flipController = controller,
                    flipDurationMs = 300,
                    flipOnTouch = true,
                    flipAnimationType = FlipAnimationType.VERTICAL_CLOCKWISE,
                    onFlippedListener = {
                        mExpanded = !mExpanded
                    }
                )

            }
        )

    }

    MaterialTheme(
        shapes = MaterialTheme.shapes.copy(
            extraSmall = shape
        )
    ) {

        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(
                    with(LocalDensity.current) {
                        mTextFieldSize.width.toDp() - 40.dp
                    }
                )
                .height(150.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ),
            offset = pressOffset.copy(
                y = pressOffset.y - 70.dp,
                x = 100.dp
            )
        )
        {
            ages.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        selectedAge = label.toString()
                        mExpanded = false
                    }
                ) {
                    Text(text = label.toString())
                }
            }
        }

    }
}