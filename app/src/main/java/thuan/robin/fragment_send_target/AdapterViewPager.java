package thuan.robin.fragment_send_target;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AdapterViewPager extends FragmentPagerAdapter {
    public Fragment getCurrentFragment() {
        return mCurrentFragment;
    }

    public void setCurrentFragment(Fragment mCurrentFragment) {
        this.mCurrentFragment = mCurrentFragment;
    }

    private Fragment mCurrentFragment;

    public AdapterViewPager(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentTabOne();
                break;
            case 1:
                fragment = new FragmentTabTwo();
                break;
            default:
                break;
        }
        setCurrentFragment(fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "TAB_01";
                break;
            case 1:
                title = "TAB_02";
                break;
            default:
                break;
        }
        return title;
    }


}
