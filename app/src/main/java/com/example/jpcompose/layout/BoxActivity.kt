package com.example.jpcompose.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.jpcompose.R
import com.example.jpcompose.ui.purple200

class BoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleBoxComponent()
        }
    }
}
@Composable
@Preview
fun SimpleBoxComponent() {
    // A Box is a layout composable that is used to place children relative to its edges.
    // Initially, Stack was used in place of Box. But now, Stack is deprecated and Box is introduced.
    // As the name suggests, the children are placed inside parent.

        Box(modifier = Modifier.background(color = purple200),) {
            val image = imageResource(R.mipmap.noodles)
            Image(image,modifier = Modifier.padding(10.dp),contentScale = ContentScale.FillWidth)
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                text = "I am a text over Image",
                fontSize = 16.sp,
                color = Color.Red
            )
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 36.dp),
                text = "I am a text over Image",
                fontSize = 16.sp,
                color = Color.Yellow
            )

        }
}