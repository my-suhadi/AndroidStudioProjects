package id.go.dephub.itjen.viewpager.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.go.dephub.itjen.viewpager.Akun
import id.go.dephub.itjen.viewpager.Beranda
import id.go.dephub.itjen.viewpager.Pengaturan
import id.go.dephub.itjen.viewpager.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var mainFragment = Fragment()
        val akun = Akun()
        val beranda = Beranda()
        val pengaturan = Pengaturan()

        when(position) {
            0 -> mainFragment = beranda
            1 -> mainFragment = akun
            2 -> mainFragment = pengaturan
        }

        return mainFragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}