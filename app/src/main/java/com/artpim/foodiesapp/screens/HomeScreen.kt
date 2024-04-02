package com.artpim.foodiesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositeKeyHash
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.artpim.foodiesapp.data.ProductsItem
import com.artpim.foodiesapp.data.categoriesList
import com.artpim.foodiesapp.data.productsList
import com.artpim.foodiesapp.ui.theme.Dark
import com.artpim.foodiesapp.ui.theme.GreyItemBack
import com.artpim.foodiesapp.ui.theme.OrangePrimary
import com.artpim.foodiesapp.ui.theme.WhiteBack

@Composable
fun HomeScreen(navController: NavController, sharedViewModel: SharedViewModel) {

    val menuList = categoriesList
    var currentMenuState by remember { mutableStateOf("Горячие блюда") }
    val scrollState = rememberScrollState()
//    var isButtonPriceClicked: Boolean = false

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBack)
    ) {
        Column {
            PizzaHeader()
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(scrollState)
                        .background(WhiteBack)
                ) {
                    menuList.forEach {
                        CustomCategory(
                            name = it.name,
                            selected = it.component2() == currentMenuState
                        ) { data ->
                            currentMenuState = data
                        }
                    }
                }
            }
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(productsList) {
                    ShowProducts(
                        productsItem = it.copy(),
                        navController = navController,
                        sharedViewModel = sharedViewModel
                    )
                }
            }
        }
//        if (!isButtonPriceClicked){
//            ExtendedCartButton(
//                modifier = Modifier
//                    .padding(horizontal = 10.dp, vertical = 10.dp)
//                    .align(Alignment.BottomCenter), productsItem = productsList[currentCompositeKeyHash]
//            )
//            isButtonPriceClicked = true
//        }

    }

}

@Composable
fun ExtendedCartButton(
    modifier: Modifier,
    productsItem: ProductsItem
) {
    Box(
        modifier = modifier
            .height(40.dp)
            .width(375.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(OrangePrimary)
    ) {
        Text(
            text = "В корзину за ${productsItem.price_current} руб.", style = TextStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.W600,
                color = Color.White
            ),
            modifier = Modifier.align(Center)
        )
    }
}

@Composable
fun ShowProducts(
    productsItem: ProductsItem,
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val cartList = sharedViewModel.addItem(productsItem)
    Card(
        modifier = Modifier
            .width(167.5.dp)
            .height(320.dp)
            .padding(vertical = 5.dp, horizontal = 5.dp)
            .background(GreyItemBack)
            .clickable {
                navController.navigate(Routes.item_screen)
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Center) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp, horizontal = 5.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.test_photo), contentDescription = "",
                    modifier = Modifier.size(167.5.dp)
                )
                SpacerHeight(5.dp)
                Text(
                    text = productsItem.name, style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        fontStyle = FontStyle(R.font.roboto_medium)
                    ), textAlign = TextAlign.Start
                )

                SpacerHeight(5.dp)
                Text(
                    text = "${productsItem.measure} ${productsItem.measure_unit}",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        fontStyle = FontStyle(R.font.roboto_thin)
                    ),
                    textAlign = TextAlign.Start
                )
                SpacerHeight(25.dp)
                Button(
                    onClick = {
                        navController.navigate(Routes.cart_screen)
                    },
                    modifier = Modifier
                        .width(143.5.dp)
                        .height(40.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        WhiteBack
                    )
                ) {
                    Text(
                        text = "${productsItem.price_current} руб.", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500,
                            color = Color.Black,
                            fontStyle = FontStyle(R.font.roboto_bold)
                        ), textAlign = TextAlign.Companion.Center
                    )
                }
            }

        }
    }

}

@Composable
fun PizzaHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(WhiteBack)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 5.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            BoxWithRes(
                resId = R.drawable.filter,
                bgColor = WhiteBack,
                iconColor = Color.Black,
                boxSize = 44,
                iconSize = 24,
                description = "Filter icon"
            )
            Image(
                painter = painterResource(id = R.drawable.logo), contentDescription = "",
                modifier = Modifier.size(271.dp)
            )
            BoxWithRes(
                resId = R.drawable.search,
                bgColor = WhiteBack,
                iconColor = Color.Black,
                boxSize = 44,
                iconSize = 24,
                description = "Search icon"
            )
        }
    }
}

@Composable
fun CustomCategory(
    name: String,
    selected: Boolean,
    onValueChange: (String) -> Unit
) {
    TextButton(
        onClick = {
            onValueChange(name)
        },
        shape = RoundedCornerShape(8.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        colors = ButtonDefaults.buttonColors(
            if (selected) OrangePrimary else Color.Transparent
        ),
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)
    ) {
        Text(
            text = name, style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = if (selected) Color.White else Dark
            )
        )
    }
}