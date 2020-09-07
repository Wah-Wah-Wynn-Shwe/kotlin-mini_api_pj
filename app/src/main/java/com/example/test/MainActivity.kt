package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.adapter.MoviesAdapter
import com.example.test.model.Movie
import com.example.test.webservice.ApiInterface
import com.example.test.webservice.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private var recyclerView: RecyclerView? = null
    private val movies = ArrayList<Movie>()
    private var moviesAdapter: MoviesAdapter? = null
    private val linearLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)

        recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
        moviesAdapter = MoviesAdapter(this@MainActivity, movies)
        recyclerView!!.adapter = moviesAdapter


        getMovies()
    }

    private fun getMovies() {
        val apiInterface = ServiceGenerator.createService(ApiInterface::class.java)
        val call = apiInterface.getMovies()
        call.enqueue(object : Callback<List<Movie>> {

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.isSuccessful) {
                    Log.d("GG_", "" + response.body()!!)
                    moviesAdapter!!.setMovies(response.body()!!)
                } else {
                    Log.e(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Log.e(TAG, t.message)
            }
        })
    }
}
