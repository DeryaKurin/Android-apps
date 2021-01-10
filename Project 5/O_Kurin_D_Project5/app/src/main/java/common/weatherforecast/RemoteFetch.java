package common.weatherforecast;

import android.content.Context;

import com.derya_o_kurin_weather_forecast.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RemoteFetch {
 
    private static final String API_KEY =
            "http://api.openweathermap.org/data/2.5/weather?q=%s&units=imperial";
     
    public static JSONObject getJSON(Context context, String city){
        try {
            URL url = new URL(String.format(API_KEY, city));
            HttpURLConnection connection = 
                    (HttpURLConnection)url.openConnection();
             
            connection.addRequestProperty("x-api-key", 
                    context.getString(R.string.open_weather_maps_app_id));
             


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
             
            StringBuffer json = new StringBuffer(1024);
            String temp="";
            while((temp=reader.readLine())!=null)
                json.append(temp).append("\n");
            reader.close();
             
            JSONObject data = new JSONObject(json.toString());

            if(data.getInt("cod") != 200){
                return null;
            }
             
            return data;
        }catch(Exception e){
            return null;
        }
    }   
}