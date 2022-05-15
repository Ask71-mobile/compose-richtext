package com.halilibo.richtext.markdown

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect

@Composable
internal actual fun HtmlBlock(content: String) {
  LaunchedEffect(Unit) {
    println("Html blocks are rendered literally in Compose Desktop!")
  }
  BasicText(content)
}
