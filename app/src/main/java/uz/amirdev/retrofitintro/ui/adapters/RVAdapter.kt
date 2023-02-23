package uz.amirdev.retrofitintro.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.amirdev.retrofitintro.data.models.PhotoModel
import uz.amirdev.retrofitintro.databinding.RvItemBinding

class RVAdapter : RecyclerView.Adapter<RVAdapter.VH>() {

    val photoList = ArrayList<PhotoModel>()

    inner class VH(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(photo: PhotoModel) {
            Glide.with(binding.root.context).load(photo.thumbnailUrl).into(binding.imageView)
            binding.photoID.text = photo.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        RvItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        val photo = photoList[position]
        holder.onBind(photo)
    }

    override fun getItemCount() = photoList.size

    fun refreshData(list: ArrayList<PhotoModel>) {
        photoList.clear()
        photoList.addAll(list)
        notifyDataSetChanged()
    }
}