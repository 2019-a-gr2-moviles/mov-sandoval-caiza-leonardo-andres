package com.example.examen_1b

import android.os.Parcel
import android.os.Parcelable


class Tienda(var tiendaID:Int?,
             var nombres:String,
             var direccion:String,
             var fechaApertura:String,
             var matriz:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }
    override fun toString(): String {
        return "NOMBRES: ${nombres} DIRECCION: ${direccion} FECHA APERTURA: ${fechaApertura} " +
                "MATRIZ:${matriz}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(tiendaID)
        parcel.writeString(nombres)
        parcel.writeString(direccion)
        parcel.writeString(fechaApertura)
        parcel.writeString(matriz)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tienda> {
        override fun createFromParcel(parcel: Parcel): Tienda {
            return Tienda(parcel)
        }

        override fun newArray(size: Int): Array<Tienda?> {
            return arrayOfNulls(size)
        }
    }


}