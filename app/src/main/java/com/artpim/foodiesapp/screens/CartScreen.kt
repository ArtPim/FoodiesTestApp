package com.artpim.foodiesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W300
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.artpim.foodiesapp.R
import com.artpim.foodiesapp.Routes
import com.artpim.foodiesapp.SharedViewModel
import com.artpim.foodiesapp.common.SpacerHeight
import com.artpim.foodiesapp.common.SpacerWidth
import com.artpim.foodiesapp.ui.theme.GreyItemBack
import com.artpim.foodiesapp.ui.theme.OrangePrimary
import com.artpim.foodiesapp.ui.theme.WhiteBack

@Composable
fun CartScreen(navController: NavController, sharedViewModel: SharedViewModel) {

//    val productsItem = sharedViewModel.productsItem
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        Column {
            CartHeader(navController)
            CartList(navController)
            CartList(navController)
            CartList(navController)
            CartList(navController)
            CartList(navController)
            CartList(navController)
            CartList(navController)
        }
    }
}

// Заголовок корзины
@Composable
fun CartHeader(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(WhiteBack)
            .clickable { navController.navigate(Routes.home_screen) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BoxWithRes(
                resId = R.drawable.arrow_left,
                bgColor = WhiteBack,
                iconSize = 24,
                iconColor = Color.Black,
                description = "Back arrow icon",
                navController = navController
            )
            Text(
                text = "Корзина", style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Black,
                    fontStyle = FontStyle(R.font.roboto_bold)
                ), textAlign = TextAlign.Center
            )

        }
    }
}

// Настройка отображения элементов в корзине
@Composable
fun CartList(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(1.dp))
            .background(
                WhiteBack
            )
            .padding(10.dp)
            .clickable { navController.navigate(Routes.item_screen) }
    ) {
        Row(
            modifier = Modifier.fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.test_photo),
                contentDescription = "Product photo",
                modifier = Modifier
                    .size(96.dp)
                    .padding(end = 5.dp)
            )
            SpacerWidth(5.dp)
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontFamily = FontFamily.Default,
                            fontWeight = W300,
                            fontSize = 14.sp
                        )
                    ) {
                        append(
                            "Том Ям"
                        )
                    }
                })
                SpacerHeight(25.dp)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                        .align(Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BoxWithRes(
                        resId = R.drawable.ic_minus,
                        bgColor = GreyItemBack,
                        description = "Minus icon"
                    )
                    Text(text = "1")
                    BoxWithRes(
                        resId = R.drawable.ic_plus,
                        bgColor = GreyItemBack,
                        description = "Plus icon"
                    )
                    SpacerWidth(30.dp)
                    Text(
                        modifier = Modifier
                            .width(80.dp)
                            .height(46.dp)
                            .padding(8.dp),
                        text = "480 руб.", fontSize = 16.sp, fontWeight = W500,
                        textAlign = TextAlign.Companion.Center
                    )
                }
            }
        }
    }
    Divider(color = Color.DarkGray, thickness = 1.dp)
}

// Отображение иконок в приложении
@Composable
fun BoxWithRes(
    resId: Int,
    description: String,
    bgColor: Color? = GreyItemBack,
    iconColor: Color? = OrangePrimary,
    boxSize: Int? = 40,
    iconSize: Int = 24,
    navController: NavController? = null
) {

    Box(
        modifier = Modifier
            .size(boxSize!!.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                navController?.popBackStack()
            }
            .background(bgColor!!), contentAlignment = Alignment.Center
    )
    {
        Icon(
            painter = painterResource(id = resId),
            contentDescription = description,
            modifier = Modifier.size(iconSize.dp),
            tint = iconColor!!
        )
    }

}