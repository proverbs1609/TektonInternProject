package com.app.hamang.tektonproject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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

public class SpeciesMypage extends AppCompatActivity {
    private static String SPEC = "php_SpeciesMypage";

    private static final String SPEC_JSON = "feature";
    private static final String SPEC_DOGTIONARYID = "DOGTIONARYID";
    private static final String SPEC_DOGSPECIES = "DogSpecies";
    private static final String SPEC_COUNTRYNAME = "CountryName";
    private static final String SPEC_DOGAGE = "DogAge";
    private static final String SPEC_DOGWEIGHT = "DogWeight";
    private static final String SPEC_DOGSIZE = "DogSize";
    private static final String SPEC_DOGHAIR = "DogHair";
    private static final String SPEC_DOGFEATURE = "DogFeature";
    private static final String SPEC_DOGDISEASE = "DogDisease";
    private static final String SPEC_DOGTIP = "DogTip";

    ArrayList<HashMap<String, String>> SpecArrayList;
    ListView SpeclistView;
    String SpecJsonString;
    String kk="값 넘겨받기";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_species_mypage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SpeclistView = (ListView) findViewById(R.id.featureListView);
        SpecArrayList = new ArrayList<>();

        GetData notice = new GetData();
        notice.execute("http://13.125.96.121/DogFeature.php");
    }

    private class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(SpeciesMypage.this,
                    kk+"의 특징은요..",null, true, true);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            if (result != null) {//결과값이 없으면 오류
                SpecJsonString = result;
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
                int flight = httpURLConnection.getResponseCode();

                InputStream inputStream;
                if(flight == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = bufferedReader.readLine())!=null) {
                    sb.append(line);
                }
                bufferedReader.close();
                return sb.toString().trim();
            } catch (Exception e) {
                errorString = e.toString();
                return null;
            }
        }
    }

    private void showResult() {
        try{
            JSONObject jsonObject = new JSONObject(SpecJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(SPEC_JSON);

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);
//                String id = item.getString(SPEC_DOGTIONARYID);
//                String spec = item.getString(SPEC_DOGSPECIES);
                String country = item.getString(SPEC_COUNTRYNAME);
                String age = item.getString(SPEC_DOGAGE);
                String weight = item.getString(SPEC_DOGWEIGHT);
                String size = item.getString(SPEC_DOGSIZE);
                String hair = item.getString(SPEC_DOGHAIR);
                String feature = item.getString(SPEC_DOGFEATURE);
                String disease = item.getString(SPEC_DOGDISEASE);
                String tip = item.getString(SPEC_DOGTIP);
                HashMap<String,String> hashMap = new HashMap<>();
//                hashMap.put(SPEC_DOGTIONARYID, id);
//                hashMap.put(SPEC_DOGSPECIES, spec);// 메인 위에 표시
                hashMap.put(SPEC_COUNTRYNAME, country);
                hashMap.put(SPEC_DOGAGE, age);
                hashMap.put(SPEC_DOGWEIGHT, weight);
                hashMap.put(SPEC_DOGSIZE, size);
                hashMap.put(SPEC_DOGHAIR, hair);
                hashMap.put(SPEC_DOGFEATURE, feature);
                hashMap.put(SPEC_DOGDISEASE, disease);
                hashMap.put(SPEC_DOGTIP, tip);
                SpecArrayList.add(hashMap);
            }
            ListAdapter adapter = new SimpleAdapter(
                    SpeciesMypage.this, SpecArrayList, R.layout.species_feature,
                    new String[]{SPEC_COUNTRYNAME,SPEC_DOGAGE,SPEC_DOGWEIGHT,SPEC_DOGSIZE,
                            SPEC_DOGHAIR,SPEC_DOGFEATURE,SPEC_DOGDISEASE,SPEC_DOGTIP},
                    new int[]{R.id.country_name, R.id.dog_age, R.id.dog_weight, R.id.dog_size,
                            R.id.dog_hair, R.id.dog_feature, R.id.dog_disease, R.id.dog_tip}
            );
            SpeclistView.setAdapter(adapter);
        } catch (JSONException e) {
            Log.d(SPEC, "showResuult : ", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_emotion_mypage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_close) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
