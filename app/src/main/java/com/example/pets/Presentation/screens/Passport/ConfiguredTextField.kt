package com.example.pets.Presentation.screens.Passport
// todo 5. Поменять название пакета

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
// noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pets.Presentation.theme.Blue200
import com.example.pets.Presentation.theme.PetsTheme
import com.example.pets.R

@Preview()
@Composable
fun ConfiguredextFieldPreview() {
    PetsTheme {
        ConfiguredTextField(
            modifier = Modifier.height(44.dp)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ConfiguredTextField(
    modifier: Modifier,
    shape: CornerBasedShape = RoundedCornerShape(16.dp),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = true,
    maxLines: Int = 1
) {

    var text by remember {
        mutableStateOf("")
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    BasicTextField(
        value = text,
        onValueChange = { text = it },
        interactionSource = interactionSource,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        maxLines = maxLines,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
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
            ),
        cursorBrush = SolidColor(
            Blue200
        ),
        textStyle = TextStyle(
            fontSize = dimensionResource(
                id = R.dimen.text_size
            )
                .value
                .sp
        ),
    ) { innerTextField ->

        TextFieldDefaults
            .TextFieldDecorationBox(
                value = text,
                visualTransformation = VisualTransformation.None,
                innerTextField = innerTextField,
                singleLine = singleLine,
                enabled = true,
                interactionSource = interactionSource,
                colors = TextFieldDefaults
                    .textFieldColors(
                        textColor = colorResource(id = R.color.black),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        backgroundColor = Color.White
                    ),
                contentPadding = PaddingValues(
                    start = 24.dp,
                    top = 8.dp,
                    end = 24.dp,
                    bottom = 8.dp
                )
            )

    }
}