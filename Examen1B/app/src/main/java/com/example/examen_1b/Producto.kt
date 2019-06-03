package com.example.examen_1b

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Producto(var ProductoID:Int?,
               var numeroProducto:Int,
               var nombre:String,
               var descripcion:String,
               var precio:Double,
               var fechaLanzamientoProd: Date,
               var aniosGarantia:Int,
               var tiendaID:Int): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readSerializable() as Date,
        parcel.readInt(),
        parcel.readInt()
    ) {
    }
    override fun toString(): String {
        return "Número Producto: ${numeroProducto} Nombre: ${nombre}" +
                "Descripcion: ${descripcion} Precio: ${precio}" +
                "Fecha Lanzamiento:${fechaLanzamientoProd} Anios de Garantia:${aniosGarantia}"
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(ProductoID)
        parcel.writeInt(numeroProducto)
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeDouble(precio)
        parcel.writeSerializable(fechaLanzamientoProd)
        parcel.writeInt(aniosGarantia)
        parcel.writeInt(tiendaID)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Producto> {
        override fun createFromParcel(parcel: Parcel): Producto {
            return Producto(parcel)
        }

        override fun newArray(size: Int): Array<Producto?> {
            return arrayOfNulls(size)
        }
    }
}

