package thuan.robin.fragment_send_target;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class FragmentMain extends Fragment {
    private ListView mListTest;
    private ArrayList<String> list = new ArrayList<>();
    private TextView mResult;
    private Button mChange;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String test = bundle.getString("FRAGMENT_TAB_01");
            Log.d("TEST_FRAGMENT", "onCreate: " + test);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 0; i < 10; i++) {
            list.add("list test: " + i);
        }
        mListTest = view.findViewById(R.id.list_view);
        mListTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), FragmentMain.class);
                intent.putExtra("ROBIN_01", "0101");
                intent.putExtra("ROBIN_02", "0102");
                getTargetFragment().onActivityResult(12, RESULT_OK, intent);
                getFragmentManager().popBackStack();
               /* if (getTargetFragment() instanceof FragmentContainerTab) {
                    for (Fragment frg : getTargetFragment().getChildFragmentManager().getFragments()) {
                        if (frg instanceof FragmentTabOne) {
                            frg.onActivityResult(12, RESULT_OK, intent);
                            getFragmentManager().popBackStack();
                        }
                    }
                }*/
            }
        });
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        mListTest.setAdapter(adapter);
        mResult = view.findViewById(R.id.text);
        mChange = view.findViewById(R.id.change_view);
        mChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext() instanceof MainActivity) {
                    ((MainActivity) getContext()).addFragment(new FragmentContainerTab());
                }
            }
        });
    }
}
