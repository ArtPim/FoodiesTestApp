package com.artpim.foodiesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.artpim.foodiesapp.R
import com.artpim.foodiesapp.Routes
import com.artpim.foodiesapp.SharedViewModel
import com.artpim.foodiesapp.common.SpacerHeight
import com.artpim.foodiesapp.ui.theme.OrangePrimary
import com.artpim.foodiesapp.ui.theme.WhiteBack

@Composable
fun ItemScreen(navController: NavController, sharedViewModel: SharedViewModel) {

    val productsItem = sharedViewModel.productsItem
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBack)
            .verticalScroll(scrollState),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {
            BoxWithRes(resId = R.drawable.arrow_left, iconColor = Color.Black, bgColor = WhiteBack, description = "Back arrow icon", navController = navController)

            Image(
                painter = painterResource(id = R.drawable.test_photo), contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp), Alignment.TopCenter
            )
            SpacerHeight(5.dp)
            productsItem?.name?.let {
                Text(
                    text = it, style = TextStyle(
                        fontSize = 34.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        fontStyle = FontStyle(R.font.roboto_medium)
                    ), textAlign = TextAlign.Start
                )
            }
            SpacerHeight(5.dp)
            productsItem?.description?.let {
                Text(
                    text = it,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        fontStyle = FontStyle(R.font.roboto_medium)
                    ), textAlign = TextAlign.Start
                )
            }
            SpacerHeight(10.dp)
            Divider(color = Color.DarkGray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Вес",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        fontStyle = FontStyle(R.font.roboto_medium)
                    ), textAlign = TextAlign.Start
                )
                if (productsItem != null) {
                    Text(
                        text = "${productsItem.measure} ${productsItem.measure_unit}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = Color.Black,
                            fontStyle = FontStyle(R.font.roboto_medium)
                        ), textAlign = TextAlign.End
                    )
                }
            }
            Divider(color = Color.DarkGray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Энерг. ценность",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        fontStyle = FontStyle(R.font.roboto_medium)
                    ), textAlign = TextAlign.Start
                )
                if (productsItem != null) {
                    Text(
                        text = "${productsItem.energy_per_100_grams} ${productsItem.measure_unit}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = Color.Black,
                            fontStyle = FontStyle(R.font.roboto_medium)
                        ), textAlign = TextAlign.End
                    )
                }
            }
            Divider(color = Color.DarkGray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Белки",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        fontStyle = FontStyle(R.font.roboto_medium)
                    ), textAlign = TextAlign.Start
                )
                if (productsItem != null) {
                    Text(
                        text = "${productsItem.proteins_per_100_grams} ${productsItem.measure_unit}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = Color.Black,
                            fontStyle = FontStyle(R.font.roboto_medium)
                        ), textAlign = TextAlign.End
                    )
                }
            }
            Divider(color = Color.DarkGray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Жиры",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        fontStyle = FontStyle(R.font.roboto_medium)
                    ), textAlign = TextAlign.Start
                )
                if (productsItem != null) {
                    Text(
                        text = "${productsItem.fats_per_100_grams} ${productsItem.measure_unit}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = Color.Black,
                            fontStyle = FontStyle(R.font.roboto_medium)
                        ), textAlign = TextAlign.End
                    )
                }
            }
            Divider(color = Color.DarkGray, thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Угледовы",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        fontStyle = FontStyle(R.font.roboto_medium)
                    ), textAlign = TextAlign.Start
                )
                if (productsItem != null) {
                    Text(
                        text = "${productsItem.carbohydrates_per_100_grams} ${productsItem.measure_unit}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = Color.Black,
                            fontStyle = FontStyle(R.font.roboto_medium)
                        ), textAlign = TextAlign.End
                    )
                }
            }
            Divider(color = Color.DarkGray, thickness = 1.dp)
            SpacerHeight(25.dp)
            Button(
                onClick = { navController.navigate(Routes.cart_screen) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    OrangePrimary
                )
            ) {
                Text(
                    text = "В корзину за ${productsItem?.price_current} руб.", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500,
                        color = Color.White,
                        fontStyle = FontStyle(R.font.roboto_bold)
                    ), textAlign = TextAlign.Companion.Center
                )
            }
        }
    }
}