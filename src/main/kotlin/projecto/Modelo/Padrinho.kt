package com.example.projecto.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

class Padrinho(override var nome: String, override var posto: String, override var idade: Int) : Mafioso(nome, posto, idade)