package com.hrushabhb.musicwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrushabhb.musicwiki.Repository.Repository
import com.hrushabhb.musicwiki.ViewModel.ViewModelMain
import com.hrushabhb.musicwiki.adapters.AlbumInfoGenreAdapter
import com.hrushabhb.musicwiki.databinding.ActivityAlbumBinding

class AlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlbumBinding
    lateinit var albumInfoGenreAdapter: AlbumInfoGenreAdapter
    private lateinit var viewModel: ViewModelMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        val aints = intent
        val aname = aints.getStringExtra("ANAME")
        val arname = aints.getStringExtra("ARNAME")


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelMain::class.java)
        viewModel.getAlbumInfo(arname.toString(), aname.toString())
        viewModel.albumInfoResponse.observe(this) { info ->

            setUpRecyclerView()
            albumInfoGenreAdapter.AlbumInfoGenre = info.tags.tag
            binding.albumTitle.text = info.name
            binding.artistTitle.text = info.artist
            binding.albumDesc.text = info.wiki.summary
            binding.albumImg.loadImage(info.image[0].text)

        }

        /*lifecycleScope.launchWhenCreated {
            binding.albumInfoPb.isVisible = true
            val response  = try {
                RetrofitInstance.api.getAlbumInfo(arname.toString(), aname.toString())
            }catch (e: IOException){
                Log.d("TASG", "IOException "+e)
                binding.albumInfoPb.isVisible = false
                return@launchWhenCreated
            }catch (e : HttpException){
                Log.d("TASG", "HttpException "+e)
                binding.albumInfoPb.isVisible = false
                return@launchWhenCreated
            }

            if(response.isSuccessful && response.body()!=null){
                albumInfoGenreAdapter.albumInfoGenre = response.body()!!.album.tags.tag
                binding.albumTitle.text = response.body()!!.album.name
                binding.artistTitle.text = response.body()!!.album.artist
                binding.albumDesc.text = response.body()!!.album.wiki.summary
                binding.albumImg.loadImage(response.body()!!.album.image[0].text)
            }else{
                Log.d("TASG", "Response not successful")
            }
            binding.albumInfoPb.isVisible = false
        }*/
    }

    private fun setUpRecyclerView() = binding.albumInfoGenreRv.apply {
        albumInfoGenreAdapter = AlbumInfoGenreAdapter(this@AlbumActivity)
        adapter = albumInfoGenreAdapter
        layoutManager =
            LinearLayoutManager(this@AlbumActivity, LinearLayoutManager.HORIZONTAL, false)
    }
}