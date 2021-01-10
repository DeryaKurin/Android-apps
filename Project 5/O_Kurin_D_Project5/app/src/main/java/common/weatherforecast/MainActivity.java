package common.weatherforecast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.derya_o_kurin_weather_forecast.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private ArrayList<String> cityItems =new ArrayList<String>();
	private ListView cityListView;
    private Button addCity;
    private EditText cityName;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cityName = (EditText) findViewById(R.id.cityName);
		cityListView =(ListView) findViewById(R.id.MyListView);
		cityListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cityItems));


		addCity = findViewById(R.id.button_add_city);


		addCity.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				cityItems.add(cityName.getText().toString());
				((BaseAdapter) cityListView.getAdapter()).notifyDataSetChanged();
			}
		});

		cityListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
										   int arg2, long arg3) {

				// Can't manage to remove an item here
				cityItems.remove(arg2);//where arg2 is position of item you click
				((BaseAdapter) cityListView.getAdapter()).notifyDataSetChanged();
				return false;
			}
		});


		cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int arg2, long arg3) {

				changeCity(cityItems.get(arg2));
			}
		});



	    if (savedInstanceState == null) {
	       getSupportFragmentManager().beginTransaction()
	                .add(R.id.container, new WeatherFragment())
	                .commit();
	    }
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weather, menu);
		return true;
	}


	 
	public void changeCity(String city){
	    WeatherFragment wf = (WeatherFragment)getSupportFragmentManager()
	                            .findFragmentById(R.id.container);
	    wf.changeCity(city);
	    new CityPreference(this).setCity(city);
	}
	
}
