package com.agc.challengedojo.ui.screens.character

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CharacterScreen(viewModel: CharacterViewModel =  hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            state.errorMessage?.let {
                Text(text = it)
            }

            LazyColumn {
                items(state.characters) { character ->
                    Text(text = character.name, modifier = Modifier.padding(8.dp))
                    Divider()
                }
            }

            Button(
                onClick = { viewModel.refreshCharacters() },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Actualizar Personajes")
            }
        }
    }
}