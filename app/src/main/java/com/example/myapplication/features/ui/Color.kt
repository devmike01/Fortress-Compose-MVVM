/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.myapplication.features.ui

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

val purple200 = Color(0xFFBB86FC)
val purple500 = Color(0xFF6200EE)
val purple700 = Color(0xFF3700B3)
val teal200 = Color(0xFF03DAC5)
val white100 = Color(0xFFFFFFFF)
val grey900 = Color(0xff212121)
val grey800 = Color(0xff424242)
val iconColor = Color(0xFFeceff1)
val scaffoldColor    = Color(0xFFe5e1e6)
val greyShade = Color(0x65424242)

val lightTeal= Color(0xD5009688)
val lightOrange= Color(0xCBFF5722)
//val lightTeal= Color(0xD5009688)

fun randomColor(): Color{
    val rand = Random(200)
    val r: Float = rand.nextFloat()
    val g: Float = rand.nextFloat() / 2f
    val b: Float = rand.nextFloat() / 2f
    return Color(r, g, b)
}
