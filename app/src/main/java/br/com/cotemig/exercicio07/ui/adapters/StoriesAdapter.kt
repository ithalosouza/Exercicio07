package br.com.cotemig.exercicio07.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.exercicio07.R
import br.com.cotemig.exercicio07.model.Stories
import com.bumptech.glide.Glide

class StoriesAdapter(var context: Context, var stories: List<Stories>) : BaseAdapter(){
    override fun getCount(): Int {
        return stories.size
    }

    override fun getItem(p0: Int): Any {
        return ""
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_stories, null)

        var nome = view.findViewById<TextView>(R.id.user)
        nome.text = stories[p0].user

        var imagem = view.findViewById<ImageView>(R.id.avatar)
        Glide.with(context).load(stories[p0].avatar).into(imagem)

        var valor = view.findViewById<TextView>(R.id.live)
        valor.text = stories[p0].live

        return view

    }
}