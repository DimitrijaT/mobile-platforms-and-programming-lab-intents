package mk.ukim.finki.lab_intents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.lab_intents.adapters.RegisteredActivitiesViewAdapter


class ImplicitActivity : AppCompatActivity() {

//    private lateinit var registeredActivityTextView: TextView

    private lateinit var listRegisteredActivitiesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)

//        registeredActivityTextView = findViewById(R.id.registeredActivityTextView)
//        val activities = packageManager
//            .getPackageInfo(packageName, PackageManager.GET_ACTIVITIES).activities
//        val nameList = activities.map { it.name }
//        registeredActivityTextView.text = nameList.joinToString("\n")

        listRegisteredActivitiesRecyclerView =
            findViewById(R.id.listRegisteredActivitiesRecyclerView)

        listRegisteredActivitiesRecyclerView.adapter = RegisteredActivitiesViewAdapter(loadData())

    }

    fun loadData(): MutableList<String> {

//        val activities = packageManager
//            .getPackageInfo(packageName, PackageManager.GET_ACTIVITIES).activities
//        val nameList = activities.map { it.name }
//        return nameList.toMutableList()

        val mainIntent = Intent(Intent.ACTION_MAIN, null)
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        val pkgAppsList = packageManager.queryIntentActivities(mainIntent, 0)

        for (i in pkgAppsList.indices) {
            Log.e("Activity package", pkgAppsList[i].activityInfo.name)
        }

        return pkgAppsList.map { it.activityInfo.name }.toMutableList()
    }

}