package org.example.d9kmptemplate

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "D9KmpTemplate",
    ) {
        App()
    }
}