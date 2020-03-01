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
public class RestaurantsFragment extends Fragment {


    /**
     * Default Constructor
     */
    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        // Create a list of Hotels
        final ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(getResources().getString(R.string.Al_34),
                getResources().getString(R.string.al34_address),
                R.drawable.restaurant_al_34,
                getResources().getString(R.string.Restaurant_description),
                getResources().getString(R.string.Category_restaurants)));
        items.add(new Item(getResources().getString(R.string.Al_Colosseo),
                getResources().getString(R.string.al_colosseo_address),
                R.drawable.restaurant_al_colosseo,
                getResources().getString(R.string.Restaurant_description),
                getResources().getString(R.string.Category_restaurants)));
        items.add(new Item(getResources().getString(R.string.Cosolini),
                getResources().getString(R.string.cosolini_address),
                R.drawable.restaurant_cosolini,
                getResources().getString(R.string.Restaurant_description),
                getResources().getString(R.string.Category_restaurants)));
        items.add(new Item(getResources().getString(R.string.Cotto),
                getResources().getString(R.string.cotto_address),
                R.drawable.restaurant_cotto,
                getResources().getString(R.string.Restaurant_description),
                getResources().getString(R.string.Category_restaurants)));
        items.add(new Item(getResources().getString(R.string.Fine_dining_lovers),
                getResources().getString(R.string.fine_dining_address),
                R.drawable.restaurant_fine_dining_lovers,
                getResources().getString(R.string.Restaurant_description),
                getResources().getString(R.string.Category_restaurants)));
        items.add(new Item(getResources().getString(R.string.Glass_hostaria),
                getResources().getString(R.string.glass_hostaria_address),
                R.drawable.restaurant_glass_hostaria,
                getResources().getString(R.string.Restaurant_description),
                getResources().getString(R.string.Category_restaurants)));
        items.add(new Item(getResources().getString(R.string.Piazza_Navona),
                getResources().getString(R.string.piazza_navona_address),
                R.drawable.restaurant_piazza_navona,
                getResources().getString(R.string.Restaurant_description),
                getResources().getString(R.string.Category_restaurants)));
        items.add(new Item(getResources().getString(R.string.Settemari),
                getResources().getString(R.string.settemari_address),
                R.drawable.restaurant_settemari,
                getResources().getString(R.string.Restaurant_description),
                getResources().getString(R.string.Category_restaurants)));
        items.add(new Item(getResources().getString(R.string.Tempio_iside),
                getResources().getString(R.string.tempio_di_iside_address),
                R.drawable.restaurant_tempio_di_iside,
                getResources().getString(R.string.Restaurant_description),
                getResources().getString(R.string.Category_restaurants)));
        items.add(new Item(getResources().getString(R.string.Tetti_di_roma),
                getResources().getString(R.string.tetti_di_roma_address),
                R.drawable.restaurant_tetti_di_rome,
                getResources().getString(R.string.Restaurant_description),
                getResources().getString(R.string.Category_restaurants)));


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
