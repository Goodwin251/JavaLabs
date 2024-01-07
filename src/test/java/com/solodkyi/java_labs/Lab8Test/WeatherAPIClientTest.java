package com.solodkyi.java_labs.Lab8Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.junit.jupiter.api.Test;
public class WeatherAPIClientTest {
	@Test
	public void testCorrectURL() throws MalformedURLException, URISyntaxException {
		String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m";
		URL url = new URI(apiUrl).toURL();
		assertEquals(url.toString(), "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m");
	}
	@Test
	public void testInCorrectURL() {
		String apiUrl = "ps://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m";
		assertThrows(MalformedURLException.class, ()->{URL url = new URI(apiUrl).toURL();});
	}
	@Test
	public void testCorrectConnection() throws URISyntaxException, IOException {
		String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m";
		URL url = new URI(apiUrl).toURL();
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.disconnect();
	}
	@Test void testGetIOExceptionWhileConnect() throws IOException {
		URL url = mock(URL.class);
		when(url.openConnection()).thenThrow(new IOException("Mocked IOException"));
		assertThrows(IOException.class, ()->{HttpURLConnection connection = (HttpURLConnection) url.openConnection(); connection.disconnect();});
	}
	@Test void testCreateBufferReader() throws IOException, URISyntaxException {
		String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m";
		URL url = new URI(apiUrl).toURL();
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		assertTrue(reader.ready());
		reader.close();
	}
	
}
