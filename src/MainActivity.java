package com.example.e_bloodbank;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/*public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}*/

public class MainActivity extends Activity implements OnItemSelectedListener {
	 Spinner spinnerbloodGroups;
	 TextView selGroup;
	 private String[] state = { "O+ve", "O-ve", "A+ve", "A-ve", "B+ve", "B-ve", "AB+ve", "AB-ve" };

	  @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
	  System.out.println(state.length);
	  selGroup = (TextView) findViewById(R.id.selGroup);
	  spinnerbloodGroups = (Spinner) findViewById(R.id.bloodGroups);
	  ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
	    android.R.layout.simple_spinner_item, state);
	  adapter_state
	    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	  spinnerbloodGroups.setAdapter(adapter_state);
	  spinnerbloodGroups.setOnItemSelectedListener(this);

	  }

	  public void onItemSelected(AdapterView<?> parent, View view, int position,
	   long id) {
	  spinnerbloodGroups.setSelection(position);
	  String selState = (String) spinnerbloodGroups.getSelectedItem();
	  selGroup.setText("Selected Blood Group: " + selState);
	 }

	  @Override
	 public void onNothingSelected(AdapterView<?> arg0) {
	  // TODO Auto-generated method stub

	  }
	  
	  @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

}
