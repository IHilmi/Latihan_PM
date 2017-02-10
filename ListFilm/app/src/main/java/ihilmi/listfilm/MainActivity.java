package ihilmi.listfilm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private String [] filmTitles = {"The Thor","Harry Potter","Inception",
//                                    "Will of Wallstreet", "Django Unchained",
//                                    "Titanic","Captain America","Doctor Strange",
//                                    "X-Men Apocalypse", "Shutter Island",
//                                    "The Avenger", "Fantastic Beast & Where To Find Them"};

    private ArrayList<Movie> movies = new ArrayList<>();
    ArrayAdapter<Movie> adapter;
    ListView listView;

    private void initMovies(){
        movies.add(new Movie("Titanic", "Film bergenre romance tentang kapal yang tenggelam", 8.0, 2010));
        movies.add(new Movie("Captain America", "Film bergenre Action tentang perjuangan seseorang dalam melawan penjajahan", 7.0, 2012));
        movies.add(new Movie("Fifty Shade Of Grey", "Film bergenre romance tentang keinginan yang tidak dapat di tahan", 8.0, 2015));
        movies.add(new Movie("Mama", "Film bergenre Horror tentang kasih ibu kepada beta tak terhingga sepanjang masa", 9.9, 2016));
        movies.add(new Movie("Frozen", "Film bergenre romance tentang putri kerajaan yang punya kemampuan membuat snowman", 8.0, 2015));
        movies.add(new Movie("Final Destination 5", "Film bergenre Sadism tentang penglihatan masa depan.", 6.0, 2015));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initMovies();
        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this,
                android.R.layout.simple_list_item_1, movies);
        ListView listView = (ListView) findViewById(R.id.listFilm);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener (new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView <?> parent, View view, int position, long id){
//                String item = ((TextView)view).getText().toString();
//                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();
                Movie selectedMovie = movies.get(position);
                Intent intent = new Intent(getBaseContext(), Detail_Activity.class);
                intent.putExtra("ihilmi.listfilm", selectedMovie);
                startActivity(intent);
            }
        });
    }

    public void formAdd (View view){
        Intent intent = new Intent(this, TambahFilm.class);
        startActivityForResult(intent , 1);
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                Movie newMovie = (Movie) data.getSerializableExtra("ihilmi.listfilm");
                movies.add(newMovie);
                adapter.notifyDataSetChanged();
            }

        }
    }


}
