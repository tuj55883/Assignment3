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

public class ImageActivity extends AppCompatActivity {

    ListView list_view;
    Spinner spinner;
    ImageView image_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view = findViewById(R.id.list_view);
        image_view = findViewById(R.id.image_view);
        spinner = findViewById(R.id.spinner);

        String[] bean_array = new String[]{"Kidney Bean", "Black Bean", "Green Bean", "Mung Bean", "Pinto Bean"};
        int[] bean_res_id = new int[]{R.drawable.bean,R.drawable.black_bean,R.drawable.green_bean,R.drawable.mung_bean,R.drawable.pinto};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bean_array);

        list_view.setAdapter(adapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //showPicture(position);
                image_view.setImageResource(bean_res_id[position]);
            }
        });

    }
}