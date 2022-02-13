package com.example.viewpagertest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagertest.databinding.SongsFragmentBinding
import com.example.viewpagertest.model.remote.CATEGORIES
import com.example.viewpagertest.model.remote.CATEGORY_NAMES
import com.example.viewpagertest.model.remote.SongItem
import com.example.viewpagertest.model.remote.SongResponse
import com.example.viewpagertest.viewmodel.SongsViewModel
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private lateinit var binding: SongsFragmentBinding
private val viewModel: SongsViewModel by lazy {
    SongsViewModel()
}

class ViewPagerFragment(private val playSongEvent: (SongItem) -> Unit) : Fragment() {
    private lateinit var demoCollectionAdapter: DemoCollectionAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SongsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        demoCollectionAdapter = DemoCollectionAdapter(this@ViewPagerFragment) {
            playSongEvent(it)
        }
        binding.pager.adapter = demoCollectionAdapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = CATEGORY_NAMES[position]
        }.attach()
    }
}

class DemoCollectionAdapter(fragment: Fragment, private val playSongEvent: (SongItem) -> Unit) :
    FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int = CATEGORIES.size

    override fun createFragment(position: Int): Fragment {

        val fragment = DisplaySongFragment() {
            playSongEvent(it)
        }
        requestData(position).enqueue(object : Callback<SongResponse> {
            override fun onResponse(
                call: Call<SongResponse>,
                response: Response<SongResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                    fragment.updateAdapter(it)
                    }
                }
            }

            override fun onFailure(call: Call<SongResponse>, t: Throwable) {
            }
        })
        return fragment
    }

    private fun requestData(pos: Int): Call<SongResponse> {

        when (pos) {
            0 -> return viewModel.getRockSongs()
            1 -> return viewModel.getClassicSongs()
            2 -> return viewModel.getPopSongs()
            else -> return viewModel.getRockSongs()
        }
    }


}
