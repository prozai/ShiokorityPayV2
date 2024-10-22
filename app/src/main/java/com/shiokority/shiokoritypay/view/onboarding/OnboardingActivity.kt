package com.shiokority.shiokoritypay.view.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.shiokority.shiokoritypay.R
import com.shiokority.shiokoritypay.adapter.OnboardingAdapter
import com.shiokority.shiokoritypay.adapter.OnboardingItem
import com.shiokority.shiokoritypay.view.authentication.login.LoginActivity

class OnboardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        btnNext = findViewById(R.id.btnNext)

        // Use the OnboardingItem from the adapter
        val onboardingItems = listOf(
            OnboardingItem(R.drawable.splash_background, "Flexible", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
            OnboardingItem(R.drawable.splash_background, "Faster", "Sed vitae dictum turpis. Fusce hendrerit quam vel."),
            OnboardingItem(R.drawable.splash_background, "Closer", "Fusce hendrerit quam vel. Sed vitae dictum turpis.")
        )

        val adapter = OnboardingAdapter(onboardingItems)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Customize onboarding tabs from here
        }.attach()

        btnNext.setOnClickListener {
            if (viewPager.currentItem < onboardingItems.size - 1) {
                viewPager.currentItem++
            } else {
                // Handle completion of onboarding
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }
}
