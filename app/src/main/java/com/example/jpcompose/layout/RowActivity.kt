package com.example.jpcompose.layout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.jpcompose.data.Book
import com.example.jpcompose.data.getBooksList

class RowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                SimpleRowComponent()
                Text(
                    "Scroll Horizontally --->",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Red
                    ),
                    modifier = Modifier.padding(16.dp)
                )
                ScrollableRowComponent(bookList = getBooksList())
                Text(
                    "Lazy Scroll Horizontally <--->",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Red
                    ),
                    modifier = Modifier.padding(16.dp)
                )
                LazyRowScrollableComponent(bookList = getBooksList())
            }
        }
    }
}
@Composable
@Preview
fun SimpleRowComponent() {
    // Row is used to keep the child horizontally.
    Row(modifier = Modifier.padding(16.dp)) {
        Text(text = "Hello! I am Text 1", color = Color.Black)
        Text(text = "Hello! I am Text 2", color = Color.Blue)
        Text(text = "Hello! I am Text 3", color = Color.Red)
    }
}
@Composable
fun ScrollableRowComponent(bookList: List<Book>) {
    // ScrollableRow is a composable that is used to keep all its children in horizontal orientation
    // and at the same time it is scrollable also i.e. when the content will cover the whole width of
    // the screen, then you can scroll right and see other contents. It behaves similar to horizontal
    // ScrollView.
    ScrollableRow(modifier = Modifier.fillMaxWidth(), children = {
        Row {
            for (book in bookList)
            {
                Card(
                    shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(16.dp),
                    backgroundColor = Color(0xFFFFA867.toInt())
                ) {
                    Text(
                        book.name,
                        style = TextStyle(fontSize = 16.sp), modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    })
}

@Composable
fun LazyRowScrollableComponent(bookList: List<Book>) {
    // As the name suggests, LazyRowFor will load only that elements that are currently
    // visible on the screen. When you scroll horizontally then other elements of the row will be
    // loaded(kind of similar to RecyclerView).
    LazyRowFor(items = bookList, modifier = Modifier.fillMaxHeight()) { book ->
        val context = ContextAmbient.current
        // Card is a Composable that is used to give the layout of a CardView in Compose.
        Card(shape = RoundedCornerShape(4.dp),
            modifier = Modifier.padding(16.dp).clickable(onClick = {
                Toast.makeText(context, "Author: ${book.author}", Toast.LENGTH_SHORT).show()
            }),
            backgroundColor = Color(0xFFFFA867.toInt())
        ) {
            Text(book.name, style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Center)
                , modifier = Modifier.padding(16.dp)
            )
        }
    }
}