package id.gorgom.quranapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import dagger.hilt.android.AndroidEntryPoint
import id.gorgom.quranapp.R
import id.gorgom.quranapp.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _activityMainBinding: ActivityMainBinding? = null
    private val activityMainBinding get() = _activityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding?.root)

        activityMainBinding?.appbarToolbar?.outlineProvider = null
        setSupportActionBar(activityMainBinding?.toolbar)
        if (supportActionBar != null) {
            supportActionBar?.title = ""
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.frag_container_main) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            navController.graph
        )

        Log.d("Log nya: ",appBarConfiguration.topLevelDestinations.toString())
    }
}
