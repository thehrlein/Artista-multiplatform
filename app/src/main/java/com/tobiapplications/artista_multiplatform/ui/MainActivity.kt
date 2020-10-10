package com.tobiapplications.artista_multiplatform.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tobiapplications.artista_multiplatform.R
import com.tobiapplications.artista_multiplatform.utils.closeKeyboard
import com.tobiapplications.artista_multiplatform.utils.setVisible
import getCurrentDate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import model.searchartist.ArtistResponse
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton
import ui.artist.ArtistPresenter
import ui.artist.ArtistView

class MainActivity : AppCompatActivity(), ArtistView {

    private val presenter by lazy {
        ArtistPresenter(Dispatchers.Main, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kotlinRocks.text = getCurrentDate()
        searchButton.setOnClickListener {
            searchAutoCompleteText.closeKeyboard()
            presenter.getArtists(searchAutoCompleteText.text.toString())
        }
    }

    override fun setArtists(response: ArtistResponse) {
        artistList.text = response.results.artistMatches.artist.joinToString(separator = "\n") { it.name }
    }

    override fun showProgressIndicator(show: Boolean) {
        progressBar.setVisible(show)
    }

    override fun showError(error: Throwable) {
        alert("Failure: ${error.message}") {
            title = "Warning"
            yesButton {  }
        }.show()
    }
}
