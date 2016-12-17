package com.example.brian.monthlybudget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;


/* This class opens the budget report stored in the database and the
 * user can edit the edit text fields. Once the user is done updating
 * the fields, the user clicks on the save icon in the action bar to
 * recalculate the total expenses and total savings, and then it stores
 * the changes in the database.
 * */
public class OpenReportActivity extends AppCompatActivity {

    // Declare list view
    ListView listView;

    // Create a variable for firebase database
    private FirebaseDatabase database;

    // Declare database reference
    private DatabaseReference ref;

    // Create an array list.
    ArrayList<String> list = new ArrayList<>();
    //HashMap<String, String> hm = new HashMap<>();
    // Create an array adapter
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_report);

        // Assign the list view to a local variable.
        listView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,list);
        // Set the adapter to the list view
        listView.setAdapter(adapter);
        // Assign the reference of the firebase database instance locally.
        ref = FirebaseDatabase.getInstance().getReference();

        // Child event listener for the reference
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // Store the value retrieved from firebase database
                String value = dataSnapshot.getValue(String.class);
                // Put the string value retrieved from the database to the arrayList.
                list.add(value);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }


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
        return super.onOptionsItemSelected(item);
    }

}
