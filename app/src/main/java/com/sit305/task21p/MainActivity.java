package com.sit305.task21p;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

/* Created by Sean Corcoran for Deakin University Unit SIT305
*  Task 2.1P
*  March 2021
* */

public class MainActivity extends AppCompatActivity {

    // Define the GUI fields
    EditText inputValueEditText;
    TextView resultsField1;
    TextView unitTypeField1;
    TextView resultsField2;
    TextView unitTypeField2;
    TextView resultsField3;
    TextView unitTypeField3;
    Spinner spinner;

    // Define how many decimal places to use.
    DecimalFormat dp = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the GUI fields from their IDs.
        spinner = findViewById(R.id.spinner);
        inputValueEditText = findViewById(R.id.inputValue);

        resultsField1 = findViewById(R.id.resultsField1);
        unitTypeField1 = findViewById(R.id.unitTypeField1);

        resultsField2 = findViewById(R.id.resultsField2);
        unitTypeField2 = findViewById(R.id.unitTypeField2);

        resultsField3 = findViewById(R.id.resultsField3);
        unitTypeField3 = findViewById(R.id.unitTypeField3);

        // Create the adapter from the resource file holding the array and set the layout style
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item);
        // Set the layout style with the dropdown shows
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Set the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void convertMeasurement(View view) {

        // Get the current selected spinner position
        int selected = spinner.getSelectedItemPosition();

        // Check to see if the selected item is the correct unit of measurement.
        if (selected == 0)
        {
            double input = getUserInput(inputValueEditText);

            // Set the result in CM.
            resultsField1.setText(Double.toString(input * 100));

            // Show the CM unit.
            unitTypeField1.setText("Centimetre");

            // Set the result in feet.
            resultsField2.setText(dp.format(input * 3.281));

            // Show the feet unit.
            unitTypeField2.setText("Foot");

            // Set the result in inches.
            resultsField3.setText(dp.format(input * 39.37));

            // Show the inches unit.
            unitTypeField3.setText("Inch");
        }
        else
        {
            // Incorrect selected item
            Toast.makeText(getApplicationContext(),"Please select the correct conversion icon.",Toast.LENGTH_LONG).show();
        }
    }

    public void convertTemperature(View view) {

        // Get the current selected spinner position
        int selected = spinner.getSelectedItemPosition();

        // Check to see if the selected item is the correct unit of measurement.
        if (selected == 1)
        {
            double input = getUserInput(inputValueEditText);

            // Set the result in fahrenheit.
            resultsField1.setText(dp.format((input * 9/5) + 32));

            // Show the fahrenheit unit.
            unitTypeField1.setText("Fahrenheit");

            // Set the result in Kelvin.
            resultsField2.setText(dp.format(input + 273.15));

            // Show the Kelvin unit.
            unitTypeField2.setText("Kelvin");

            // Show blank.
            resultsField3.setText("");

            // Show blank.
            unitTypeField3.setText("");
        }
        else
        {
            // Incorrect selected item
            Toast.makeText(getApplicationContext(),"Please select the correct conversion icon.",Toast.LENGTH_LONG).show();
        }
    }

    public void convertMass(View view) {
        // Get the current selected spinner position
        int selected = spinner.getSelectedItemPosition();

        // Check to see if the selected item is the correct unit of measurement.
        if (selected == 2)
        {
            double input = getUserInput(inputValueEditText);

            // Set the result in grams
            resultsField1.setText(Double.toString(input * 1000));

            // Show the gram unit.
            unitTypeField1.setText("Gram");

            // Set the result in Oz.
            resultsField2.setText(dp.format(input * 35.274));

            // Show the Ounces unit.
            unitTypeField2.setText("Ounce(Oz)");

            // Set the result in pounds.
            resultsField3.setText(dp.format(input * 2.205));

            // Show the pounds unit.
            unitTypeField3.setText("Pound(lb)");
        }
        else
        {
            // Incorrect selected item
            Toast.makeText(getApplicationContext(),"Please select the correct conversion icon.",Toast.LENGTH_LONG).show();
        }
    }

    // Returns a double from an passed editText field. (Error checks to make sure it can be parse as a double)
    private double getUserInput(EditText inputField)
    {
        try {
            return Double.parseDouble(inputField.getText().toString());
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Error getting unit to convert",Toast.LENGTH_LONG).show();
            return 0;
        }
    }
}
