package com.hrushabhb.musicwiki.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrushabhb.musicwiki.MainViewModelFactory
import com.hrushabhb.musicwiki.R
import com.hrushabhb.musicwiki.Repository.Repository
import com.hrushabhb.musicwiki.ViewModel.ViewModelMain
import com.hrushabhb.musicwiki.adapters.GenreArtistsAdapter
import com.hrushabhb.musicwiki.databinding.FragmentGenreArtistsBinding

class GenreArtistsFragment(var genreName: String) : Fragment() {

    private lateinit var binding: FragmentGenreArtistsBinding
    private lateinit var genreArtistsAdapter: GenreArtistsAdapter
    private lateinit var viewModel: ViewModelMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenreArtistsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelMain::class.java)
        viewModel.getTagTopArtists(genreName.toString())
        viewModel.tagTopArtistsResposne.observe(viewLifecycleOwner) { topArtists ->
            setupRecyclerView()
            genreArtistsAdapter.genreArtists = topArtists
        }

        /* lifecycleScope.launchWhenCreated {
             binding.artistsRvPb.isVisible = true
             val response  = try {
                 RetrofitInstance.api.getTopArtists(genreName)
             }catch (e: IOException){
                 binding.artistsRvPb.isVisible = false
                 return@launchWhenCreated
             }catch (e : HttpException){
                 Log.d("TASG", "HttpException "+e)
                 binding.artistsRvPb.isVisible = false
                 return@launchWhenCreated
             }

             if(response.isSuccessful && response.body()!=null){
                 genreArtistsAdapter.genreArtists = response.body()!!.topartists.artist
             }else{
                 Log.d("TASG", "Response not successful")
             }
             binding.artistsRvPb.isVisible = false
         }*/
    }

    private fun setupRecyclerView() = binding.artistsRv.apply {
        genreArtistsAdapter = GenreArtistsAdapter(context)
        adapter = genreArtistsAdapter
        layoutManager = LinearLayoutManager(context)
    }
}