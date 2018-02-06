package com.app.hamang.tektonproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class InfoActivity extends AppCompatActivity {

    private static String INFO = "php_InfoActivity";

    private static final String INFO_JSON = "notice";
    private static final String INFO_NOTICECONTENT = "noticeContent";
    private static final String INFO_NOTICENAME = "noticeName";
    private static final String INFO_NOTICEDATE = "noticeDate";

    ArrayList<HashMap<String, String>> InfoArrayList;
    ListView InfolistView;
    String InfoJsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button buttonshop1 = (Button) findViewById(R.id.online_shop1);
        buttonshop1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "연결 중입니다. 잠시만 기다려주세요.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dogskingdom.co.kr/shop/main/index.php")));
            }
        });

        Button buttonshop2 = (Button) findViewById(R.id.online_shop2);
        buttonshop2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "연결 중입니다. 잠시만 기다려주세요.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.petsbe.com/shop/main/index.php")));
            }
        });

        Button buttonshop3 = (Button) findViewById(R.id.online_shop3);
        buttonshop3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "연결 중입니다. 잠시만 기다려주세요.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dogpia.net/")));
            }
        });

        Button buttonshop4 = (Button) findViewById(R.id.online_shop4);
        buttonshop4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "연결 중입니다. 잠시만 기다려주세요.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.koreapet.co.kr/")));
            }
        });

        InfolistView = (ListView) findViewById(R.id.noticeListView);
        InfoArrayList = new ArrayList<> ();

        GetData info = new GetData();
        info.execute("http://13.125.96.121/NoticeList.php");
    }

    private class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(InfoActivity.this,
                    "공지사항 업데이트중...", null, true, true);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            Log.d(INFO, "response  - " + result);
            if (result != null){
                InfoJsonString = result;
                showResult();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            String serverURL = params[0];
            try {
                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(INFO, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }
                bufferedReader.close();
                return sb.toString().trim();
            } catch (Exception e) {
                Log.d(INFO, "InsertData: Error ", e);
                errorString = e.toString();
                return null;
            }
        }
    }

    private void showResult(){
        try {
            JSONObject jsonObject = new JSONObject(InfoJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(INFO_JSON);

            for(int i=0;i<jsonArray.length();i++){
                JSONObject item = jsonArray.getJSONObject(i);
                String content = item.getString(INFO_NOTICECONTENT);
                String name = item.getString(INFO_NOTICENAME);
                String date = item.getString(INFO_NOTICEDATE);
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(INFO_NOTICECONTENT, content);
                hashMap.put(INFO_NOTICENAME, name);
                hashMap.put(INFO_NOTICEDATE, date);
                InfoArrayList.add(hashMap);
            }
            ListAdapter adapter = new SimpleAdapter(
                    InfoActivity.this, InfoArrayList, R.layout.info_notice,
                    new String[]{INFO_NOTICECONTENT, INFO_NOTICENAME, INFO_NOTICEDATE},
                    new int[]{R.id.noticeText, R.id.nameText, R.id.dateText}
            );
            InfolistView.setAdapter(adapter);
        } catch (JSONException e) {
            Log.d(INFO, "showResult : ", e);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}