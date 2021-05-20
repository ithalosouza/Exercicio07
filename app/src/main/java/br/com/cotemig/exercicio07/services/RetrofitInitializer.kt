package br.com.cotemig.exercicio07.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://mockup.fluo.app/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun serviceStories(): ServiceStories {
        return retrofit.create(ServiceStories::class.java)
    }

}