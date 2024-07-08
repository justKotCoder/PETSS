package com.example.pets.screens
// todo 1. Поменять название пакета в следующем комите

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.pets.R
import com.example.pets.Presentation.theme.PetsTheme
import com.example.pets.Presentation.screens.General._BottomBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.pets.Presentation.screens.Passport.AgesContextMenu
import com.example.pets.Presentation.screens.Passport.ConfiguredTextField
import com.example.pets.Presentation.screens.Passport.GenderSwitcher
import com.example.pets.Presentation.screens.Passport.RowOfPhotos
import com.example.pets.Presentation.theme.Blue200

@Preview
@Composable
fun PreviewPassportEdit() {
    PetsTheme {
        PetPassportEdit(
            navController = rememberNavController()
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PetPassportEdit(
    navController: NavController
) {
    // todo 3. Почитать про делегаты побольше - ПОПРАКТИКОВАТЬСЯ

    val scroll by remember {
        mutableStateOf(true)
    }

    // todo 4. Хорошо бы вынести эту логику полностью в GenderSwitcher
    val male = stringResource(
        id = R.string.male
    )
    var mGender by remember {
        mutableStateOf(male)
    }

    var visibleGenderMale by remember {
        mutableStateOf(true)
    }


    Scaffold(

        bottomBar = {
            _BottomBar(
                navController = navController
            )
        }

    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {

            Column(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 40.dp
                    )
                    .verticalScroll(
                        state = rememberScrollState(),
                        enabled = scroll
                    )
            ) {

                Text(
                    text = stringResource(
                        id = R.string.pet_passport_edit_header
                    ),
                    color = Blue200,
                    fontSize = dimensionResource(
                        id = R.dimen.text_header_size
                    )
                        .value
                        .sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(
                            top = 16.dp
                        )
                )

                Text(
                    text = stringResource(
                        id = R.string.pet_name
                    ),
                    color = Blue200,
                    fontSize = dimensionResource(
                        id = R.dimen.text_size
                    )
                        .value
                        .sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(
                            start = 24.dp,
                            top = 12.dp
                        )
                )

                ConfiguredTextField(
                    modifier = Modifier
                        .height(44.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 12.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = stringResource(
                            id = R.string.add_pet_photo
                        ),
                        color = Blue200,
                        fontSize = dimensionResource(
                            id = R.dimen.text_size
                        )
                            .value
                            .sp,
                        modifier = Modifier
                            .padding(
                                start = 16.dp
                            ),
                    )

                    Icon(
                        modifier = Modifier
                            .padding(
                                end = 16.dp
                            ),
                        painter = painterResource(
                            id = R.drawable.icon_expanded
                        ),
                        contentDescription = stringResource(
                            id = R.string.content_description_expanded_photos
                        )
                    )

                }

                // todo 6. Написать виджет
//                RowOfPhotos()

                Text(
                    text = stringResource(
                        id = R.string.pet_breed
                    ),
                    color = Blue200,
                    fontSize = dimensionResource(
                        id = R.dimen.text_size
                    )
                        .value
                        .sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(
                            start = 24.dp,
                            top = 12.dp
                        )
                )

                ConfiguredTextField(
                    modifier = Modifier
                        .height(44.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 12.dp
                        )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.5f), // todo 7. Как работает weight на любом layout? ,
                    ) {

                        Text(
                            text = stringResource(
                                id = R.string.pet_age
                            ),
                            color = Blue200,
                            fontSize = dimensionResource(
                                id = R.dimen.text_size
                            )
                                .value
                                .sp,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier
                                .padding(
                                    start = 24.dp
                                )
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = 4.dp,
                                ),
                        ) {

                            AgesContextMenu()

                        }

                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f), // todo 5. Как работает weight на любом layout?
                    ) {
                        Text(
                            text = stringResource(id = R.string.gender),
                            color = Blue200,
                            fontSize = dimensionResource(id = R.dimen.text_size)
                                .value.sp,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier
                                .padding(
                                    start = 24.dp
                                )
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 2.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            GenderSwitcher(
                                selectedGender = mGender,
                                visibleGenderMale = visibleGenderMale,
                            ) {
                                mGender = it
                                visibleGenderMale = mGender == "Самец"
                            }
                        }
                    }
                }
                Text(
                    text = stringResource(id = R.string.number_of_chip),
                    color = Blue200,
                    fontSize = dimensionResource(id = R.dimen.text_size)
                        .value.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(
                            start = 24.dp,
                            top = 4.dp
                        )
                )
                ConfiguredTextField(
                    modifier = Modifier
                        .height(height = 44.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )

                Text(
                    text = stringResource(id = R.string.pet_description),
                    color = Blue200,
                    fontSize = dimensionResource(id = R.dimen.text_size)
                        .value.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(
                            start = 24.dp,
                            top = 4.dp
                        )
                )
                ConfiguredTextField(
                    modifier = Modifier
                        .fillMaxHeight(),
                    singleLine = false,
                    maxLines = 5
                )

//                Column(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                ) {
//                    Spacer(
//                        modifier = Modifier
//                            .height(190.dp)
//                    )
//                    Button(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(56.dp)
//                            .padding(
//                                start = 8.dp,
//                                end = 8.dp
//                            ),
//                        shape = RoundedCornerShape(16.dp),
//                        onClick = {
//
//                        },
//                        contentPadding = PaddingValues(
//                            start = 16.dp,
//                            top = 4.dp,
//                            end = 16.dp,
//                            bottom = 4.dp
//                        )
//                    ) {
//                        Text(
//                            text = stringResource(id = R.string.save_changes),
//                            color = Color.White,
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
            }
        }
    }
}