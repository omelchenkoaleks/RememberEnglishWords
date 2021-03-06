package com.omelchenkoaleks.rememberenglishwords

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.omelchenkoaleks.rememberenglishwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    lateinit var toolbar: Toolbar
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APP_ACTIVITY = this

        toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        title = getString(R.string.app_name)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}