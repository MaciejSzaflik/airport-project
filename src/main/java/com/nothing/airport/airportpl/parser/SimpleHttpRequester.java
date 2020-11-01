package com.nothing.airport.airportpl.parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import com.nothing.airport.airportpl.Airport;

public class SimpleHttpRequester implements AirportRequester {

  @Override
  public String getDepartures(Airport airport) {
    return getFromUrl(airport.getDeparturesUrl());
  }

  @Override
  public String getArrivals(Airport airport) {
    return getFromUrl(airport.getArrivalsUrl());
  }

  private String getFromUrl(String string){
    String result = "";

    try {
      URL url = new URL(string);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      
      int status = con.getResponseCode();
	 
      InputStream input = null;

      if (status > 299) {
        input = con.getErrorStream();
      } else {
        input = con.getInputStream();
      }

      Scanner s = new Scanner(input).useDelimiter("\\A");
      result = s.hasNext() ? s.next() : "";
      s.close();

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (ProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

	  return result;
  }
  
}
