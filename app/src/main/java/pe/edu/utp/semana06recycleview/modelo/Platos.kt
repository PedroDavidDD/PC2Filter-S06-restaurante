package pe.edu.utp.semana06recycleview.modelo

import android.os.Parcel
import android.os.Parcelable

data class Platos(var nombre: String?, var precio: Double, var rating: Float,
                  var descripcion: String?, var foto: Int) : Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readDouble(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flag: Int) {
        parcel.writeString(nombre)
        parcel.writeDouble(precio)
        parcel.writeFloat(rating)
        parcel.writeString(descripcion)
        parcel.writeInt(foto)

    }

    companion object CREATOR : Parcelable.Creator<Platos> {
        override fun createFromParcel(parcel: Parcel): Platos {
            return Platos(parcel)
        }

        override fun newArray(size: Int): Array<Platos?> {
            return arrayOfNulls(size)
        }
    }
}
