package com.example.jpcompose.card

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.jpcompose.R
import com.example.jpcompose.data.Book

class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleCardComponent()
                Divider(color = Color.Gray)
                RoundedCornerCardComponent()
                Divider(color = Color.Gray)
                ClickableCardComponent()
                Divider(color = Color.Gray)
                BorderedCardComponent()
                Divider(color = Color.Gray)
            }
        }
    }
}
@Composable
@Preview
fun SimpleCardComponent() {
    // Card is a composable that is used to make a CardView.
    Card(
        backgroundColor = Color(0xFFFFA887.toInt()),
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text(
            text = "Simple Card",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
@Preview
fun RoundedCornerCardComponent() {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFBBBB867.toInt()),
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text(
            text = "Rounded Corner Card",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
@Preview
fun ClickableCardComponent() {
    val context = ContextAmbient.current
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xAAAAA567.toInt()),
        modifier = Modifier.padding(16.dp).fillMaxWidth().clickable(onClick = {
            Toast.makeText(context, "Thanks for clicking!", Toast.LENGTH_SHORT).show()
        })
    ) {
        Text(
            text = "Clickable Card",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
@Preview
fun BorderedCardComponent() {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFFFFA867.toInt()),
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Green)),
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text(
            text = "Bordered Card",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}
