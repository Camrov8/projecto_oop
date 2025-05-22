package com.example.projecto.Modelo

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json



@Serializable
@Polymorphic
sealed  class Mafioso(  ){
   open var nome: String = ""
   open var posto: String = ""
   open var idade: String = ""
   open var familia: String = ""
}

