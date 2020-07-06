package id.go.dephub.itjen.videowithfirebase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tcking.github.com.giraffeplayer2.VideoView

class VideoItemAdapter(_videoItems: List<VideoItemClass>, _cx: Context) :
    RecyclerView.Adapter<VideoItemAdapter.VideoItemViewHolder>() {

    // membuat nested class
    class VideoItemViewHolder(_videoItemLayout: View) : RecyclerView.ViewHolder(_videoItemLayout) {
        internal val videoViewer = _videoItemLayout.findViewById<VideoView>(R.id.video_view)
        internal val videoJudul = _videoItemLayout.findViewById<TextView>(R.id.video_tv_judul)
        internal val videoDeskripsi = _videoItemLayout.findViewById<TextView>(R.id.video_tv_desc)
    }

    private val videoItems = _videoItems
    private val cx = _cx

    override fun onCreateViewHolder(_parent: ViewGroup, _viewType: Int): VideoItemViewHolder {
        val layout = LayoutInflater.from(this.cx).inflate(R.layout.video_item, _parent, false)
        return VideoItemViewHolder(layout)
    }

    override fun getItemCount() = this.videoItems.size

    override fun onBindViewHolder(_holder: VideoItemViewHolder, _position: Int) {
        _holder.videoViewer.setVideoPath(this.videoItems[_position].videoUri)
        _holder.videoJudul.text = this.videoItems[_position].judul
        _holder.videoDeskripsi.text = this.videoItems[_position].deskripsi
    }
}