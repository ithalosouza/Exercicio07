package br.com.cotemig.exercicio07.services

import br.com.cotemig.exercicio07.model.ListaStories
import retrofit2.Call
import retrofit2.http.GET

interface ServiceStories {
    @GET("stories")
    fun obterListaStories() : Call<ListaStories>
}