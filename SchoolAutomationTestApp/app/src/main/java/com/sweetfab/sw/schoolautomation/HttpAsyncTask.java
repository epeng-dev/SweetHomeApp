package com.sweetfab.sw.schoolautomation;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by mskan on 2017-10-12.
 */

public class HttpAsyncTask extends AsyncTask<ContextBox, Void, Integer> {
	ContextBox contextBox;
	@Override
	protected Integer doInBackground(ContextBox... params) {
		contextBox = params[0];
		String urlStr = "https://3230acc9.ngrok.io/";
		URL url = null;
		try {
			url = new URL(urlStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		try {
			HttpsURLConnection httpsURLConnection = (HttpsURLConnection)url.openConnection();
			httpsURLConnection.setRequestMethod("POST");
			httpsURLConnection.setRequestProperty("Content-Type", "application/json");
			httpsURLConnection.setDoInput(true);
			httpsURLConnection.setDoOutput(true);

			JsonMaker jsonMaker = new JsonMaker();
			String json = jsonMaker.getJsonData(contextBox.getCommand());
			OutputStream outputStream = httpsURLConnection.getOutputStream();
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			bufferedWriter.write(json);
			bufferedWriter.flush();
			bufferedWriter.close();
			outputStream.close();

			return httpsURLConnection.getResponseCode();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(Integer integer) {
		if(integer == HttpsURLConnection.HTTP_INTERNAL_ERROR)
			Toast.makeText(contextBox.getContext(), "잘못된 명령입니다.", Toast.LENGTH_SHORT).show();
		else if(integer == HttpsURLConnection.HTTP_NOT_FOUND){
			Toast.makeText(contextBox.getContext(), "서버가 꺼져있습니다.", Toast.LENGTH_SHORT).show();
		}
	}
}
