package com.rphdev.curlcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rphdev.curlcounter.ui.theme.CurlCounterTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CurlCounterApp() }
           /* Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                MainScreen() */
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        EquipmentScreen()
        ImageScreen()
        RepScreen()
        SetScreen()
        EnterScreen()
    }
}

@Composable
fun EquipmentScreen() {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Text(
        ("Dumbell Curl"),
        color = Color.Red,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 15.dp, bottom = 10.dp, start = 10.dp, end = 10.dp)
    )
}

@Composable
fun ImageScreen() {
 //   Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Image(
        painter = painterResource(id = R.drawable.barbellcurl),
        contentDescription = "",
        modifier = Modifier
            .padding(10.dp)
            .width(300.dp)
            .height(200.dp)
            .clip(shape = RoundedCornerShape(30.dp))
            .border(
                BorderStroke(2.dp, Color.Black)
            )
    )
}


@Composable
fun RepScreen() {

    val count: MutableState<Int> = mutableStateOf(0)

    Button(onClick = { count.value++ }) {
        Text(
            text = stringResource(R.string.add_rep),
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        )
    }

    @Composable
    fun SetScreen() {
        Text(
            "You've done ${count.value} Sets",
            modifier = Modifier.padding(top = 8.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    fun EnterScreen() {
        var textState by remember { mutableStateOf("") }
        TextField(
            value = textState,
            onValueChange = { textState = it })

        Button(
            onClick = { /*TODO*/ }) {
            Text(text = stringResource(R.string.add_set))
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.width(500.dp)
        ) {
            LazyColumn {
                items(3) { index ->
                    Text("Date #$index")
                }
            }
            LazyColumn {
                items(3) { index ->
                    Text("Weight #$index")
                }
            }
            LazyColumn {
                items(3) { index ->
                    Text("Reps #$index")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MainScreen()
    }
}





















































    /*@Composable
    fun GroceriesScreen() {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            var groceriesState by remember { mutableStateOf(listOf("Milk", "Water")) }
            GroceryInput { item ->
                groceriesState = groceriesState + listOf(item)
            }
            GroceryList(groceriesState)
        }
    }


    @Composable
    fun GroceryInput(
        onGroceryItemAdded: (String) -> Unit
    ) {
        var textState by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textState, onValueChange = { textState = it },
            label = { Text(text = stringResource(R.string.new_item)) }
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                onClick = {
                    onGroceryItemAdded(textState)
                    textState = ""
                }
            ) {
                Text(text = stringResource(R.string.add_item))
            }
        }
    }

    @Composable
    fun GroceryList(groceries: List<String>) {
        LazyColumn {
            items(groceries.size) { index ->
                Text(text = groceries[index])
            }
        }
    } */





