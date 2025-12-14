package com.mamede.repositoriomobile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mamede.repositoriomobile.data.User

@Composable
fun UserProfile(user: User, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        //imagem do Perfil
        AsyncImage(
            model = user.avatarUrl,
            contentDescription = "Foto de perfil de ${user.login}",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape), // imagem redonda
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))

        //nome do usuario do perfi
        Text(
            //poderia usar o let?
            // user.name?. {it} ?: user.login ?
            text = user.name ?: user.login,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        //login (handle)
        Text(
            text = "@${user.login}",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary
        )

        //Bio?
        if (!user.bio.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = user.bio,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfilePreview() {
    //criar user falso para testar
    val fakeUser = User(
        "mmd",
        "",
        "",
        "Android Developer Student",
        "Criando apps incríveis com Kotlin e JetpackCompose"
    )
    UserProfile(user = fakeUser)
}