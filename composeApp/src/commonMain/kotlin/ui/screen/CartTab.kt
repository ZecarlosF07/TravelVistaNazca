package ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import travelvista.composeapp.generated.resources.Res
import travelvista.composeapp.generated.resources.back

@Composable
fun CartTab() {
    val navigator = LocalNavigator.currentOrThrow

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Encabezado
        Text(
            text = "Bienvenido",
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "¿En qué provincia te encuentras ahora mismo?",
            fontSize = 18.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))

        // Lista de provincias
        ProvinceItem(
            name = "Chincha",
            imageRes = "chincha_image", // Reemplaza con tu recurso
            onClick = { navigator.push(HomeTab) }
        )
        ProvinceItem(
            name = "Ica",
            imageRes = "ica_image", // Reemplaza con tu recurso
            onClick = { /* Acción al seleccionar Ica */ }
        )
        ProvinceItem(
            name = "Pisco",
            imageRes = "pisco_image", // Reemplaza con tu recurso
            onClick = { /* Acción al seleccionar Pisco */ }
        )
        ProvinceItem(
            name = "Palpa",
            imageRes = "palpa_image", // Reemplaza con tu recurso
            onClick = { /* Acción al seleccionar Palpa */ }
        )
        ProvinceItem(
            name = "Nasca",
            imageRes = "nasca_image", // Reemplaza con tu recurso
            onClick = { /* Acción al seleccionar Nasca */ }
        )
    }
}



@Composable
fun ProvinceItem(name: String, imageRes: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen
        Image(
            painter = painterResource(Res.drawable.back), // Usa painterResource para cargar imágenes
            contentDescription = "$name image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(80.dp)
                .width(120.dp)
                .padding(end = 8.dp)
        )
        // Nombre de la provincia
        Text(
            text = name,
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
    }
}
