package com.mamede.repositoriomobile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mamede.repositoriomobile.data.User
import com.mamede.repositoriomobile.data.model.Repository

@Composable
fun SuccessScreen(user: User, repositories: List<Repository>){

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp) // espaçamento entre os itens
    ) {
        //item: cabeçalho
        item {
            UserProfile(user = user)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Repositórios",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        //lista de itens: Os Repositórios
        items(repositories) {
            RepositoryItem(repository = it)
        }
    }
}

@Composable
fun RepositoryItem(repository: Repository){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ){
        Column(
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        ){

            //nome do repositorio
            Text(
                text = repository.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(4.dp))

            //descrição?
            repository.description?.let {
                Text(
                    text = repository.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                repository.language?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.background(
                            MaterialTheme.colorScheme.primaryContainer,
                            MaterialTheme.shapes.small
                        ).padding(horizontal = 8.dp, vertical = 4.dp),
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

//            if (repository.language != null) {
//                Text(
//                    text = repository.language,
//                    style = MaterialTheme.typography.labelMedium,
//                    modifier = Modifier
//                        .background(
//                            MaterialTheme.colorScheme.primaryContainer,
//                            MaterialTheme.shapes.small
//                        )
//                        .padding(horizontal = 8.dp, vertical = 4.dp),
//                    color = MaterialTheme.colorScheme.onPrimaryContainer
//                )
//                Spacer(modifier = Modifier.width(16.dp))
//            }

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Estrelas",
                tint = Color(0xFFFFC107), // dourada
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = repository.stargazersCount.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}