package ihilmi.java_class;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public String  showString;
    public TextView showText;
    public Barang [] arrBarang = new Barang[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText = (TextView) findViewById(R.id.show_text);

        showString = "Manipulasi Class Java Android";
        addSeparator();


        initBarang();
        showString += arrBarang[3].toString();
        addSeparator();
        showString += arrBarang[4].toString();
        showText.setText(showString);
    }

    public void addSeparator(){
        showString +="\n----------------------------------------\n";
    }

    public void initBarang(){
        arrBarang[0] = new Barang("LAPTOP",1,8000000);
        arrBarang[1] = new Barang("PRINTER",Barang.ELEKTRONIK,5000000);
        arrBarang[2] = new Barang("MONITOR",Barang.ELEKTRONIK,7000000);
        arrBarang[3] = new Barang("SCANNER",Barang.ELEKTRONIK,1000000);
        arrBarang[4] = new Barang("MEJA",Barang.NON_ELEKTRONIK,2000000);
        arrBarang[5] = new Barang("KURSI",Barang.NON_ELEKTRONIK,4000000);
        arrBarang[6] = new Barang("JENDELA",Barang.NON_ELEKTRONIK,4000000);
        arrBarang[7] = new Barang("HANDPHONE",Barang.ELEKTRONIK,2000000);
        arrBarang[8] = new Barang("SOFTCASE",Barang.NON_ELEKTRONIK,8000000);
        arrBarang[9] = new Barang("MOUSE",Barang.ELEKTRONIK,3000000);
    }

}
