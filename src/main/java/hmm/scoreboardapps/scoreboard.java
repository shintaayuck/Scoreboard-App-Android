package hmm.scoreboardapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scoreboard extends AppCompatActivity {

    TextView namaTim1,
             namaTim2,
             scoreTim1,
             scoreTim2;
    Button btn2Point1,
           btn2Point2,
           btn3Point1,
           btn3Point2,
           btnFinish;

    int score1 = 0;
    int score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        //Inisialisasi
        namaTim1 = (TextView)findViewById(R.id.tim1);
        namaTim2 = (TextView)findViewById(R.id.tim2);
        scoreTim1 = (TextView)findViewById(R.id.score1);
        scoreTim2 = (TextView)findViewById(R.id.score2);
        btn2Point1 = (Button)findViewById(R.id.btn_2pt1);
        btn3Point1 = (Button)findViewById(R.id.btn_3pt1);
        btn2Point2 = (Button)findViewById(R.id.btn_2pt2);
        btn3Point2 = (Button)findViewById(R.id.btn_3pt2);
        btnFinish = (Button)findViewById(R.id.btn_finish);


        Intent intentPendapatan = getIntent();
        final String tim1 = intentPendapatan.getStringExtra("tim1");
        final String tim2 = intentPendapatan.getStringExtra("tim2");

        //setting nama tim
        namaTim1.setText(tim1);
        namaTim2.setText(tim2);

        //setting point tim 1
        btn2Point1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 += 2;
                scoreTim1.setText(String.valueOf(score1));
            }
        });
        btn3Point1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 += 3;
                scoreTim1.setText(String.valueOf(score1));
            }
        });

        //setting point tim 1
        btn2Point2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2 += 2;
                scoreTim2.setText(String.valueOf(score2));
            }
        });
        btn3Point2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2 += 3;
                scoreTim2.setText(String.valueOf(score2));
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hasil;
                if (score1 > score2) {
                    hasil = tim1;
                } else if (score2 < score1) {
                    hasil = tim2;
                } else {
                    hasil = "seri";
                }


                Intent intent = new Intent(getApplicationContext(), Result.class);
                intent.putExtra("hasilpertandingan", hasil);
                startActivity(intent);
                finish();
            }});


    }
}
