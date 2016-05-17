package com.codeclan.petersproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Created by user on 02/05/2016.
 */
public class EnclosureBuyScreen extends AppCompatActivity {
    Zoo zoo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enclosure_buy_screen);
        final Intent intent = getIntent();
        zoo = (Zoo) intent.getExtras().get("zoo");

        TextView header = (TextView) findViewById(R.id.enclosureBuyHeader);
        header.setText("Buy Screen for Enclosures");
        TextView costView = (TextView) findViewById(R.id.enclosureCostView);
        final NumberPicker enclosureSizePicker = (NumberPicker) findViewById(R.id.enclosureSizePicker);

        enclosureSizePicker.setMaxValue(1000);
        enclosureSizePicker.setMinValue(1);
        enclosureSizePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                NumberPicker enclosureSizePicker = (NumberPicker) findViewById(R.id.enclosureSizePicker);
                TextView costView = (TextView) findViewById(R.id.enclosureCostView);

                int a = Enclosure.calculateCostOfEnclosure(enclosureSizePicker.getValue());
                String cost = String.valueOf(a);
                costView.setText("$" + cost);
            }
        });

        Button submitButton = (Button) findViewById(R.id.buyEnclosureButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView errorText = (TextView) findViewById(R.id.errorView);
                boolean canBuy = zoo.buyNewEnclosure(enclosureSizePicker.getValue());
                if (canBuy) {
                    Context context1 = EnclosureBuyScreen.this;
                    Intent backToMain = new Intent(context1, MainScreen.class);
                    backToMain.putExtra("zoo", zoo);
                    startActivity(backToMain);
                } else {
                    errorText.setText("Not enough dollars, Sir.");
                }
            }
        });
    }
}