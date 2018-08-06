package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        // Initialise the ArrayList
        alNumbers = new ArrayList<>();

        // Create an ArrayAdapter using the default Spinner layout and teh ArrayList
        aaNumbers = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        // Add items to array - 1st Way
        //alNumbers.add("2");
        //alNumbers.add("4");
        //alNumbers.add("6");

        // Add items to array - 2nd Way (Using string array created in strings.xml
        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

        // Convert Array to List and add to the ArrayList
        alNumbers.addAll(Arrays.asList(strNumbers));

        // Bind the ArrayAdapter to the Spinner
        spn2.setAdapter(aaNumbers);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                switch (pos) {
                    // Load selected number list based on the selection of spn1
                    case 0:
                        String[] strEvenNumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(strEvenNumbers));
                        spn2.setAdapter(aaNumbers);
                        break;

                    case 1:
                        String[] strOddNumbers = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(strOddNumbers));
                        spn2.setAdapter(aaNumbers);
                        break;

                }

            }
        });

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                alNumbers.clear();

                switch (i) {
                // Load selected number list based on the selection of spn1
                    case 0:
                        String[] strEvenNumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(strEvenNumbers));
                        spn2.setAdapter(aaNumbers);
                        spn2.setSelection(2);
                        break;

                    case 1:
                        String[] strOddNumbers = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(strOddNumbers));
                        spn2.setAdapter(aaNumbers);
                        spn2.setSelection(1);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
