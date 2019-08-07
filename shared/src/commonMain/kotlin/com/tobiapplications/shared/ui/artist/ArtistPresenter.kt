package ui.artist

import kotlinx.coroutines.launch
import network.NetworkManager
import ui.ArtistRepository
import ui.base.BasePresenter
import kotlin.coroutines.CoroutineContext

/**
 * Created by tobias.hehrlein on 2019-07-23.
 */
class ArtistPresenter(private val uiContext: CoroutineContext,
                      private val view: ArtistView) : BasePresenter(uiContext, view) {

    private val repository = ArtistRepository(NetworkManager())

    fun getArtists(artist: String) {
        if (artist.isEmpty()) {
            view.showError(Throwable("Invalid"))
            return
        }

        view.showProgressIndicator(true)

        launch {
            val data = repository.getArtists(artist)
            view.setArtists(data)
        }.invokeOnCompletion {
            view.showProgressIndicator(false)
        }
    }
}