package edu.temple.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class ImageActivity extends AppCompatActivity {


    Spinner spinner;
    ImageView image_view;
    int[] bean_res_id;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        image_view = findViewById(R.id.image_view);
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);

        String[] bean_array = new String[]{"Kidney Bean", "Black Bean", "Green Bean", "Mung Bean", "Pinto Bean"};
        bean_res_id = new int[]{R.drawable.bean,R.drawable.black_bean,R.drawable.green_bean,R.drawable.mung_bean,R.drawable.pinto};

        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bean_array);
        ImageAdapter adapter = new ImageAdapter(this, bean_array);


        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //showPicture(position);
                show_image(position);
                textView.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        }
    private void show_image(int position) {
        image_view.setImageResource(bean_res_id[position]);
    }

}
