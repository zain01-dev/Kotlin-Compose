package com.example.jpcompose.text

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

class SimpleTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         // In the Column, we can pass some parameters such as modifier, verticalArrangement, horizontalAlignment, etc.

            // modifier is used to decorate or add behavior to UI elements. Here we are telling the
            // column to fill the maximum size of the screen
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SimpleText("simple Text")
                ClickableTextComponent(text = "Click Me I'm Text")
            }
        }
    }
}

@Composable
fun SimpleText(displayText: String) {
    Text(text = displayText)
}

@Preview
@Composable
fun SimpleTextPreview() {
    SimpleText("Hi I am learning Compose")
}





@Composable
fun ClickableTextComponent(text: String) {
    val context = ContextAmbient.current
    Text(text = text, style = TextStyle(fontSize = 16.sp, color = Color.Black),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable(onClick = {
                Toast
                    .makeText(context, "Thanks for clicking! I am Text", Toast.LENGTH_SHORT)
                    .show()
            }, onLongClick = {
                Toast
                    .makeText(context, "Thanks for LONG click! I am Text", Toast.LENGTH_SHORT)
                    .show()
            }, onDoubleClick = {
                Toast
                    .makeText(context, "Thanks for DOUBLE click! I am Text", Toast.LENGTH_SHORT)
                    .show()
            })
    )
}