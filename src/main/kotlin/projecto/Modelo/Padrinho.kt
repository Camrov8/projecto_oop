package com.example.projecto.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Padrinho")
class Padrinho : Mafioso( ){
    override  var nome: String = "a"
    override var posto: String = "b"
    override var idade: String = "2"
    override var familia : String = "s"
}