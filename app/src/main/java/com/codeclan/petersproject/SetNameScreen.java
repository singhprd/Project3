package com.codeclan.petersproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;

/**
 * Created by user on 30/04/2016.
 */
public class SetNameScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_name_screen);

        final Zoo zoo = new Zoo();

        TextView header = (TextView) findViewById(R.id.setNameHeaderText);
        final EditText inputField = (EditText) findViewById(R.id.setNameTextInput);
        Button submitButton = (Button) findViewById(R.id.setNameSubmitButton);

        header.setText("Name your zoo!");
        inputField.setText("bobs zoo");
        inputField.getText();

        submitButton.setText("Submit Zoo Name");
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("batman log", "button clicked");
                zoo.setName(inputField.getText().toString());

                Intent intent = new Intent(getApplicationContext(), MainScreen.class);
                intent.putExtra("zoo", zoo);
                startActivity(intent);
            }
        });

    }
}



//        final Button button = (Button) findViewById(R.id.button_id);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//            }
//        });
//    }
