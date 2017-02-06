package ihilmi.multifunctionapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SendEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
    }

    public void sendEmail(View view){
        EditText txtPenerima = (EditText) findViewById(R.id.penerima);
        EditText txtjudul = (EditText) findViewById(R.id.judul);
        EditText txtisi = (EditText) findViewById(R.id.isipesan);

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"+txtPenerima.getText().toString()));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "1hilmi657@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, txtjudul.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, txtisi.getText().toString());

        try{
            startActivity(Intent.createChooser(emailIntent, "Send Email....."));
            finish();
        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(SendEmail.this,
                    "There is no email client installed", Toast.LENGTH_SHORT).show();
        }
        startActivity(emailIntent);
    }
}
