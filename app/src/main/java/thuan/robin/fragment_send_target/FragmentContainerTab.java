package thuan.robin.fragment_send_target;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class FragmentContainerTab extends Fragment {
    private TabLayout mTab;
    private ViewPager mViewPager;
    String tab = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_container_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTab = view.findViewById(R.id.tab_layout);
        mViewPager = view.findViewById(R.id.view_pager);
        AdapterViewPager adapterViewPager = new AdapterViewPager(getChildFragmentManager());
        List<Fragment> fragments=new ArrayList<>();
        mViewPager.get
        Log.d("hi", "onViewCreated: "+fragments.size());
        mViewPager.setAdapter(adapterViewPager);
        mTab.setupWithViewPager(mViewPager);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 12) {
                String tab = data.getExtras().getString("ROBIN_01");
                Log.d("log", "onActivityResult: " + tab);
            }
        }
    }
}
