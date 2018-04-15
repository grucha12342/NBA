package com.example.misiek.nba;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.teamListView);
        DateHandler testDate = new DateHandler();
        try {
            ArrayList<Team> listOfTeams = new AsyncTeamDownload().execute("http://data.nba.net/data/10s/prod/v1/2017/teams.json").get();
            ArrayList<Match> listOfMatches = new AsyncMatchDownload().execute("http://data.nba.net/data/10s/prod/v1/"+ testDate.parseToString() +"/scoreboard.json").get();
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, testDate.parseToString(), duration);
            toast.show();
            System.out.println("Team list size: " + listOfTeams.size());
            System.out.println("Match list size: " + listOfMatches.size() + "Phila score: " + listOfMatches.get(2).awayTeamScore);

            MyAdapter testAdapter = new MyAdapter(this, listOfMatches);
            listView.setAdapter(testAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this, MatchDetails.class);
                    intent.putExtra("PositionOnList", position);
                    startActivity(intent);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //String url = "http://data.nba.net/data/10s/prod/v1/20180411/scoreboard.json";
    }
}
