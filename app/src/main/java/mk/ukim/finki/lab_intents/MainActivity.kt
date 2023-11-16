package mk.ukim.finki.lab_intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var ExplicitActivityTextView: TextView
    private lateinit var goToExplicitActivityButton: Button
    private lateinit var goToImplicitActivityButton: Button
    private lateinit var goToPhotoGalleryButton: Button
    private lateinit var selectedPhotoImageView: ImageView

    private var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            ExplicitActivityTextView.text = data?.getStringExtra("message")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ExplicitActivityTextView = findViewById(R.id.ExplicitActivityTextView)
        goToExplicitActivityButton = findViewById(R.id.goToExplicitActivityButton)
        goToImplicitActivityButton = findViewById(R.id.goToImplicitActivityButton)
        goToPhotoGalleryButton = findViewById(R.id.goToPhotoGalleryButton)
        selectedPhotoImageView = findViewById(R.id.selectedPhotoImageView)


        // Explicit Intent
        goToExplicitActivityButton.setOnClickListener {
            resultLauncher.launch(Intent(this, ExplicitActivity::class.java))
        }

        // Implicit Intent
        goToImplicitActivityButton.setOnClickListener {
            Intent().apply {
                action = "mk.ukim.finki.mpip.IMPLICIT_ACTION"
                type = "text/plain"
            }.let {
                startActivity((Intent.createChooser(it, "Choose an app")))
            }
        }


        selectedPhotoImageView.clipToOutline = true

        val selectImageIntent = registerForActivityResult(ActivityResultContracts.GetContent())
        { uri ->
            selectedPhotoImageView.setImageURI(uri)
        }


        // Select a Photo
        goToPhotoGalleryButton.setOnClickListener {
            selectImageIntent.launch("image/*")
        }

    }

}