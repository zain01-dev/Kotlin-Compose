package com.example.jpcompose.text

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BaseTextField
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview

class EditTextFieldActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn{
                SimpleTextComponent("Example of Simple Text Field")
                SimpleTextFieldComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Material Text Field")
                SimpleMaterialTextFieldComponent()
                Divider(color = Color.Gray)
            }
            ScrollableColumn{
                SimpleTextComponent("Example of Simple Text Field")
                SimpleTextFieldComponent()
                Divider(color = Color.Gray)

                SimpleTextComponent("Example of Material Text Field")
                SimpleMaterialTextFieldComponent()
                Divider(color = Color.Gray)
            }
        }
    }
}
@Composable
fun SimpleTextComponent(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    )
}
@ExperimentalFoundationApi
@Composable
@Preview
fun SimpleTextFieldComponent() {
    // Surface as the name suggests is used to have some UI elements over it. You can provide some
    // color, contentColor, shape, border, elevation, etc to a surface. If no contentColor is passed
    // then the surface will try to match its color with the background color.
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var text by remember { mutableStateOf(TextFieldValue("Enter text here")) }
        // BaseTextField is a composable that is used to take input. It is similar to EditText.
        // onValueChange will be called when there is a change in content of text field.
        BaseTextField(
            value = text,
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            keyboardType = KeyboardType.Number, // KeyboardType.Password
            onValueChange = {
                text = it
            }
        )
    }
}

@Composable
@Preview
fun SimpleMaterialTextFieldComponent() {
    // savedInstanceState behaves similarly to remember { mutableStateOf(...) }, but the stored value
    // will survive the activity or process recreation using the saved instance state mechanism
    // (for example it happens when the screen is rotated in the Android application)
    var text by savedInstanceState { "" }
    // TextField is a Material Design implementation of EditText in Compose.
    // label is the text that is displayed inside the TextField when no text is there
    TextField(
        value = text,
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        keyboardType = KeyboardType.Text,
        onValueChange = { text = it },
        label = { Text("Material Edit Text") }
    )
}