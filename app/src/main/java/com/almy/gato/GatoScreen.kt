package com.almy.gato

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.almy.gato.components.*
import com.almy.gato.ui.theme.*


@Composable
fun GatoScreen(viewModel: GatoViewModel) {
    val state = viewModel.uiStateGato.collectAsState().value

    val jugador1 = remember{ mutableStateOf("") }
    val jugador2 = remember{ mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.LightGray)
    ){
        Column(
            modifier = Modifier.size(500.dp,50.dp).background(Purple200).align(Alignment.CenterHorizontally),
        ) {
            TitleText(text = " JUEGO DEL GATO",Modifier.align(Alignment.CenterHorizontally))
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
            for (i in 1..3){
                state.botones.get(i)?.let {
                    CustomButton(text = it) {
                        if (state.jugadorTurno == "Jugador X")
                        {
                            viewModel.actualizarBoton(i,"X")
                            viewModel.cambiarTurno(state.jugadorTurno)
                            jugador1.value += i.toString()
                        }
                        else{
                            viewModel.actualizarBoton(i,"O")
                            viewModel.cambiarTurno(state.jugadorTurno)
                            jugador2.value += i.toString()

                        }
                        viewModel.agregarJugadas(jugador1.value,jugador2.value)
                        viewModel.verificarEstadoPartida()
                    }
                }
            }
        }

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
            for (i in 4..6){
                state.botones.get(i)?.let {
                    CustomButton(text = it) {
                        if (state.jugadorTurno == "Jugador X")
                        {
                            viewModel.actualizarBoton(i,"X")
                            viewModel.cambiarTurno(state.jugadorTurno)
                            jugador1.value += i.toString()
                        }
                        else{
                            viewModel.actualizarBoton(i,"O")
                            viewModel.cambiarTurno(state.jugadorTurno)
                            jugador2.value += i.toString()

                        }
                        viewModel.agregarJugadas(jugador1.value,jugador2.value)
                        viewModel.verificarEstadoPartida()
                    }
                }
            }
        }

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
            for (i in 7..9){
                state.botones.get(i)?.let {
                    CustomButton(text = it) {
                        if (state.jugadorTurno == "Jugador X")
                        {
                            viewModel.actualizarBoton(i,"X")
                            viewModel.cambiarTurno(state.jugadorTurno)
                            jugador1.value += i.toString()
                        }
                        else{
                            viewModel.actualizarBoton(i,"O")
                            viewModel.cambiarTurno(state.jugadorTurno)
                            jugador2.value += i.toString()

                        }
                        viewModel.agregarJugadas(jugador1.value,jugador2.value)
                        viewModel.verificarEstadoPartida()
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(10.dp))


        Column() {
            CustomText(text = "Turno del jugador: " + state.jugadorTurno)
            CustomText(text = "Estado de la partida: " + state.estadoPartida)
        }

        Spacer(modifier = Modifier.height(10.dp))

        RestartButton(text = "RENICIAR JUEGO",
            Modifier
                .size(200.dp, 60.dp)
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)) {
            viewModel.reiniciarJuego()
            jugador1.value = ""
            jugador2.value = ""
        }
    }


}

