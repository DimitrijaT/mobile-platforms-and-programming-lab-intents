package mk.ukim.finki.lab_intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ExplicitActivity : AppCompatActivity() {
    private lateinit var etInput: EditText
    private lateinit var btnOkay: Button
    private lateinit var btnCancel: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)

        etInput = findViewById(R.id.etInput)
        btnOkay = findViewById(R.id.btnOkay)
        btnCancel = findViewById(R.id.btnCancel)

        btnOkay.setOnClickListener {
//            Intent(this, MainActivity::class.java).let {
//                it.putExtra("message", etInput.text.toString())
//                startActivity(it)
//            }
            Intent().let {
                it.putExtra("message", etInput.text.toString())
                setResult(RESULT_OK, it)
                finish()
            }
        }

        btnCancel.setOnClickListener {
            Intent().let {
                setResult(RESULT_CANCELED, it)
                finish()
            }
        }

    }
}