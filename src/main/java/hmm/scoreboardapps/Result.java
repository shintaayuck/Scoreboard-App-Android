package hmm.scoreboardapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView txtHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtHasil = (TextView) findViewById(R.id.txt_hasil);

        Intent intent = getIntent();

        String content = intent.getStringExtra("hasilpertandingan");
        int x = 0;

        if (!content.equals("seri")) {
            txtHasil.setText("The Winner is " + content);
        } else {
            txtHasil.setText("Pertandingan Seri");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

