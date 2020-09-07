package com.example.test.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.model.Movie

class MoviesAdapter(context: Context, private var movies: List<Movie>?) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val director: TextView
        val description: TextView

        init {
            title = itemView.findViewById(R.id.title) as TextView
            director = itemView.findViewById(R.id.director) as TextView
            description = itemView.findViewById(R.id.description) as TextView

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies!![position]
        Log.d("Wellplayed", "" + movie)
        holder.title.text = movie.getTitle()
        holder.director.text = movie.getDirector()
        holder.description.text = movie.getDescription()
    }


    override fun getItemCount(): Int {
        return movies!!.size

    }

    fun setMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }
}
