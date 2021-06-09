package com.example.jpcompose.image
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.jpcompose.R
class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    text = "This is a Simple Image"
                )
                SimpleImageComponent()
                Text(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    text = "This is an image with rounded corners"
                )
                RoundedImageComponent()
            }
        }
    }
}
@Composable
@Preview
fun SimpleImageComponent() {
    // Image is a composable that is used to display some image.
    val image = imageResource(R.mipmap.noodles)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(image)
    }
}

@Composable
@Preview
fun RoundedImageComponent() {
    val image = imageResource(R.mipmap.noodles)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        // contentScale is used to find the scaling aspect ratio
        Image(
            image,
            modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit
        )
    }
}