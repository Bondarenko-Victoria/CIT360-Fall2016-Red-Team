package com.example.brian.monthlybudget;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


/* This class creates a new monthly budget report. The user enters numbers in the edit text fields.
*  Once all the fields are filled out, the user clicks on the save icon in the action bar to see the
*  total expenses and total savings. All the user input and results will be stored in the firebase database
*/
public class CreateReportActivity extends AppCompatActivity {
    // Edit text field declarations
    private EditText etMonthlyIncome;
    private EditText etPhoneBill;
    private EditText etMortgageRent;
    private EditText etGasTransportation;
    private EditText etUtilities;
    private EditText etCableInternet;
    private EditText etCarInsurance;
    private EditText etFood;
    private EditText etPersonal;
    private EditText etOther;
    private EditText etTaxes;
    private TextView tvTotalExpenses;
    private TextView tvSavings;

    // Create a variable for firebase authentication
    private FirebaseAuth firebaseAuth;

    // Create a database reference
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_report);

        // Assign edit text fields and text views to variables.
        etMonthlyIncome = (EditText) findViewById(R.id.etMonthlyIncome);
        etPhoneBill = (EditText) findViewById(R.id.etPhoneBill);
        etMortgageRent = (EditText) findViewById(R.id.etMortgageRent);
        etGasTransportation = (EditText) findViewById(R.id.etGasTransportation);
        etUtilities = (EditText) findViewById(R.id.etUtilities);
        etCableInternet = (EditText) findViewById(R.id.etCableInternet);
        etCarInsurance = (EditText) findViewById(R.id.etCarInsurance);
        etFood = (EditText) findViewById(R.id.etFood);
        etPersonal = (EditText) findViewById(R.id.etPersonal);
        etOther = (EditText) findViewById(R.id.etOther);
        etTaxes = (EditText) findViewById(R.id.etTaxes);
        tvTotalExpenses = (TextView) findViewById(R.id.tvTotalExpenses);
        tvSavings = (TextView) findViewById(R.id.tvSavings);


        // Set OnClick listeners for the buttons
        //saveButton.setOnClickListener(this);

        // Initializes the firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        // Get the reference of the firebase database instance.
        databaseReference = FirebaseDatabase.getInstance().getReference();


    }

    /* Calculates the total expenses and total savings.
     * After calculations, the results will be displayed in the corresponding text views.
     * Finally, it saves all the user input data and calculations in the firebase database.
     */
    public void calculateResultsAndStoreToFirebase() {
        // Convert user input String into (double) numbers.
        String monthlyIncomeStr = etMonthlyIncome.getText().toString();
        String phoneBillStr = etPhoneBill.getText().toString();
        String mortgageRentStr = etMortgageRent.getText().toString();
        String gasTransportationStr = etGasTransportation.getText().toString();
        String utilitiesStr = etUtilities.getText().toString();
        String cableInternetStr = etCableInternet.getText().toString();
        String carInsuranceStr = etCarInsurance.getText().toString();
        String foodStr = etFood.getText().toString();
        String personalStr = etPersonal.getText().toString();
        String otherStr = etOther.getText().toString();
        String taxesStr = etTaxes.getText().toString();

        // Store each user input value in a String array
        String[] userInput = {monthlyIncomeStr, phoneBillStr, mortgageRentStr
                , gasTransportationStr, utilitiesStr, cableInternetStr
                , cableInternetStr, carInsuranceStr, foodStr, personalStr
                , otherStr, taxesStr};

        // Loops through each element in the array and sets to "0" to
        // any element that is an empty string
        for (int i = 0; i < userInput.length; i++) {
            if (userInput[i].isEmpty()) {
                userInput[i] = "0";
            }
        }

        // Create an array of double numbers
        double[] numbers = new double[11];
        // Loops through each element in the user input String array
        for(int i = 0; i < numbers.length; i++){
            // Converts each user input String value into Double, and assigns each user input value
            // into each element in the array of double numbers.
            numbers[i] = Double.parseDouble(userInput[i]);
        }

        // Create and initialize a variable to store the total expenses
        double totalExpenses = 0;
        // Loops through each element in the numbers array starting from the second value
        // so that it doesn't include the monthly income value.
        for (int i = 1; i < numbers.length; i++) {
            // Sums all the values except for the monthly income and stores the result in the
            // totalExpenses variable
            totalExpenses += numbers[i];
        }
        // Calculate total savings
        // The first value in the numbers array is the monthly income value
        double totalSavings = numbers[0] - totalExpenses;

        // Store the total expenses and total savings in an array of type double.
        double[] results = {totalExpenses, totalSavings};


        // Convert the total expenses double number into String
        // The first element in the results array is the total expenses
        String totalExpensesStr = Double.toString(results[0]);
        // Convert the total savings double number into String
        // The second element in the results array is the total savings.
        String totalSavingsStr = Double.toString(results[1]);

        // Sets the total expenses string in the total expenses text view
        tvTotalExpenses.setText(totalExpensesStr);
        // Sets the total savings string in the total savings text view
        tvSavings.setText(totalSavingsStr);

        HashMap<String, String> monthlyBudget = new HashMap<>();
        monthlyBudget.put("Monthly Income", monthlyIncomeStr);
        monthlyBudget.put("Phone Bill", phoneBillStr);
        monthlyBudget.put("Gas/Transportation", gasTransportationStr);
        monthlyBudget.put("Utilities", utilitiesStr);
        monthlyBudget.put("Cable/Internet", cableInternetStr);
        monthlyBudget.put("Car Insurance", carInsuranceStr);
        monthlyBudget.put("Food", foodStr);
        monthlyBudget.put("Personal", personalStr);
        monthlyBudget.put("Other", otherStr);
        monthlyBudget.put("Taxes", taxesStr);
        monthlyBudget.put("Total Expenses", totalExpensesStr);
        monthlyBudget.put("Total Savings", totalSavingsStr);

        // Save data in firebase
        databaseReference.child("Monthly Budget").setValue(monthlyBudget.toString());


//        databaseReference.child("Monthly Income").setValue(monthlyIncomeStr);
//        databaseReference.child("Phone Bill").setValue(phoneBillStr);
//        databaseReference.child("Mortgage/Rent").setValue(mortgageRentStr);
//        databaseReference.child("Gas/Transportation").setValue(gasTransportationStr);
//        databaseReference.child("Utilities").setValue(utilitiesStr);
//        databaseReference.child("Cable/Internet").setValue(cableInternetStr);
//        databaseReference.child("Car Insurance").setValue(carInsuranceStr);
//        databaseReference.child("Food").setValue(foodStr);
//        databaseReference.child("Personal").setValue(personalStr);
//        databaseReference.child("Other").setValue(otherStr);
//        databaseReference.child("Taxes").setValue(taxesStr);
//        databaseReference.child("Total Expenses").setValue(totalExpensesStr);
//        databaseReference.child("Total Savings").setValue(totalSavingsStr);

        // Display a message to let the user know the data was saved
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    // OnClick listener for the save button
//    @Override
//    public void onClick(View view) {
//        if (view == saveButton) {
//            calculateResultsAndStoreToFirebase();
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.backIcon) {
            startActivity(new Intent(this, AppMenuActivity.class));
        }

        if (id == R.id.saveIcon) {
            calculateResultsAndStoreToFirebase();
        }

        return super.onOptionsItemSelected(item);
    }

}
