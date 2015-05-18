package com.example.jack.conversion;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Spinner unitSpinner;
    private EditText amountTextView;
    private TextView teaspoonsTextView,tablespoonsTextView,cupTextView,ouncesTextView,pintsTextView,quartsTextView,gallonsTextView,
            pundsTextView,mililiterTextView,literTextView,milligramTextView,kilogramsTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToUnitTypeSpinner();

        addListinerToUnitTypeSpinner();


        amountTextView = (EditText)findViewById(R.id.amout_text_view);


        initializeTextViews();

    }

    public void initializeTextViews(){

        teaspoonsTextView =(TextView)findViewById(R.id.tsp_text_view);
        tablespoonsTextView=(TextView)findViewById(R.id.tbs_text_view);
        cupTextView=(TextView)findViewById(R.id.cup_text_view);
        ouncesTextView=(TextView)findViewById(R.id.oz_text_view);
        pintsTextView=(TextView)findViewById(R.id.pint_text_view);
        quartsTextView=(TextView)findViewById(R.id.quart_text_view);
        gallonsTextView=(TextView)findViewById(R.id.gallon_text_view);
        pundsTextView=(TextView)findViewById(R.id.pound_text_view);
        mililiterTextView=(TextView)findViewById(R.id.ml_text_view);
        literTextView=(TextView)findViewById(R.id.liter_text_view);
        milligramTextView=(TextView)findViewById(R.id.mg_text_view);
        kilogramsTextView=(TextView)findViewById(R.id.kg_text_view);

    }

   public void addItemsToUnitTypeSpinner(){

       unitSpinner = (Spinner)findViewById(R.id.unit_spinner);

       ArrayAdapter<CharSequence> unitTypeSpinnerAdapter =
               ArrayAdapter.createFromResource(this,R.array.Conversion_types,
                       android.R.layout.simple_spinner_item);

       unitTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


       unitSpinner.setAdapter(unitTypeSpinnerAdapter);

   }

    public void addListinerToUnitTypeSpinner(){

        unitSpinner = (Spinner)findViewById(R.id.unit_spinner);
        unitSpinner.setOnItemClickListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        String itemSelectedInSpinner = parent.getItemAtPosition(position).toString();

                        checkIfConvertFromTsp(itemSelectedInSpinner);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //TODO maybe something later

            }
        });







    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
