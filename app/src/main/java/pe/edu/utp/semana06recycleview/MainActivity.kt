package pe.edu.utp.semana06recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import pe.edu.utp.semana06recycleview.Enums.typeFilters
import pe.edu.utp.semana06recycleview.Providers.PlatoProvider
import pe.edu.utp.semana06recycleview.adapters.PlatoAdapter
import pe.edu.utp.semana06recycleview.interfaces.ClickListenerInterface
import pe.edu.utp.semana06recycleview.modelo.Platos

class MainActivity : AppCompatActivity() {

    private lateinit var rvPlatos: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var plato: MutableList<Platos>
    private lateinit var fabAgregarPlato: FloatingActionButton

    private lateinit var adapterPlato: PlatoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.tbPrincipal))
        //this.llenarPlatos()

        this.llenarPlatos()

        this.inicializarComponentes()
    }

    private fun inicializarComponentes(){
        this.rvPlatos = findViewById(R.id.rvListaPlatos)
        this.layoutManager = LinearLayoutManager(this)
        this.rvPlatos.setHasFixedSize(true)
        this.rvPlatos.layoutManager = this.layoutManager

        this.adapterPlato = PlatoAdapter(this, this.plato, object : ClickListenerInterface{

            override fun onClick(vista: View, index: Int) {
                Toast.makeText(applicationContext, plato[index].nombre, Toast.LENGTH_SHORT).show()
            }

        })
        this.rvPlatos.adapter = this.adapterPlato

        this.fabAgregarPlato = findViewById(R.id.fabAgregar)
        this.fabAgregarPlato.setOnClickListener {
            val intent = Intent(this, NuevoPlatoActivity::class.java)
            startActivity(intent)

        }
    }

    private fun llenarPlatos(){
        this.plato = PlatoProvider.platosList
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)

        val searchView = menu.findItem(R.id.action_search)?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (query != null) {
                    typeRadioGroup(query)
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText.isNullOrEmpty()) {
                    setFilterPlatoList(PlatoProvider.platosList)
                }

                return true
            }

        })

        return true
    }
    fun typeRadioGroup(query : String){
        val rgTypeSearch = findViewById<RadioGroup>(R.id.rgTypeSearch)
        val selectedRadioButtonId = rgTypeSearch.checkedRadioButtonId

        if (selectedRadioButtonId != -1) {
            // Busca el RadioButton seleccionado por su ID
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)

            // Accede a la información del RadioButton seleccionado
            val selectedText = selectedRadioButton.text.toString().lowercase()

            // Realiza acciones con el RadioButton seleccionado
            filterData(query, selectedText)
        } else {
            // Ningún RadioButton ha sido seleccionado
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_search -> {
                Toast.makeText(this, "action_search", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item_list -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.item_new ->{
                val intent = Intent(this, NuevoPlatoActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun filterData(query: String? = "", typeFilterMain: String? = typeFilters.nombre.toString()) {
        val queryText = query.toString().trim().lowercase()
        // Verificar si el query es nulo o muy corto
        /*if (queryText.isEmpty() || queryText.length < 3) {
            // No se hace nada si el query es nulo o muy corto
            Toast.makeText(this,"Mínimo 3 caracteres",Toast.LENGTH_SHORT).show()
            return
        }*/
        // Filtra la lista de libros por título
        var filteredList = PlatoProvider.platosList.filter { plato ->
            plato.nombre!!.lowercase().contains(queryText)
        }

        // numérico
        when (typeFilterMain) {
            typeFilters.precio.toString() -> {
                filteredList =  PlatoProvider.platosList.filter { plato ->
                    plato.precio.toString().substringBefore(".") == queryText.substringBefore(".")
                }
            }
            typeFilters.rating.toString() -> {
                filteredList =  PlatoProvider.platosList.filter { plato ->
                    plato.rating.toString().substringBefore(".") == queryText.substringBefore(".")
                }
            }
            typeFilters.rating.toString() -> {
                filteredList = PlatoProvider.platosList.filter { plato ->
                    plato.nombre!!.lowercase().contains(queryText)
                }
            }
        }
        //[Encontró algo?]
        if (filteredList.isEmpty()) {
            // Si filteredList está vacío, avisa que no existe la coincidencia
            setFilterPlatoList(PlatoProvider.platosListNodata)
        } else {
            // Si filteredList no está vacío, establece la lista filtrada
            setFilterPlatoList(filteredList.toMutableList())
        }
    }

    fun setFilterPlatoList(bookList: MutableList<Platos>) {
        // Actualizar el adaptador con la lista filtrada
        adapterPlato.updListFilterPlato(bookList.toMutableList())
    }


}