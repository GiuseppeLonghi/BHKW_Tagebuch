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
public class MonumentsFragment extends Fragment {


    /**
     * Default Constructor
     */
    public MonumentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        // Create a list of Hotels
        final ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(getResources().getString(R.string.Arco_trionfo),
                getResources().getString(R.string.arco_trionfo_address),
                R.drawable.monument_arco_trionfo,
                getResources().getString(R.string.Monument_description),
                getResources().getString(R.string.Category_monuments)));
        items.add(new Item(getResources().getString(R.string.Cappella_sistina),
                getResources().getString(R.string.cappella_sistina_address),
                R.drawable.monument_cappella_sistina,
                getResources().getString(R.string.Monument_description),
                getResources().getString(R.string.Category_monuments)));
        items.add(new Item(getResources().getString(R.string.Castel_gandolfo),
                getResources().getString(R.string.castel_gandolfo_address),
                R.drawable.monument_castel_gandolfo,
                getResources().getString(R.string.Monument_description),
                getResources().getString(R.string.Category_monuments)));
        items.add(new Item(getResources().getString(R.string.Colosseo),
                getResources().getString(R.string.colosseo_address),
                R.drawable.monument_colosseo,
                getResources().getString(R.string.Monument_description),
                getResources().getString(R.string.Category_monuments)));
        items.add(new Item(getResources().getString(R.string.Fontana_trevi),
                getResources().getString(R.string.fontana_trevi_address),
                R.drawable.monument_fontana_trevi,
                getResources().getString(R.string.Monument_description),
                getResources().getString(R.string.Category_monuments)));
        items.add(new Item(getResources().getString(R.string.Fori_imperiali),
                getResources().getString(R.string.fori_imperiali_address),
                R.drawable.monument_fori_imperiali,
                getResources().getString(R.string.Monument_description),
                getResources().getString(R.string.Category_monuments)));
        items.add(new Item(getResources().getString(R.string.Piazza_Navona),
                getResources().getString(R.string.piazza_navona_address),
                R.drawable.monument_navona_square,
                getResources().getString(R.string.Monument_description),
                getResources().getString(R.string.Category_monuments)));
        items.add(new Item(getResources().getString(R.string.Pantheon),
                getResources().getString(R.string.pantheon_address),
                R.drawable.monument_pantheon,
                getResources().getString(R.string.Monument_description),
                getResources().getString(R.string.Category_monuments)));
        items.add(new Item(getResources().getString(R.string.Piramide),
                getResources().getString(R.string.piramide_address),
                R.drawable.monument_piramide_cestia,
                getResources().getString(R.string.Monument_description),
                getResources().getString(R.string.Category_monuments)));
        items.add(new Item(getResources().getString(R.string.Vittoriano),
                getResources().getString(R.string.vittoriano_address),
                R.drawable.monument_vittoriano,
                getResources().getString(R.string.Monument_description),
                getResources().getString(R.string.Category_monuments)));


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
