package com.example.misiek.nba;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class AsyncMatchDownload extends AsyncTask<String, Integer, ArrayList<Match>> {
    @Override
    protected ArrayList<Match> doInBackground(String... urls) {
        int count = urls.length;
        String json = "";
        FetchData test = new FetchData();
        ArrayList<Match> listOfMatches = new ArrayList<Match>();
        for (int i = 0; i < count; i++) {
            try {
                json = test.getInternetData(urls[i]);
                JSONObject obj = new JSONObject(json);
                JSONArray games = obj.getJSONArray("games");
                //JSONArray teams = league.getJSONArray("standard");
                int len = games.length();
                for(int j = 0; j < len; j++ ) {
                    JSONObject match = games.getJSONObject(j);
                    int gameId = match.getInt("gameId");
                    JSONObject vTeam = match.getJSONObject("vTeam");
                    int awayTeamId = vTeam.getInt("teamId");
                    int awayTeamScore = vTeam.getInt("score");
                    String awayTeamTriCode = vTeam.getString("triCode");
                    JSONObject hTeam = match.getJSONObject("hTeam");
                    int homeTeamId = hTeam.getInt("teamId");
                    int homeTeamScore = hTeam.getInt("score");
                    String homeTeamTriCode = hTeam.getString("triCode");
                    Match t = new Match(gameId, homeTeamId, homeTeamScore, homeTeamTriCode,awayTeamId, awayTeamScore, awayTeamTriCode);
                    listOfMatches.add(t);
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
        return listOfMatches;
    }

    protected void onProgressUpdate(Integer... progress) {
        //System.out.println(progress);
    }

    protected void onPostExecute(String result) {
        System.out.println(result);
    }
}
