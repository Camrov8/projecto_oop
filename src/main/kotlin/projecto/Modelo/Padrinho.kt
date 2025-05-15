package com.example.projecto.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules

@Serializable
@SerialName("Padrinho")
 class Padrinho ( override val nome : String,  override val posto : String): Mafia(nome, posto),Mafioso {
    override fun sms() {

            println("padrinho")
        }
     override fun toString(): String {
         return "Padrinho(nome=$nome, posto=$posto)"
     }

}