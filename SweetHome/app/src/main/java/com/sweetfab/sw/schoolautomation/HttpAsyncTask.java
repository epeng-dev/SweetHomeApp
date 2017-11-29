package com.sweetfab.sw.schoolautomation;

import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by mskan on 2017-10-12.
 */

public class HttpAsyncTask extends AsyncTask<HttpContent, Void, Integer> {
	HttpContent httpContent;
	@Override
	protected Integer doInBackground(HttpContent... params) {
		httpContent = params[0];
		String urlStr = "https://1f02571c.ngrok.io/";
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
			String json = jsonMaker.getJsonData(httpContent.getCommand());
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
			Toast.makeText(httpContent.getActivity(), "잘못된 명령입니다.", Toast.LENGTH_SHORT).show();
		else if(integer == HttpsURLConnection.HTTP_NOT_FOUND){
			Toast.makeText(httpContent.getActivity(), "서버가 꺼져있습니다.", Toast.LENGTH_SHORT).show();
		}
	}
}
