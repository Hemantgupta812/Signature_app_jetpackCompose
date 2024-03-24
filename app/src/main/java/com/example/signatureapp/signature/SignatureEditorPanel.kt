package com.example.signatureapp.signature

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.signatureapp.R
import com.example.signatureapp.ShareActivity
import com.example.signatureapp.ui.theme.SignatureAppTheme

class SignatureEditorPanel : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            MyCanvas()
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = getString(R.string.signature_app))
                        },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Menu, contentDescription = "menu")
                            }
                        },
                        actions = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Notifications, contentDescription = "noti")
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Search, contentDescription = "search")
                            }
                        }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.Add, contentDescription = "add")
                        }

                    }
                },
                floatingActionButtonPosition = FabPosition.End
            ) {

                Text(text = "Hello World")
            }
//            HomeScreen {
//
//                CoroutineScope(Dispatchers.IO).launch {
//                    val uri = saveImage(it)
//                    withContext(Dispatchers.Main) {
//                        startActivity(activityChooser(uri))
//                    }
//                }
//
//            }

        }
    }

}

@Composable
private fun MyCanvas() {

    Canvas(
        modifier = Modifier
            .padding(20.dp)
            .size(300.dp)
    ) {

        drawRect(size = size, color = Color.Blue)
        drawRect(size = size, topLeft = Offset(150f, 150f), color = Color.DarkGray)

    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Text(
        text = "Hello $name!",
        modifier = modifier.clickable {
            val intent = Intent(context, ShareActivity::class.java)
            context.startActivity(intent) // Start the activity
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SignatureAppTheme {
//        Greeting("Android")
    }
}