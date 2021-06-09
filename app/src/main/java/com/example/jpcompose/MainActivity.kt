package com.example.jpcompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.jpcompose.button.ButtonActivity
import com.example.jpcompose.card.CardActivity
import com.example.jpcompose.data.Book
import com.example.jpcompose.dialog.AlertDialog
import com.example.jpcompose.image.ImageActivity
import com.example.jpcompose.layout.*
import com.example.jpcompose.materialDesign.MaterialActivity
import com.example.jpcompose.text.EditTextFieldActivity
import com.example.jpcompose.text.SimpleTextActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn {
                val context = ContextAmbient.current
                DrawButton(
                    context = context,
                    intent = Intent(context, SimpleTextActivity::class.java),
                    buttonText = "Simple Text"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, EditTextFieldActivity::class.java),
                    buttonText = "EditText"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, ButtonActivity::class.java),
                    buttonText = "Button"
                )
                DrawButton(
                    context = context,
                    intent = Intent(context, ImageActivity::class.java),
                    buttonText = "Image"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, LazyColumnActivity::class.java),
                    buttonText = "Lazy Column"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, ScrollableColumnActivity::class.java),
                    buttonText = "Scrollable Column"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, RowActivity::class.java),
                    buttonText = "Row"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, BoxActivity::class.java),
                    buttonText = "Box"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, ConstraintLayoutActivity::class.java),
                    buttonText = "Constraint Layout"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, CardActivity::class.java),
                    buttonText = "Card"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, AlertDialog::class.java),
                    buttonText = "Alert Dialog"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, MaterialActivity::class.java),
                    buttonText = "Material components"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, PaddingActivity::class.java),
                    buttonText = "Apply Padding / offset / AspectRatio"
                )
                Divider(color = Color.Black)
                DrawButton(
                    context = context,
                    intent = Intent(context, ComposeInClassicAndroidActivity::class.java),
                    buttonText = "Compose In Classic Layout"
                )
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    @Composable
    fun DrawButton(context: Context, intent: Intent, buttonText: String) {
        Button(
            onClick = {
                context.startActivity(intent)
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.Gray
        ) {
            Text(
                modifier = Modifier.fillMaxSize().padding(8.dp),
                text = buttonText,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}
