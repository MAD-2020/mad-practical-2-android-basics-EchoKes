package sg.edu.np.mad.whack_a_mole;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Whack-A-Mole";
    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */
    Button B1;
    Button B2;
    Button B3;
    TextView Score;
    int Count = 0;
    Button[] bList;
    String[] lrm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B1 = findViewById(R.id.b1);
        B2 = findViewById(R.id.b2);
        B3 = findViewById(R.id.b3);
        Score = findViewById(R.id.score);

        Log.d("#d", "Finished Pre-Initialisation!");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("#d", "started");
        bList = new Button[]{B1, B2, B3};
        lrm = new String[]{"Button Left Clicked!","Button Middle Clicked!","Button Right Clicked!"};
        setNewMole();
        Log.d("#d", "Starting GUI!");
        gameOn();
    }

    public void gameOn(){
        for (int b=0; b<bList.length; b++) {
            final int finalB = b;
            final int logB = b;
            bList[b].setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    Log.v(TAG, lrm[logB]);
                    if (bList[finalB].getText() == "*") {
                        Score.setText("" + (Count += 1));
                        Log.d("#d", "Hit, score added!");
                    } else {
                        Score.setText("" + (Count -=1));
                        Log.d("#d", "Missed, score deducted!");
                    }
                    setNewMole();
                }
            });
        }
    }

    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        for(int i = 0; i<3; i++){
            if(randomLocation == i){
                bList[i].setText("*");
            }
            else{
                bList[i].setText("O");
            }
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("#d", "stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("#d", "paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("#d", "destroyed");
    }
}

