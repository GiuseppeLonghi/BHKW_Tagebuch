package com.example.android.tourguide.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.activity.DetailsActivity;
import com.example.android.tourguide.util.Item;
import com.example.android.tourguide.util.ItemAdapter;

import java.util.ArrayList;

/**
 * The Hotels {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {


    /**
     * Default Constructor
     */
    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        // Create a list of Items
        final ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(getResources().getString(R.string.Albani),
                getResources().getString(R.string.Albani_address),
                R.drawable.hotel_albani,
                getResources().getString(R.string.Hotel_description),
                getResources().getString(R.string.Category_hotels)));
        items.add(new Item(getResources().getString(R.string.Antico),
                getResources().getString(R.string.Antico_address),
                R.drawable.hotel_antico,
                getResources().getString(R.string.Hotel_description),
                getResources().getString(R.string.Category_hotels)));
        items.add(new Item(getResources().getString(R.string.Ariston),
                getResources().getString(R.string.Ariston_address),
                R.drawable.hotel_ariston,
                getResources().getString(R.string.Hotel_description),
                getResources().getString(R.string.Category_hotels)));
        items.add(new Item(getResources().getString(R.string.Aurelia),
                getResources().getString(R.string.Aurelia_address),
                R.drawable.hotel_aurelia,
                getResources().getString(R.string.Hotel_description),
                getResources().getString(R.string.Category_hotels)));
        items.add(new Item(getResources().getString(R.string.Capo_DAfrica),
                getResources().getString(R.string.Capo_DAfrica_address),
                R.drawable.hotel_capo_dafrica,
                getResources().getString(R.string.Hotel_description),
                getResources().getString(R.string.Category_hotels)));
        items.add(new Item(getResources().getString(R.string.Decó),
                getResources().getString(R.string.Deco_address),
                R.drawable.hotel_deco,
                getResources().getString(R.string.Hotel_description),
                getResources().getString(R.string.Category_hotels)));
        items.add(new Item(getResources().getString(R.string.Imperiale),
                getResources().getString(R.string.Imperiale_address),
                R.drawable.hotel_imperiale,
                getResources().getString(R.string.Hotel_description),
                getResources().getString(R.string.Category_hotels)));
        items.add(new Item(getResources().getString(R.string.Lifestyle),
                getResources().getString(R.string.Lifestyle_address),
                R.drawable.hotel_lifestyle,
                getResources().getString(R.string.Hotel_description),
                getResources().getString(R.string.Category_hotels)));
        items.add(new Item(getResources().getString(R.string.Marriot_Park),
                getResources().getString(R.string.Marrior_Park_address),
                R.drawable.hotel_marriot_park,
                getResources().getString(R.string.Hotel_description),
                getResources().getString(R.string.Category_hotels)));
        items.add(new Item(getResources().getString(R.string.Otivm),
                getResources().getString(R.string.Otivm_address),
                R.drawable.hotel_otium,
                getResources().getString(R.string.Hotel_description),
                getResources().getString(R.string.Category_hotels)));


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
