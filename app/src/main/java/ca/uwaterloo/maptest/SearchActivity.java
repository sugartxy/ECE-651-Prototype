package ca.uwaterloo.maptest;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.app.TimePickerDialog;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;


public class SearchActivity extends FragmentActivity {

    static EditText StartEdit;
    static EditText EndEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        StartEdit = (EditText) findViewById(R.id.editTextStart);
        StartEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showTruitonTimePickerDialog(v);
                showTruitonDatePickerDialog(v);
            }
        });

        EndEdit = (EditText) findViewById(R.id.editTextEnd);
        EndEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTruitonTimePickerDialog(v);
                showTruitonDatePickerDialog(v);
            }
        });

        Spinner spinnerBuilding = (Spinner) findViewById(R.id.spinnerBuilding);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterBuilding = ArrayAdapter.createFromResource(this,
                R.array.spinnerBuilding, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterBuilding.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerBuilding.setAdapter(adapterBuilding);

        Spinner spinnerType = (Spinner) findViewById(R.id.spinnerType);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this,
                R.array.spinnerType, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerType.setAdapter(adapterType);
    }



    public void showTruitonDatePickerDialog(View v) {
        android.support.v4.app.DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends android.support.v4.app.DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            StartEdit.setText(day + "/" + (month + 1) + "/" + year);
            EndEdit.setText(day + "/" + (month + 1) + "/" + year);
        }
    }

    public void showTruitonTimePickerDialog(View v) {
        android.support.v4.app.DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public static class TimePickerFragment extends android.support.v4.app.DialogFragment implements
            TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            StartEdit.setText(StartEdit.getText() + " -" + hourOfDay + ":" + minute);
            EndEdit.setText(EndEdit.getText() + " -" + hourOfDay + ":" + minute);
        }
    }

    public void search(View view){
        // Search function here
        //Intent intent = new Intent(this,PostActivity.class);
        //startActivity(intent);
    }

}
