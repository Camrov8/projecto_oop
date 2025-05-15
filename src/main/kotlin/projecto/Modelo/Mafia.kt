package com.example.projecto.Modelo

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.*
@Polymorphic
@Serializable
open class Mafia (open val nome : String, open val posto : String){
}