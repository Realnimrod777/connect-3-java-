package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int player=0;
    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean check=true;
    @SuppressLint("SetTextI18n")
    public void dropping(View view)
    {
        //boolean check
        ImageView counter=(ImageView) view;
        counter.setTranslationY(-1500);
        int tappedcounter = Integer.parseInt(counter.getTag().toString());
        if(gamestate[tappedcounter]==2&& check==true) {
            gamestate[tappedcounter] = player;
            if (player == 0) {
                counter.setImageResource(R.drawable.yellow);

                player = 1;
            } else {
                counter.setImageResource(R.drawable.red);

                player = 0;

            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(1000);
            for (int[] winn : win) {
                if (gamestate[winn[0]] == gamestate[winn[1]] && gamestate[winn[1]] == gamestate[winn[2]] && gamestate[winn[0]] != 2) {
                    //won
                    check=false;
                    String str = "";
                    if (player == 1) {
                        str = "yellow";
                    } else {
                        str = "red";

                    }



                    Button playagain=(Button) findViewById(R.id.playagain);
                    TextView textView=(TextView) findViewById(R.id.textView);
                    playagain.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText(str+" "+"has won");
                }

            }
        }
    }
    public void playagain(View view){
        Button playagain=(Button) findViewById(R.id.playagain);
        TextView textView=(TextView) findViewById(R.id.textView);
        playagain.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        androidx.gridlayout.widget.GridLayout GridLay = findViewById(R.id.GridLay);
        for(int i = 0; i <GridLay.getChildCount(); i++) {
            ImageView counter = (ImageView)GridLay.getChildAt(i);
            counter.setImageDrawable(null);
        }
        for(int i=0;i<9;i++){
            gamestate[i]=2;
        }
      player=0;
        check=true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}