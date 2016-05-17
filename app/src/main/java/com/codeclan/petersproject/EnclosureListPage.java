package com.codeclan.petersproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

/**
 * Created by user on 06/05/2016.
 */
public class EnclosureListPage extends AppCompatActivity {
    Zoo zoo;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        Log.d("batman", "enclosure list page top");

        Intent intent = getIntent();
        zoo = (Zoo) intent.getExtras().get("zoo");

//        setContentView(R.layout.enclosure_list_page);

        EnclosureAdapter myAdapter = new EnclosureAdapter ( this, R.layout.enclosure_list_item, zoo.getArrayOfEnclosures());

        ListView myList = (ListView) findViewById(R.id.enclosureList);

        myList.setAdapter(myAdapter);

        Log.d("batman", "enclosure list page bottom");

    }
}
