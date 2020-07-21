package com.example.ex18;

import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class WordListFragment extends ListFragment {
    String[] WORDS={"boy","girl","school","hello","go"};
    String[] DESC={"A boy ...", "A Girl ...", "A school ...","You say ...","When you ..."};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, WORDS));

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextView text = getActivity().findViewById(R.id.text);
        text.setText(DESC[position]);
    }
}
