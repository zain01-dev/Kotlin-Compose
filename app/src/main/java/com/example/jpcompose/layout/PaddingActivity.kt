package com.example.jpcompose.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.jpcompose.ui.purple200
import com.example.jpcompose.ui.purple500
import com.example.jpcompose.ui.purple700

class PaddingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                Column {
                    SamePaddingComponent()
                    CustomPaddingComponent()
                    OffsetComponent()
                    AspectRatioComponent()
                }
            }
        }
    }
}

@Composable
fun SamePaddingComponent() {
    // Surface is a composable provided to fulfill the needs of the "Surface" metaphor from the
    // Material Design specification. It's generally used to change the background color, add
    // elevation, clip or add background shape to its children composables.
    Surface(color = purple200) {
        Text(
            text = "This text has equal padding of 16dp in all directions",
            // You can think of Modifiers as implementations of the decorators pattern that are used to
            // modify the composable that its applied to. In this example, we assign a padding of
            // 16dp to the Text composable.
            modifier = Modifier.padding(16.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

@Composable
fun CustomPaddingComponent() {
    Surface(color = purple500) {
        Text(
            text = "This text has 32dp start padding, 4dp end padding, 32dp top padding & 0dp " +
                    "bottom padding padding in each direction",
            modifier = Modifier.padding(start = 32.dp, end = 4.dp, top = 32.dp, bottom = 0.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

@Composable
fun OffsetComponent() {
    //Modifier.offset modifier that allows the composable to be shifted along the x & y direction
    // by the user specified amount.
    Surface(color = purple700, modifier = Modifier.offset(x = 8.dp, y = 8.dp)) {
        Text(
            text = "This text is using an offset of 8 dp instead of padding. Padding also ends up" +
                    " modifying the size of the layout. Using offset instead ensures that the " +
                    "size of the layout retains its size.",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

@Composable
fun AspectRatioComponent() {
    Surface(
        color = purple200, modifier = Modifier.aspectRatio(16 / 9f).padding(top = 16.dp)//x ratio y x:y
    ) {
        Text(
            text = "This text is wrapped in a layout that has a fixed aspect ratio of 16/9",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview("Example with same padding applied to a composable")
@Composable
fun SamePaddingComponentPreview() {
    Column {
        SamePaddingComponent()
    }
}

@Preview("Example with custom padding in each direction applied to a composable")
@Composable
fun CustomPaddingComponentPreview() {
    Column {
        CustomPaddingComponent()
    }
}

@Preview("Example using offsets to position the composable")
@Composable
fun OffsetComponentPreview() {
    Column {
        OffsetComponent()
    }
}

@Preview("Example showing how a fixed aspect ration is applied a composable")
@Composable
fun AspectRatioComponentPreview() {
    Column {
        AspectRatioComponent()
    }
}