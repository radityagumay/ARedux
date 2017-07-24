package net.radityalabs.aredux.base

import android.support.test.rule.ActivityTestRule
import android.support.v4.app.Fragment
import junit.framework.Assert
import net.radityalabs.aredux.R


/**
 * Created by radityagumay on 7/23/17.
 */
class FragmentTestRule<F : Fragment>(private val mFragmentClass: Class<F>) :
        ActivityTestRule<TestActivity>(TestActivity::class.java, true, false) {
    var fragment: F? = null
        private set

    override fun afterActivityLaunched() {
        super.afterActivityLaunched()
        activity.runOnUiThread(object : Runnable {
            override fun run() {
                val manager = activity.supportFragmentManager
                val transaction = manager.beginTransaction()
                try {
                    fragment = mFragmentClass.newInstance()
                    transaction.replace(R.id.container, fragment)
                    transaction.commit()
                } catch (e: Exception) {
                    Assert.fail(String.format("%s: Could not insert %s into TestActivity: %s",
                            javaClass.simpleName,
                            mFragmentClass.simpleName,
                            e.message))
                }
            }
        })
    }
}
