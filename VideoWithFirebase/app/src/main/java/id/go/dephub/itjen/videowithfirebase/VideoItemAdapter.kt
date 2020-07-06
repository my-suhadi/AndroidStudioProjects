package id.go.dephub.itjen.videowithfirebase

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        internal val videoDownloadBtn = _videoItemLayout.findViewById<Button>(R.id.video_btn_download)
    }

    private val videoItems = _videoItems
    private val cx = _cx

    override fun onCreateViewHolder(_parent: ViewGroup, _viewType: Int): VideoItemViewHolder {
        val layout = LayoutInflater.from(this.cx).inflate(R.layout.video_item, _parent, false)
        return VideoItemViewHolder(layout)
    }

    override fun getItemCount() = this.videoItems.size

    override fun onBindViewHolder(_holder: VideoItemViewHolder, _position: Int) {
        val theVideo = this.videoItems[_position]

        _holder.videoViewer.setVideoPath(theVideo.videoUrl)
        _holder.videoJudul.text = theVideo.judul
        _holder.videoDeskripsi.text = theVideo.deskripsi
        _holder.videoDownloadBtn.setOnClickListener {
            val downloadService = this.cx.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val videoUri = Uri.parse(theVideo.videoUrl)
            val downloadRequest = DownloadManager.Request(videoUri)

            downloadRequest.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            downloadService.enqueue(downloadRequest)
        }
    }
}