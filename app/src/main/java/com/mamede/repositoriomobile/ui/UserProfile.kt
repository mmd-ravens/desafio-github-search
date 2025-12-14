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

/**
 * Um Composable que exibe o perfil de um usuário do GitHub.
 *
 * Esta função de UI mostra a imagem de avatar do usuário de forma circular, seu nome de exibição
 * (ou login, como fallback), seu @login e sua biografia (se disponível).
 * A imagem é carregada de forma assíncrona usando a biblioteca Coil.
 *
 * @param user O objeto [User] contendo os dados a serem exibidos.
 * @param modifier O [Modifier] a ser aplicado ao contêiner principal do perfil.
 */
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


/**
 * Uma pré-visualização para o Composable [UserProfile].
 *
 * A anotação `@Preview` permite que o Android Studio renderize este Composable na janela de design.
 * Esta função cria um objeto [User] falso ("mock") com dados de exemplo para visualizar
 * o componente [UserProfile] sem a necessidade de executar o aplicativo ou fazer uma chamada de API.
 */
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