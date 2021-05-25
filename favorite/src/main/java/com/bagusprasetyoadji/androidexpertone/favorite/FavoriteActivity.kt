package com.bagusprasetyoadji.androidexpertone.favorite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagusprasetyoadji.androidexpertone.core.ui.MovieAdapter
import com.bagusprasetyoadji.androidexpertone.detail.DetailMovieActivity
import com.bagusprasetyoadji.androidexpertone.favorite.databinding.ActivityFavoriteBinding
import com.bagusprasetyoadji.androidexpertone.favorite.di.favoriteModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding : ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)
        getFavoriteData()
    }

    private fun getFavoriteData(){
        favoriteViewModel.favoritemovie.observe(this,{movie ->
            if(movie != null)
            {
                val movieAdapter = MovieAdapter()
                movieAdapter.onItemClick = { selectedData ->
                    val intent = Intent(this@FavoriteActivity, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedData)
                    startActivity(intent)
                }

                favoriteViewModel.favoritemovie.observe(this, { datamovie ->
                    movieAdapter.setData(datamovie)
                })

                with(binding.rvMovie) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = movieAdapter
                }
            }
        })
    }
}