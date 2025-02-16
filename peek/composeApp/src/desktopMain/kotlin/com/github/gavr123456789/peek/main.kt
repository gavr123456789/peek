package com.github.gavr123456789.peek

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "peek",
    ) {
        App()
    }
}