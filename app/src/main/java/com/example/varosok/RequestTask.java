/*package com.example.varosok;

import android.os.AsyncTask;
import android.os.TokenWatcher;
import android.widget.Toast;

import java.io.IOException;

public class RequestTask {
    String requestUrl;
    String requestType;
    String requestParams;

    public RequestTask(String requestUrl, String requestType, String requestParams) {
        this.requestUrl = requestUrl;
        this.requestType = requestType;
        this.requestParams = requestParams;
    }

    public RequestTask(String requestUrl, String requestType){
        this.requestUrl = requestUrl;
        this.requestType = requestType;
    }

    @Override
    protected Response doInBackground(Void... voids){
        Response response = null;
        try{
            switch (requestType){
                case "GET":
                    response = RequestHandler.get(requestUrl);
                    break;
                case "POST":
                    response = RequestHandler.post(requestUrl, requestParams);
                    break;
            }
        }catch (IOException e){
           // Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        return response;
    }

}
*/

