package model.searchartist

import kotlinx.serialization.Serializable

@Serializable
data class ArtistMatches(val artist: List<Artist>)