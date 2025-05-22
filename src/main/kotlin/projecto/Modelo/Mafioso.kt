package com.example.projecto.Modelo

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable

open class Mafioso(@Transient open var nome : String, @Transientopen open var posto : String,@Transient open var idade : Int ){

}

