package uz.amirdev.retrofitintro.data.models

data class PhotoModel(
     val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
) {
    override fun toString(): String {
        return "PhotoModel(albumId=$albumId, id=$id, thumbnailUrl='$thumbnailUrl', title='$title', url='$url')"
    }
}