package com.example.myapplication.features.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object Spaces {

    @Composable
    fun Small() = Spacer(modifier = Modifier.size(15.dp))
    @Composable
    fun Medium() = Spacer(modifier = Modifier.size(20.dp))
    @Composable
    fun Large() = Spacer(modifier = Modifier.size(30.dp))
}