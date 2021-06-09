package com.example.jpcompose.button

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                SimpleButtonComponent()
                Divider(color = Color.Gray)
                ButtonWithIconComponent()
            }
        }
    }
}
@Composable
@Preview
fun SimpleButtonComponent() {
    val context = ContextAmbient.current
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking! I am Button", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text("Click Me")
    }
}

@Composable
@Preview
fun ButtonWithIconComponent() {
    val context = ContextAmbient.current
    // You can put some icon on the Button by using Icon Composable.
    Button(
        onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green))
    ) {
        Text("Click Me")
        Icon(Icons.Filled.Favorite)
    }
}