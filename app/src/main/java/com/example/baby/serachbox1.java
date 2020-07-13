package com.example.baby;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class serachbox1 extends AppCompatActivity {
        SearchView containersearchView;
        ListView containerSearchListView;
        ArrayList<String> containersearchlist;
        ArrayAdapter<String> searchadapter;
        String[] names=new String[]{"Abin","Ajay","Aju","sumith","Anakha","Shira","Adithi","Isha","Ishika","Iksha","Ian","rin","Isabelle",
                "Izhaan","Imran","Irfan","Irtaza","Iqbal","Imad","Ibn",

                "Imogen",
                "Isabel",
                "Ivy",
                "Charlie","Cailean",
                "Calvin","Camerron","Calum","Cadassi","Cadmon","Calder","Cane","Carl","Carver","Ceol",
                "Charlotte",
                "Connor",
                "Cameron",
                "Conor",
                "Caitlin",
                "Cara",
                "Chi"

        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_serachbox1);
            containersearchView = (SearchView) findViewById(R.id.search);
            containerSearchListView = (ListView) findViewById(R.id.list);

            containersearchlist = new ArrayList<>();
            for (int i=0;i<names.length;i++)
            {
                containersearchlist.add(names[i]);
            }




            searchadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, containersearchlist);


            containersearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                    if (containersearchlist.contains(query)) {
                        searchadapter.getFilter().filter(query);
                    } else {
                        Toast.makeText(serachbox1.this, "No Match found", Toast.LENGTH_LONG).show();
                    }
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    searchadapter.getFilter().filter(newText);
                    containerSearchListView.setAdapter(searchadapter);
                    return false;
                }
            });

        }

    }