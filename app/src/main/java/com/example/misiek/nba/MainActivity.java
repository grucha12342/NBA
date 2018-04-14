package com.example.misiek.nba;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listToAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.teamListView);
        listToAdapter = new ArrayList<String>();

        try {
            ArrayList<Team> listOfTeams = new AsyncTeamDownload().execute("http://data.nba.net/data/10s/prod/v1/2017/teams.json").get();
            ArrayList<Match> listOfMatches = new AsyncMatchDownload().execute("http://data.nba.net/data/10s/prod/v1/20180410/scoreboard.json").get();
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, listOfTeams.get(0).city, duration);
            toast.show();
            System.out.println("Team list size: " + listOfTeams.size());
            System.out.println("Match list size: " + listOfMatches.size() + "Phila score: " + listOfMatches.get(2).awayTeamScore);
            for (int counter = 0; counter < listOfTeams.size(); counter++) {
                listToAdapter.add(listOfTeams.get(counter).nickname);
            }
            MyAdapter testAdapter = new MyAdapter(this, listOfMatches);

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listToAdapter );
            listView.setAdapter(testAdapter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //String url = "http://data.nba.net/data/10s/prod/v1/20180411/scoreboard.json";

    }
}
