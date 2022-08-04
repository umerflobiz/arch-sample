package com.flobiz.android.archsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.flobiz.android.archsample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.flobiz.android.auth.R as AuthR
import com.flobiz.android.dashboard.R as DashboardR
import com.flobiz.android.partyshared.R as PartyR
import com.flobiz.android.payment.R as PaymentR

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_nav_host) as NavHostFragment
        val navGraph =
            navHostFragment.navController.navInflater.inflate(R.navigation.main_nav_graph)
        val navController = navHostFragment.navController
        navGraph.setStartDestination(AuthR.id.auth_nav_graph)
        navController.graph = navGraph

        setupBottomNav(navController)
    }

    private fun setupBottomNav(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.navView.isVisible = when (destination.id) {
                DashboardR.id.dashboardFragment,
                PaymentR.id.paymentsFragment,
                PartyR.id.partiesFragment -> true
                else -> false
            }
        }

        binding.navView.setOnItemSelectedListener { menuItem ->
            val destination = when (menuItem.itemId) {
                R.id.navigation_home -> DashboardR.id.dashboard_nav_graph
                R.id.navigation_party -> PartyR.id.parties_nav_graph
                R.id.navigation_payment -> PaymentR.id.payment_nav_graph
                else -> throw IllegalArgumentException("Invalid menu option [$menuItem].")
            }
            navController.navigate(destination)
            true
        }
        binding.navView.setOnItemReselectedListener { /* Do Nothing */ }
    }
}
