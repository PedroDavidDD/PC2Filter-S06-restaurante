
package pe.edu.utp.semana06recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import pe.edu.utp.semana06recycleview.Providers.PlatoProvider
import pe.edu.utp.semana06recycleview.modelo.Platos

class NuevoPlatoActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etPrecio: EditText
    private lateinit var etDescripcion: EditText
    private lateinit var btGrabar: Button
    private lateinit var platos: MutableList<Platos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_plato)

        this.platos = PlatoProvider.platosList
        this.inicializarComponentes()

    }

    private fun inicializarComponentes(){

        this.etNombre = findViewById(R.id.etNombre)
        this.etPrecio = findViewById(R.id.etPrecio)
        this.etDescripcion = findViewById(R.id.etmlDescripcion)
        this.btGrabar = findViewById(R.id.btnAgregar)
        this.btGrabar.setOnClickListener {
            this.platos.add(this.obtenerDatosPlato())
            Toast.makeText(this, "Se agrego el nuevo plato", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun obtenerDatosPlato(): Platos{
        val numeroAleatorio = (1 + (Math.random() * 4)).toFloat()
        val numeroDosDecimales = String.format("%.2f", numeroAleatorio).toFloat()

        val Platos = Platos(this.etNombre.text?.toString(),
                            this.etPrecio.text!!.toString().toDouble(),
            numeroDosDecimales, this.etDescripcion.text?.toString(), R.drawable.platillo01)

        return Platos
    }



}