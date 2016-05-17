package com.codeclan.petersproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

/**
 * Created by user on 30/04/2016.
 */
public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        Intent intent = getIntent();
        final Zoo zoo = (Zoo) intent.getExtras().get("zoo");
        String name = zoo.getName();

        TextView headerText = (TextView) findViewById(R.id.mainScreenHeader);
        TextView header1 = (TextView) findViewById(R.id.header1);
        final TextView header1Data = (TextView) findViewById(R.id.header1Data);
        TextView header2 = (TextView) findViewById(R.id.header2);
        final TextView header2Data = (TextView) findViewById(R.id.header2Data);
        TextView header3 = (TextView) findViewById(R.id.header3);
        final TextView header3Data = (TextView) findViewById(R.id.header3Data);
        TextView header4 = (TextView) findViewById(R.id.header4);
        TextView header4Data = (TextView) findViewById(R.id.header4Data);

        headerText.setText(name);

        final String money = String.valueOf(zoo.getCurrentBalance());
        header1.setText("Money");
        header1Data.setText( money );

        final String exoticRating = String.valueOf(zoo.getAverageExoticness());
        header2.setText("Exotic Rating of Zoo");
        header2Data.setText( exoticRating );

        final String numberOfAnimals = String.valueOf(zoo.countAllAnimals());

        header3.setText("Number of Animals");
        header3Data.setText(numberOfAnimals);

        int numberOfEnclosures = zoo.numberOfEnclosures();
        String numberOfEnclosuresString = String.valueOf(numberOfEnclosures);
        header4.setText("Number of Enclosures");
        header4Data.setText(numberOfEnclosuresString);

        Button addEnclosureButton = (Button) findViewById(R.id.addEnclosure);
        Button buyAnimal = (Button) findViewById(R.id.buyAnimalButton);

            buyAnimal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent toSend = new Intent(getApplicationContext(), EnclosureListPage.class);
                    toSend.putExtra("zoo", zoo);
                    startActivity(toSend);
                }
            });


        addEnclosureButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("batman", "add Enclosure clicked");
                Intent intent = new Intent(getApplicationContext(), EnclosureBuyScreen.class);
                intent.putExtra("zoo", zoo);
                startActivity(intent);

            }
        });
    }
}
