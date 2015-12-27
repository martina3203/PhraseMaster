package com.example.aaron.phrasemaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import SQLPhraseRetrieval.*;

public class GameActivity extends AppCompatActivity {

    private PhraseRetriever phraseMachine;
    private Button testButton;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        testButton = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.textView);

        //Setup Database
        phraseMachine = new PhraseRetriever(getApplicationContext());
        phraseMachine.openDatabase();
        phraseMachine.addPhrase("Stuff", "Hey!");
        phraseMachine.addPhrase("Stuff","You!");
    }

    public void changePhrase(View view)
    {
        String newPhrase = "DEFAULT";
        newPhrase = phraseMachine.returnRandomPhrase("Stuff");
        text.setText(newPhrase);
    }
}
