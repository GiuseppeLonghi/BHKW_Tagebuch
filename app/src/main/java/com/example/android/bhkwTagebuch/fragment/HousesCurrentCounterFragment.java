package com.example.android.bhkwTagebuch.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.bhkwTagebuch.R;
import com.example.android.bhkwTagebuch.activity.HousesCurrentMetersActivity;
import com.example.android.bhkwTagebuch.util.Item;
import com.example.android.bhkwTagebuch.util.ItemAdapter;

import java.util.ArrayList;

public class HousesCurrentCounterFragment extends Fragment {
 /* Default Constructor */

    public HousesCurrentCounterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        // Create a list of Items
        final ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(getResources().getString(R.string.House1),
                getResources().getString(R.string.House1ElectricityCounterNumber),
                getResources().getString(R.string.House1Address),
                R.drawable.house1_electricity_meter));
        items.add(new Item(getResources().getString(R.string.House2),
                getResources().getString(R.string.House2ElectricityCounterNumber),
                getResources().getString(R.string.House2Address),
                R.drawable.house2_electricity_meter));
        items.add(new Item(getResources().getString(R.string.House3),
                getResources().getString(R.string.House3ElectricityCounterNumber),
                getResources().getString(R.string.House3Address),
                R.drawable.house3_electricity_meter));
        items.add(new Item(getResources().getString(R.string.House4),
                getResources().getString(R.string.House4ElectricityCounterNumber),
                getResources().getString(R.string.House4Address),
                R.drawable.house4_electricity_meter));
        items.add(new Item(getResources().getString(R.string.General),
                getResources().getString(R.string.GeneralElectricityCounterNumber),
                getResources().getString(R.string.GeneralAddress),
                R.drawable.general_electricity_meter));

        ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        // Here we get the ListView object from the fragment.xml and set up the adapter object
        // created before. The ItemAdapter has its own layout. This will be displayed as part of the
        // ListView
        ListView listView = rootView.findViewById(R.id.fragment_items_lists);
        listView.setAdapter(adapter);

        // Set the OnItemClickListener on each object displayed on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Item item = items.get(position);

                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(getActivity(), HousesCurrentMetersActivity.class);
                intent.putExtra("houseNumber", item.getHouseNumber());
                intent.putExtra("image", item.getImageResourceId());
                intent.putExtra("location", item.getAddress());
                intent.putExtra("counterNumber", item.getCounterNumber());

                // Start the new activity
                startActivity(intent);
            }
        });

        return rootView;
    }
}