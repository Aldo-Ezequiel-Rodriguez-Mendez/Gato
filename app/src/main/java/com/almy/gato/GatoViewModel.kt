package com.almy.gato

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GatoViewModel: ViewModel(){
    private val _uiStateGato = MutableStateFlow<Gato>(Gato())
    val uiStateGato: StateFlow<Gato> = _uiStateGato

    fun actualizarBoton(boton: Int, valor: String){
        _uiStateGato.value.botones.put(boton,valor)
    }

    fun cambiarTurno(jugadorTurno: String) {
        if (jugadorTurno == "Jugador X")
            _uiStateGato.value = _uiStateGato.value.copy(jugadorTurno = "Jugador O")
        else
            _uiStateGato.value = _uiStateGato.value.copy(jugadorTurno = "Jugador X")
    }

    fun agregarJugadas(jugador1: String, jugador2: String){
        _uiStateGato.value = _uiStateGato.value.copy(jugador1 = jugador1)
        _uiStateGato.value = _uiStateGato.value.copy(jugador2 = jugador2)
    }

    fun verificarEstadoPartida(){
        val combinacionesGanadoras: List<String> = listOf(
            "123","456","789",  //filas
            "147","258","369",  //columnas
            "159","357"         //diagonales
        )

        for(combinacion in combinacionesGanadoras){
            if(_uiStateGato.value.jugador1.count {it in combinacion} >= 3){
                _uiStateGato.value = _uiStateGato.value.copy(estadoPartida = "Ganó jugador X")
                return
            }
            else if(_uiStateGato.value.jugador2.count {it in combinacion} >= 3){
                _uiStateGato.value = _uiStateGato.value.copy(estadoPartida = "Ganó jugador O")
                return
            }
        }

        if (_uiStateGato.value.estadoPartida == "" &&(_uiStateGato.value.jugador1 + _uiStateGato.value.jugador2).length == 9){
            _uiStateGato.value = _uiStateGato.value.copy(estadoPartida = "Empate")
        }
    }

    fun reiniciarJuego(){
        _uiStateGato.value = _uiStateGato.value.copy(jugadorTurno = "Jugador X")
        _uiStateGato.value = _uiStateGato.value.copy(estadoPartida = "")
        _uiStateGato.value = _uiStateGato.value.copy(jugador1 = "")
        _uiStateGato.value = _uiStateGato.value.copy(jugador2 = "")
        _uiStateGato.value = _uiStateGato.value.copy(botones = hashMapOf(
            1 to "",
            2 to "",
            3 to "",
            4 to "",
            5 to "",
            6 to "",
            7 to "",
            8 to "",
            9 to ""))
    }

}

data class Gato(
    val jugadorTurno: String = "Jugador X",
    val estadoPartida: String = "",
    val jugador1: String = "",
    val jugador2: String = "",
    val botones: HashMap<Int,String> = hashMapOf(
        1 to "",
        2 to "",
        3 to "",
        4 to "",
        5 to "",
        6 to "",
        7 to "",
        8 to "",
        9 to "")
)