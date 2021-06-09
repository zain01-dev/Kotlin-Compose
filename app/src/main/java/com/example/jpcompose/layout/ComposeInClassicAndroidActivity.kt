package com.example.jpcompose.layout

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpcompose.R
import com.example.jpcompose.ui.purple200
import com.example.jpcompose.ui.purple500


class ComposeInClassicAndroidActivity : AppCompatActivity() {
    private lateinit var containerLayout: ComposeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose_in_classic_android)
        containerLayout = findViewById(R.id.compose_view)
        containerLayout.setContent {
            CardComponentWithMessage()
        }
    }
}

@Composable
fun CardComponentWithMessage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
                .preferredHeight(200.dp)
                .padding(16.dp),
            backgroundColor = purple200,
        ) {
            Text(
                "This is an example of a Jetpack Compose composable inside a classic Android " +
                        "view",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W900,
                    fontSize = 14.sp,
                    color = purple500
                ),
                modifier = Modifier.padding(16.dp).fillMaxWidth()
            )
        }
    }
}
@Composable
fun CardComponentWithMessagePreview() {
    CardComponentWithMessage()
}