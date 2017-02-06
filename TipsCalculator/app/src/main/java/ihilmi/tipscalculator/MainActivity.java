package ihilmi.tipscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void hitung(View view) {

        EditText inputTagihan = (EditText) findViewById(R.id.inputTagihan);
        EditText inputPersenTip = (EditText) findViewById(R.id.inputPersenTip);
        EditText inputJml = (EditText) findViewById(R.id.inputJml);
        TextView result = (TextView) findViewById(R.id.result);

        double inp2 = 0, inp1 = 0, inp3 = 0;
        inp1 = Double.parseDouble(inputTagihan.getText().toString());
        inp2 = Double.parseDouble(inputPersenTip.getText().toString());
        inp3 = Double.parseDouble(inputJml.getText().toString());

        String hasil = "";
        hasil = "Tips : "+ (inp1*(inp2/100)+"\n");
        hasil+= "Total : "+ (inp1+(inp1*(inp2/100))+"\n");
        hasil+= "Per Orang : "+ ((inp1+(inp1*(inp2/100))/inp3)+"\n");

        result.setText(hasil);

    }
}
