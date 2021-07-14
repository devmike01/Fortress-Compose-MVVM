package com.example.myapplication.features.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.features.main.MainActivity
import com.example.myapplication.features.main.MainActivityViewModel
import com.example.myapplication.features.ui.randomColor
import com.example.myapplication.repository.database.PasswordEntity
import com.example.myapplication.utils.Routes


@Composable
fun MainPasswordList(activity: MainActivity,
                     viewModel : MainActivityViewModel,
                     navController: NavHostController) {



    val savePassword :
            List<PasswordEntity> by viewModel.savePasswordEntityLiveData.observeAsState(emptyList())

    Column(verticalArrangement = Arrangement.Center) {
        SavePasswordContents(activity, list = savePassword, navController)
    }
}


@Composable
fun SavePasswordContents(activity: MainActivity, list: List<PasswordEntity>, navController: NavHostController){
    //passwordEntityList

    val lazyState = rememberLazyListState()
    LazyColumn(
        state = lazyState,
        contentPadding = PaddingValues(all = Dp(value = 10f))
    ) {
        items(list) {passwordEntity ->
            //fadeInItemState.setValue()
            SavedPasswordItem(activity, passwordEntity = passwordEntity, navController)
        }
    }
}

@Composable
fun SavedPasswordItem(activity: MainActivity, passwordEntity: PasswordEntity, navController: NavHostController){

    Card(elevation = 5.dp,
        shape = RoundedCornerShape(10),
        modifier = Modifier.clickable {
            navController.navigate(Routes.PASSWORD_DETAILS)
        }
    ) {
        Row(modifier =
        Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box( modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(2.dp, randomColor(), CircleShape)
                .background(randomColor())) {
                Center {
                    Text(passwordEntity.websiteName[0].toString().uppercase(),
                        textAlign = TextAlign.Center,
                        fontSize = 17.sp,
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.wrapContentSize())
                }
            }
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(text = passwordEntity.websiteName, fontWeight = FontWeight.Bold)
                Text(text = passwordEntity.website, color = Color.Gray)
            }
        }
    }
}

@Composable
fun Center(content: @Composable ColumnScope.() -> Unit){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content)
}