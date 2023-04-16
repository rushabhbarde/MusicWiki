package com.hrushabhb.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrushabhb.musicwiki.Repository.Repository
import com.hrushabhb.musicwiki.ViewModel.ViewModelMain
import com.hrushabhb.musicwiki.adapters.TopGenreAdapter
import com.hrushabhb.musicwiki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var genreAdapter: TopGenreAdapter
    private lateinit var viewModel: ViewModelMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        findViewById<LinearLayout>(R.id.toggleLayout).setOnClickListener {
            if (genreAdapter.isExpanded)
                findViewById<ImageView>(R.id.toggleIcon).setImageResource(R.drawable.ic_baseline_expand_more_24)
            else
                findViewById<ImageView>(R.id.toggleIcon).setImageResource(R.drawable.baseline_expand_less_24)
            genreAdapter.isExpanded = !genreAdapter.isExpanded
            genreAdapter.notifyDataSetChanged()
        }
        setUpRecyclerView()
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelMain::class.java)
        viewModel.topTagResponse.observe(this) { tags ->
            setUpRecyclerView()
            genreAdapter.genres = tags
        }

        /* lifecycleScope.launchWhenCreated {
             binding.genreRvPb.isVisible = true
             val response  = try {
                 RetrofitInstance.api.getTopTags()
             }catch (e: IOException){
                 Log.d("TASG", "IOException "+e)
                 binding.genreRvPb.isVisible = false
                 return@launchWhenCreated
             }catch (e : HttpException){
                 Log.d("TASG", "HttpException "+e)
                 binding.genreRvPb.isVisible = false
                 return@launchWhenCreated
             }

             if(response.isSuccessful && response.body()!=null){
                 genreAdapter.genres = response.body()!!.toptags.tag
             }else{
                 Log.d("TASG", "Response not successful")
             }
             binding.genreRvPb.isVisible = false
         }*/
    }

    private fun setUpRecyclerView() = binding.genreRv.apply {
        genreAdapter = TopGenreAdapter(context)
        adapter = genreAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun setUpRecyclerView1() {
        genreAdapter = TopGenreAdapter(this@MainActivity)
        genreAdapter.genres = viewModel.topTagResponse.value?.take(10) ?: emptyList()
        binding.genreRv.adapter = genreAdapter
        binding.genreRv.layoutManager = LinearLayoutManager(this@MainActivity)
    }
}