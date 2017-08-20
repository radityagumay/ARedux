package net.radityalabs.aredux.base

import android.widget.FrameLayout
import android.os.Bundle
import android.support.test.espresso.core.deps.guava.annotations.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import net.radityalabs.aredux.R

@VisibleForTesting
class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frameLayout = FrameLayout(this)
        frameLayout.id = R.id.container
        setContentView(frameLayout)
    }
}