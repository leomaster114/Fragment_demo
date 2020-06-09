package com.hoanv.fragment_demo;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends androidx.fragment.app.ListFragment {
    ItemSelected activity;
    public interface ItemSelected{
        void onItemSelected(int index);
    }
    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] data ;
        data = getResources().getStringArray(R.array.pieces);
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        // the phone is in landscape mode
        if(getActivity().findViewById(R.id.layout_land)!= null){
            activity.onItemSelected(0);
        }

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
       activity.onItemSelected(position);

    }
}
