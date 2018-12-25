package com.developer.prihann.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
           Boolean ans = new MyTestAsyncOne().execute(100).get();
            Log.d("nb","myResult : "+ans);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    private class MyTestAsyncOne extends AsyncTask<Integer, String, Boolean> {


        String myName;
        Boolean myStatus;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {
            if (integers[0] == 100) {
                myName = "prihan";
                myStatus= true;
            } else {
                myName = "nimsara";
                myStatus= true;
            }
            onProgressUpdate(myName);
            return myStatus;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Log.d("nb","onProgressUpdate : "+values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Log.d("nb","onPostExecute : "+aBoolean);
        }
    }

}
