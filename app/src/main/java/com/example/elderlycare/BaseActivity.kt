package com.example.elderlycare

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.example.elderlycare.matching.view.FindCaregiversActivity
import com.example.elderlycare.matching.view.FindJobsActivity
import com.example.elderlycare.ui.InfoActivity
import com.example.elderlycare.ui.NavItem1Activity
import com.example.elderlycare.ui.NavItem2Activity
import com.example.elderlycare.ui.NavItem3Activity
import com.google.android.material.navigation.NavigationView

open class BaseActivity : AppCompatActivity() {
    lateinit var navigationView: NavigationView
    lateinit var navViewContainer: FrameLayout
    private var isNavViewVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setupNavigationView() {
        navigationView = findViewById(R.id.nav_view)
        navViewContainer = findViewById(R.id.nav_view_container)

        val headerLayout = findViewById<RelativeLayout>(R.id.header_layout)
        val btnMenu = headerLayout.findViewById<ImageButton>(R.id.btnMenu)
        navViewContainer = headerLayout.findViewById(R.id.nav_view_container)

        navigationView = findViewById(R.id.nav_view)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.hc_info -> {
                    startActivity(Intent(this, InfoActivity::class.java))
                }
                R.id.nav_item1 -> {
                    startActivity(Intent(this, NavItem1Activity::class.java))
                }
                R.id.nav_item2 -> {
                    startActivity(Intent(this, NavItem2Activity::class.java))
                }
                R.id.nav_item3 -> {
                    startActivity(Intent(this, NavItem3Activity::class.java))
                }
                R.id.nav_find_caregivers -> {
                    // nav_item3 선택 시 처리
                    startActivity(Intent(this, FindCaregiversActivity::class.java))
                }
                R.id.nav_find_jobs -> {
                    // nav_item3 선택 시 처리
                    startActivity(Intent(this, FindJobsActivity::class.java))
                }
            }
            true
        }

        btnMenu.setOnClickListener {
            toggleNavViewVisibility()
            moveNavViewToTop()
        }

        val imageViewLogo = findViewById<ImageView>(R.id.logo)
        imageViewLogo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun toggleNavViewVisibility() {
        if (navViewContainer.visibility == View.VISIBLE) {
            navViewContainer.visibility = View.GONE
        } else {
            navViewContainer.visibility = View.VISIBLE
        }
    }

    private fun moveNavViewToTop() {
        ViewCompat.offsetTopAndBottom(navViewContainer, -navViewContainer.top)
    }
}