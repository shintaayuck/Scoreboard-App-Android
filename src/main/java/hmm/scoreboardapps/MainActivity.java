package hmm.scoreboardapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText timSatu;
    EditText timDua;
    Button goButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Input Tim"); //judul di atas program
        getSupportActionBar().setDisplayHomeAsUpEnabled(false); //tanyain nanti ini buat apa

        timSatu = findViewById(R.id.edit_tim_1);
        timDua = findViewById(R.id.edit_tim_2);
        goButton = findViewById(R.id.go_button);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(timSatu.getText()) || TextUtils.isEmpty(timDua.getText())) {
                    Toast.makeText(getApplicationContext(), "Nama tim belum terisi", Toast.LENGTH_SHORT).show();
                } else {
                    String tim1 = timSatu.getText().toString();
                    String tim2 = timDua.getText().toString();

                    Intent intent = new Intent(getApplicationContext(), scoreboard.class);
                    intent.putExtra("tim1", tim1);
                    intent.putExtra("tim2", tim2);

                    startActivity(intent);

                    timSatu.setText("");
                    timDua.setText("");
                }
            }
        });

    }
}
