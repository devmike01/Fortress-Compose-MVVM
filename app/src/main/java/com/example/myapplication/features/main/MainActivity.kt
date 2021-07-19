package com.example.myapplication.features.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.features.ui.screens.AddNewPassword
import com.example.myapplication.features.ui.screens.MainPasswordList
import com.example.myapplication.features.ui.screens.PasswordDetails
import com.example.myapplication.features.ui.StateCodelabTheme
import com.example.myapplication.utils.FingerprintUtils
import com.example.myapplication.utils.Routes
import java.util.*

@AndroidEntryPoint
class MainActivity @Inject constructor() : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    @Inject
    lateinit var fingerprintUtil : FingerprintUtils

    private lateinit var navController: NavHostController



    @ExperimentalCoroutinesApi
    @ExperimentalComposeApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContent{
            StateCodelabTheme(content = { MainContent() }, activity = this)
        }
    }

    @ExperimentalCoroutinesApi
    @ExperimentalComposeApi
    @Preview
    @Composable
    private fun MainContent() {
        navController = rememberNavController()

        var screenChangeAnimState by  remember { mutableStateOf(0F) }

        NavHost(navController = navController,
            startDestination = Routes.PASSWORD_MAIN) {
            composable(Routes.PASSWORD_MAIN) {MainPasswordList(this@MainActivity, viewModel, navController) }
            composable(Routes.PASSWORD_DETAILS) { PasswordDetails(this@MainActivity, viewModel) }
            composable(Routes.ADD_NEW_PASSWORD) {
                screenChangeAnimState = 1f
                AddNewPassword(fingerprintUtil, this@MainActivity, viewModel)
            }
        }


    }



}