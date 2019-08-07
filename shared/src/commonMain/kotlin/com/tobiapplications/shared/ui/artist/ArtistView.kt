package ui.artist

import model.searchartist.ArtistResponse
import ui.base.BaseView

/**
 * Created by tobias.hehrlein on 2019-07-23.
 */
interface ArtistView : BaseView {

    fun setArtists(response: ArtistResponse)
}