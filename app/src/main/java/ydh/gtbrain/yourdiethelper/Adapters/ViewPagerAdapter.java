package ydh.gtbrain.yourdiethelper.Adapters;

/**
 * Created by winchester on 21.08.17.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ydh.gtbrain.yourdiethelper.Fragments.*;//include all of fragments

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

        @Override
        public Fragment getItem(int position) {

            if(position == 0)
            {
                Schedule schedule = new Schedule();
                return schedule;
            }
            if(position == 1)
            {
                Main_diet mainDiet = new Main_diet();
                return mainDiet;
            }
            if(position == 2)
            {
                Choose_diet chooseDiet = new Choose_diet();
                return chooseDiet;
            }
            else
            {
                Main_diet mainDiet = new Main_diet();
                return mainDiet;
            }
        }

        // This method return the titles for the Tabs in the Tab Strip

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

