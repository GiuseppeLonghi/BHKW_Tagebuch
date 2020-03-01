package com.example.android.bhkwTagebuch.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.bhkwTagebuch.R;
import com.example.android.bhkwTagebuch.activity.DetailsActivity;
import com.example.android.bhkwTagebuch.util.Item;
import com.example.android.bhkwTagebuch.util.ItemAdapter;

import java.util.ArrayList;

/**
 * The Hotels {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {


    /**
     * Default Constructor
     */
    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        // Create a list of Hotels
        final ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(getResources().getString(R.string.Birroforum),
                getResources().getString(R.string.birroforum_address),
                R.drawable.events_birroforum,
                getResources().getString(R.string.Event_description),
                getResources().getString(R.string.Category_events)));
        items.add(new Item(getResources().getString(R.string.Christmas_market),
                getResources().getString(R.string.christas_navona_address),
                R.drawable.events_christmas_piazza_navona,
                getResources().getString(R.string.Event_description),
                getResources().getString(R.string.Category_events)));
        items.add(new Item(getResources().getString(R.string.Citta_della_pizza),
                getResources().getString(R.string.citta_della_pizza_address),
                R.drawable.events_citta_dellapizza,
                getResources().getString(R.string.Event_description),
                getResources().getString(R.string.Category_events)));
        items.add(new Item(getResources().getString(R.string.Exhibitions),
                getResources().getString(R.string.exhibitions_address),
                R.drawable.events_exhibitions,
                getResources().getString(R.string.Event_description),
                getResources().getString(R.string.Category_events)));
        items.add(new Item(getResources().getString(R.string.Museums_in_music),
                getResources().getString(R.string.museums_in_music_address),
                R.drawable.events_museums_in_music,
                getResources().getString(R.string.Event_description),
                getResources().getString(R.string.Category_events)));
        items.add(new Item(getResources().getString(R.string.Music),
                getResources().getString(R.string.music_address),
                R.drawable.events_music,
                getResources().getString(R.string.Event_description),
                getResources().getString(R.string.Category_events)));
        items.add(new Item(getResources().getString(R.string.Nightlife),
                getResources().getString(R.string.nightlife_address),
                R.drawable.events_nightlife,
                getResources().getString(R.string.Event_description),
                getResources().getString(R.string.Category_events)));
        items.add(new Item(getResources().getString(R.string.Romaeuropa),
                getResources().getString(R.string.romaeuropa_address),
                R.drawable.events_romaeuropa_festival,
                getResources().getString(R.string.Event_description),
                getResources().getString(R.string.Category_events)));
        items.add(new Item(getResources().getString(R.string.Taste_of_rome),
                getResources().getString(R.string.taste_rome_address),
                R.drawable.events_taste_of_roma,
                getResources().getString(R.string.Event_description),
                getResources().getString(R.string.Category_events)));
        items.add(new Item(getResources().getString(R.string.Warhol_rome),
                getResources().getString(R.string.warhol_address),
                R.drawable.events_warhol_marilyn_rome,
                getResources().getString(R.string.Event_description),
                getResources().getString(R.string.Category_events)));


        ItemAdapter adapter = new ItemAdapter(getActivity(), items);

        ListView listView = rootView.findViewById(R.id.fragment_items_lists);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Item item = items.get(position);

                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("category", item.getCategory());
                intent.putExtra("name", item.getName());
                intent.putExtra("image", item.getImageResourceId());
                intent.putExtra("location", item.getAddress());
                intent.putExtra("description", item.getDescription());

                // Start the new activity
                startActivity(intent);
            }
        });

        return rootView;
    }

}
