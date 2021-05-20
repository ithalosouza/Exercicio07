package br.com.cotemig.exercicio07.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import br.com.cotemig.exercicio07.R
import br.com.cotemig.exercicio07.model.ListaStories
import br.com.cotemig.exercicio07.model.Stories
import br.com.cotemig.exercicio07.services.RetrofitInitializer
import br.com.cotemig.exercicio07.ui.adapters.StoriesAdapter
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        obterStories()
    }

    fun obterStories() {
        var s = RetrofitInitializer().serviceStories()
        var call = s.obterListaStories()
        call.enqueue(object : retrofit2.Callback<ListaStories> {

            override fun onResponse(call: Call<ListaStories>, response: Response<ListaStories>) {

                if (response.code() == 200) {
                    response.body()?.let {
                        mostraLista(it.lista)
                    }
                }
            }

            override fun onFailure(call: Call<ListaStories>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Algo de errado aconteceu!", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun mostraLista (stories: List<Stories>) {
        var listaStories = findViewById<ListView>(R.id.listaStories)
        listaStories.adapter = StoriesAdapter(this, stories)
    }
}