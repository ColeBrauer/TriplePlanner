package ui;


import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.*;


    public class ReadWebPageEx{

        public static void GetWeather() throws MalformedURLException, IOException {

            BufferedReader br = null;

            try {
                String apikey = "be77c0b462775e923cd6b895440f9a0f"; //fill this in with the API key they email you
                String weatherquery = "https://api.openweathermap.org/data/2.5/weather?q=vancouver,ca&APPID=";
                String theURL=weatherquery+apikey;
                //String theURL = ""; //this can point to any URL
                URL url = new URL(theURL);
                br = new BufferedReader(new InputStreamReader(url.openStream()));

                String line;

                StringBuilder sb = new StringBuilder();

                while ((line = br.readLine()) != null) {

                    sb.append(line);
                    sb.append(System.lineSeparator());

                }
            //   JSONObject obj = new JSONObject(br);
//                JSONArray weather = obj.getJSONArray("weather");
//
//
//                System.out.println(weather);
                System.out.println(sb);

            } finally {

                if (br != null) {
                    br.close();
                }

            }

        }
    }
