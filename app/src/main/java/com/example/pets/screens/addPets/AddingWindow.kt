package com.example.pets.screens.addPets

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pets.R
import com.example.pets.amir.firebase.addUsers




@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Preview
@Composable

fun AddPets() {
    var name by remember {
        mutableStateOf("")
    }
    var type by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableStateOf("")
    }
    var listage by remember {
        mutableStateOf(false)
    }
    var typeOfWool by remember {
        mutableStateOf("")
    }
    Scaffold {
        Box(
            Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.Font_Main))
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 98.dp, end = 152.dp),


                ) {
                Box(
                    Modifier

                ) {
                    Text(
                        text = "Профиль Питомца", fontSize = 22.sp
                    )
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 16.dp)
                ) {
                    Text(text = "Имя", fontSize = 12.sp)

                }
                DefaultTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 16.dp),


                    ) {
                    Text(text = "Порода", fontSize = 12.sp)
                }
                DefaultTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth()
                )

                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp)
                ) {
                    Text(text = "Возраст", fontSize = 12.sp)
                }
                Row {
                    Box(
                        Modifier.width(96.dp).height(42.dp)
                    ) {
                        //123
                        val interactionSource = remember { MutableInteractionSource() }
                        var colors: TextFieldColors = GetColors()
                        BasicTextField(
                            value = age,
                            onValueChange = { age=it },
                            interactionSource = interactionSource,
                            singleLine = true,
                            modifier = Modifier
                                .background(colors.backgroundColor(true).value, shape = RoundedCornerShape(20.dp))
                        ) { innerTextField ->
                            TextFieldDefaults.TextFieldDecorationBox(
                                value = age,
                                innerTextField = innerTextField,
                                interactionSource = interactionSource,
                                contentPadding = PaddingValues(12.dp),
                                enabled = true,
                                singleLine = true,
                                visualTransformation = VisualTransformation.None,
                                colors = colors,

                                trailingIcon = {
                                    Icon(painterResource(id = R.drawable.dropdown),
                                        contentDescription = null,
                                        modifier = Modifier.clickable {
                                            listage = true
                                        })

                                }

                                // this is how you can remove the padding
                            )
                            if (listage) {
                                DropdownMenu(
                                    expanded = listage,
                                    onDismissRequest = { listage = false },
                                    modifier = Modifier.fillMaxHeight()

                                ) {
                                    DropdownMenuItem(onClick = { }) {
                                        Text("Скопировать")
                                    }
                                }
                            }
                        }
                        //123
                    }

                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp)
                ) {
                    Text(text = "Вид шерсти", fontSize = 12.sp)
                }
                DefaultTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AgeTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    colors: TextFieldColors = GetColors(),
    shape: Shape = RoundedCornerShape(16.dp),
    listage: (Boolean)->Unit

) {
    val interactionSource = remember { MutableInteractionSource() }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DefaultTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    colors: TextFieldColors = GetColors(),
    shape: Shape = RoundedCornerShape(16.dp),
) {
    val interactionSource = remember { MutableInteractionSource() }
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        interactionSource = interactionSource,
        singleLine = true,
        modifier = modifier
            .background(colors.backgroundColor(true).value, shape)
    ) { innerTextField ->
        TextFieldDefaults.TextFieldDecorationBox(
            value = value,
            innerTextField = innerTextField,
            interactionSource = interactionSource,
            contentPadding = PaddingValues(12.dp),
            enabled = true,
            singleLine = true,
            visualTransformation = VisualTransformation.None,
            colors = colors
            // this is how you can remove the padding
        )
    }
}

@Composable
fun GetColors(): TextFieldColors = TextFieldDefaults.textFieldColors(
    textColor = colorResource(id = R.color.color_text),
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    disabledIndicatorColor = Color.Transparent,
    backgroundColor = Color.White
)
