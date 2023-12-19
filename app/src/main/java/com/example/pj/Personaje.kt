package com.example.pj

import android.os.Parcel
import android.os.Parcelable

class Personaje(
    val raza: String,
    val nombre: String,
    val estadoVital: String,
    val clase: String,
    val pesoMochila: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(raza)
        parcel.writeString(nombre)
        parcel.writeString(clase)
        parcel.writeString(estadoVital)
        parcel.writeInt(pesoMochila)
    }

    companion object CREATOR : Parcelable.Creator<Personaje> {
        override fun createFromParcel(parcel: Parcel): Personaje {
            return Personaje(parcel)
        }

        override fun newArray(size: Int): Array<Personaje?> {
            return arrayOfNulls(size)
        }
    }
    override fun toString(): String {
        return "Personaje:\n" +
                "   -Nombre: $nombre\n" +
                "   -Raza: $raza \n" +
                "   -Clase: $clase \n" +
                "   -Tamaño mochila:$pesoMochila\n"
    }
}