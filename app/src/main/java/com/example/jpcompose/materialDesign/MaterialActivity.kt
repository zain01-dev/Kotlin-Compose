package com.example.jpcompose.materialDesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.core.content.PermissionChecker
import androidx.ui.tooling.preview.Preview
import com.example.jpcompose.text.SimpleTextComponent

class MaterialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn(modifier = Modifier.fillMaxSize()) {
                SimpleTextComponent(text = "Bottom Appbar")
                BottomAppBarComponent()
                SimpleTextComponent(text = "Top Appbar")
                TopAppBarComponent()

                SimpleTextComponent(text = "Bottom Navigation with Label(Always)")
                BottomNavigationWithLabelComponent()

                SimpleTextComponent(text = "CheckBox Example")
                CheckboxComponent()

                SimpleTextComponent(text = "Circular Progress")
                CircularProgressComponent()

                SimpleTextComponent(text = "Radio Button Example")
                RadioButtonComponent()

                SimpleTextComponent(text = "Snackbar Example")
                SnackbarComponent()

                SimpleTextComponent(text = "Switch Example")
                SwitchComponent()

            }
        }
    }
}
@Composable
@Preview
fun BottomAppBarComponent() {
    // BottomAppBar is a composable that is placed at the bottom of the screen and it contains
    // some actions that are related to the current screen.
    BottomAppBar(
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        // Here, this is a RowScope and due this, all the children will be placed
        // horizontally.

        // IconButton consists of an Icon that is behaving like a button. You can think
        // of this as a clickable image.
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Menu)
        }
        // Spacer is used to provide some space in between UI elements
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Favorite)
        }
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Favorite)
        }
    }
}
@Composable
@Preview
fun TopAppBarComponent() {
    // TopAppBar is generally used to have the app name or icon for navigation drawer.
    // Basically it is the AppBar that we use in Android.
    TopAppBar(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        title = { Text("App Name") },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Menu)
            }
        },
        actions = {
            // Here, this is a RowScope and due to this, all children will be placed
            // horizontally.
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite)
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Favorite)
            }
        }
    )
}

@Composable
fun BottomNavigationWithLabelComponent() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Blogs", "Profile")

    BottomNavigation(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        backgroundColor = Color.Black,
        contentColor = Color.Yellow
    ) {
        items.forEachIndexed { index, item ->
            // BottomNavigationItem is used to add items to a BottomNavigation and since the
            // BottomNavigation is having a RowScope, so the BottomNavigationItems will be
            // placed horizontally.
            BottomNavigationItem(
                label = { Text(text = item) },
                icon = { Icon(Icons.Filled.Favorite) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}
@Composable
@Preview
fun CheckboxComponent() {
    val checkedState = remember { mutableStateOf(true) }
    Row {
        // checked is used to identify or set if the checkbox is checked or not
        // onCheckedChange is called when there is a change in the checkbox
        Checkbox(
            checked = checkedState.value,
            modifier = Modifier.padding(16.dp),
            onCheckedChange = { checkedState.value = it },
        )
        Text(text = "Checkbox Example", modifier = Modifier.padding(16.dp))
    }
}

@Composable
@Preview
fun CircularProgressComponent() {
    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
}

@Composable
@Preview
fun RadioButtonComponent() {
    val radioOptions = listOf("Right", "Left", "Around")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier.fillMaxWidth().selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    ).padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
@Composable
@Preview
fun SnackbarComponent() {
    Snackbar(
        modifier = Modifier.padding(16.dp),
        text = {
            Text(text = "I'm a Simple Snackbar")
        }
    )
}

@Composable
fun SwitchComponent() {
    val checkedState = remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.padding(16.dp),
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}