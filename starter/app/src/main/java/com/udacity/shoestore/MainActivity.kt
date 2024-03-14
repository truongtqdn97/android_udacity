package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.myFragment) as NavHostFragment

        drawerLayout = binding.drawerLayout

        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        NavigationUI.setupWithNavController(binding.toolbar, navController, drawerLayout)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}
