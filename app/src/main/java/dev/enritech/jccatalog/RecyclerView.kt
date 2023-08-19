package dev.enritech.jccatalog

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.enritech.jccatalog.model.Superhero

@Composable
fun SimpleRecyclerView() {
    val friends = listOf("Nishsme", "Ever", "Jona", "Ale", "Yerko", "Rodri", "Chris")
    LazyColumn {
        item {
            Text(text = "Header")
        }
        items(count = 4) {
            Text(text = "This is the item $it")
        }
        items(friends) {
            Text(text = "Hola, friend $it")
        }
        item {
            Text(text = "Footer")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperheroesGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp)
    ) {
        items(items = getSuperheroes()) { superheroItem ->
            SuperheroItem(superhero = superheroItem) { superhero ->
                Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SuperheroesView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = getSuperheroes()) { superheroItem ->
            SuperheroItem(superhero = superheroItem) { superhero ->
                Toast.makeText(context, superhero.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SuperheroItem(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superhero) }) {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = "superhero avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(4.dp),
                fontSize = 10.sp
            )
        }
    }
}

fun getSuperheroes(): List<Superhero> {
    return listOf(
        Superhero(
            superheroName = "Batman",
            realName = "Bruce Wayne",
            publisher = "DC Comics",
            photo = R.drawable.batman
        ),
        Superhero(
            superheroName = "Daredevil",
            realName = "Matthew Murdock",
            publisher = "Marvel",
            photo = R.drawable.daredevil
        ),
        Superhero(
            superheroName = "Flash",
            realName = "Barry Allen",
            publisher = "DC Comics",
            photo = R.drawable.flash
        ),
        Superhero(
            superheroName = "Green lantern",
            realName = "Alan Scott",
            publisher = "DC Comics",
            photo = R.drawable.green_lantern
        ),
        Superhero(
            superheroName = "Wolverine",
            realName = "James Logan",
            publisher = "Marvel",
            photo = R.drawable.logan
        ),
        Superhero(
            superheroName = "Spider-Man",
            realName = "Peter Parker",
            publisher = "Marvel",
            photo = R.drawable.spiderman
        ),
        Superhero(
            superheroName = "Thor",
            realName = "Donald Blake",
            publisher = "Marvel",
            photo = R.drawable.thor
        ),
        Superhero(
            superheroName = "Wonder Woman",
            realName = "Diana de Temiscira",
            publisher = "DC Comics",
            photo = R.drawable.wonder_woman
        )
    )
}

@Preview(showBackground = true)
@Composable
fun RecyclerViewPreview() {
    SimpleRecyclerView()
}