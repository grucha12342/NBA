package com.example.misiek.nba;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class AsyncTeamDownload extends AsyncTask<String, Integer, ArrayList<Team>> {
    @Override
    protected ArrayList<Team> doInBackground(String... urls) {
        int count = urls.length;
        String json = "";
        FetchData test = new FetchData();
        ArrayList<Team> listOfTeams = new ArrayList<Team>();
        for (int i = 0; i < count; i++) {
            try {
                json = test.getInternetData(urls[i]);
                JSONObject obj = new JSONObject(json);
                JSONObject league = obj.getJSONObject("league");
                JSONArray teams = league.getJSONArray("standard");
                int len = teams.length();
                for(int j = 0; j < len; j++ ) {
                    JSONObject team = teams.getJSONObject(j);
                    Team t = new Team(team.getInt("teamId"), team.getString("city"), team.getString("nickname"), team.getString("confName"), team.getString("divName"));
                    listOfTeams.add(t);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            publishProgress((int) ((i / (float) count) * 100));
            // Escape early if cancel() is called
            if (isCancelled()) break;
        }
        return listOfTeams;
    }

    protected void onProgressUpdate(Integer... progress) {
        //System.out.println(progress);
    }

    protected void onPostExecute(String result) {
        System.out.println(result);
    }
}
