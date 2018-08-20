package thuan.robin.fragment_send_target;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentTabOne extends Fragment {
    private ListView mListView;
    private ArrayList<String> mListString;
    private TextView mResult;
    private String text;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListString = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mListString.add(FragmentTabOne.class.getSimpleName() + i);
        }
        mListView = view.findViewById(R.id.list_view);
        mResult = view.findViewById(R.id.text_return);
        mListView.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mListString));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("FRAGMENT_TAB_01", "TAB_01");
                Fragment fragment = new FragmentMain();
                fragment.setArguments(bundle);
                fragment.setTargetFragment(FragmentTabOne.this.getParentFragment(), 12);
                if (getContext() instanceof MainActivity) {
                    ((MainActivity) getContext()).addFragment(fragment);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void setText(String data) {
        mResult.setText(data);
    }
}
