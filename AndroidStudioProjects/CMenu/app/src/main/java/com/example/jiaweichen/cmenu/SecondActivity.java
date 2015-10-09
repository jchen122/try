package com.example.jiaweichen.cmenu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONException;

import org.json.JSONArray;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {

    Button json;
    TextView secondTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        json=(Button)findViewById(R.id.second_button);
        secondTextView= (TextView) findViewById(R.id.second_text_view);

        final String strJson = "{'Android' :[{'song_name':'Gimme Dat'," +
                "'song_id':'1932','artist_name':'Sidney Samson (Feat. Pitbull & Akon)'},{'song_name':'F-k The Money (Remix)'," +
                " 'song_id':'73', 'artist_name':'B.o.B. (Feat. Wiz Khalifa)'}] }";

        String dataToBeParsed = "Click on button to parse JSON.\n\n JSON DATA : \n\n"+strJson;
        secondTextView.setText(dataToBeParsed);

        /******** Listener for button click ********/
        json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String OutputData = "";
                JSONObject jsonResponse;

                try {

                    /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
                    jsonResponse = new JSONObject(strJson);

                    /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
                    /*******  Returns null otherwise.  *******/
                    JSONArray jsonMainNode = jsonResponse.optJSONArray("Android");

                    /*********** Process each JSON Node ************/

                    int lengthJsonArr = jsonMainNode.length();

                    for (int i = 0; i < lengthJsonArr; i++) {
                        /****** Get Object for each JSON node.***********/
                        JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                        /******* Fetch node values **********/
                        int song_id = Integer.parseInt(jsonChildNode.optString("song_id").toString());
                        String song_name = jsonChildNode.optString("song_name").toString();
                        String artist_name = jsonChildNode.optString("artist_name").toString();


                        OutputData += "Node : \n\n     " + song_id + " | "
                                + song_name + " | "
                                + artist_name + " \n\n ";
                        //Log.i("JSON parse", song_name);
                    }

                    /************ Show Output on screen/activity **********/

                    secondTextView.setText(OutputData);

                } catch (JSONException e) {

                    e.printStackTrace();

                }
             }});






                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();




            }
        });
    }

}
