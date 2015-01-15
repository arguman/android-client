package org.arguman.app.internal_libraries;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class APIFetch {

	private static String   URL
                           ,cat
                           ,where;

	public APIFetch(String URL, String cat, String where) {
		APIFetch.URL = URL;
		APIFetch.cat = cat;
		APIFetch.where = where;
		new RestClient().execute(APIFetch.URL);
	}

	public APIFetch(String cat, String where) {
		APIFetch.URL = "http://api.arguman.org/";
		APIFetch.cat = cat;
		APIFetch.where = where;
		APIFetch.URL += cat;
		new RestClient().execute(APIFetch.URL);
	}
	
	public interface RestClientResponse {
		void processFinished(String output);
	}
	
	public static String GET(String url) {
		InputStream mInputStream = null;
		String result = "";
		try {
			HttpClient mHttpClient = new DefaultHttpClient();
			HttpResponse mHttpResponse = mHttpClient.execute(new HttpGet(url));
			mInputStream = mHttpResponse.getEntity().getContent();
			if (mInputStream != null) {
				result = convertInputStreamToString(mInputStream);
			} else {
				result = "ERROR!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static String convertInputStreamToString(InputStream inputStream) throws IOException {
		BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String  line    = ""
               ,result  = "";
		while ((line = mBufferedReader.readLine()) != null) {
			result += line;
		}
		inputStream.close();
		return result;
	}
	
	public static class RestClient extends AsyncTask<String, Void, String> {
		public RestClientResponse delegate;
		@Override
		protected String doInBackground(String... urls) {
			return GET(urls[0]);
		}
		@Override
		protected void onPostExecute(String results) {
			// TODO
		}
	}
	
}
