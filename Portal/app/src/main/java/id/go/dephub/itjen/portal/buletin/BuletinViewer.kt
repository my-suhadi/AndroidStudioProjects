package id.go.dephub.itjen.portal.buletin

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.krishna.fileloader.FileLoader
import com.krishna.fileloader.listener.FileRequestListener
import com.krishna.fileloader.pojo.FileResponse
import com.krishna.fileloader.request.FileLoadRequest
import id.go.dephub.itjen.portal.R
import kotlinx.android.synthetic.main.fragment_buletin_viewer.*
import kotlinx.android.synthetic.main.progress_bar.view.*
import java.io.File

class BuletinViewer : Fragment() {

    lateinit var buletinUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buletinUrl = arguments!!.getString("buletinUrl")!!
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buletin_viewer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutInflater.inflate(R.layout.progress_bar, buletinViewer_layout)
        buletinViewer_layout.progressBar.visibility = ProgressBar.VISIBLE

        FileLoader.with(context)
            .load(buletinUrl)
            .fromDirectory("pdf", FileLoader.DIR_INTERNAL)
            .asFile(object : FileRequestListener<File>{
                override fun onLoad(request: FileLoadRequest?, response: FileResponse<File>?) {
                    val pdfFile = response!!.body

                    pdfView.fromFile(pdfFile)
                        .password(null)
                        .defaultPage(0)
                        .enableSwipe(true)
                        .swipeHorizontal(false)
                        .enableDoubletap(true)
                        .onDraw{canvas, pageWidth, pageHeight, displayedPage ->
                            // Enter your code here
                        }
                        .onPageChange{page, pageCount ->
                            // Enter your code here
                        }
                        .onPageError{page, t ->
                            Toast.makeText(context, "Error when opening page", Toast.LENGTH_LONG).show()
                        }
                        .onTap { false }
                        .onRender { nbPages, pageWidth, pageHeight ->
                            pdfView.fitToWidth()
                        }
                        .enableAnnotationRendering(true)
                        .invalidPageColor(Color.RED)
                        .load()
                    buletinViewer_layout.progressBar.visibility = ProgressBar.GONE
                }

                override fun onError(request: FileLoadRequest?, t: Throwable?) {
                    Toast.makeText(context, "Error with ${t!!.localizedMessage}", Toast.LENGTH_LONG).show()
                }

            })
    }

    override fun onDestroy() {
        (activity as AppCompatActivity).supportActionBar!!.show()
        super.onDestroy()
    }
}
