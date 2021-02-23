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

    //Initializes the views we will use
    Spinner spinner;
    ImageView image_view;
    int[] bean_res_id;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets the views to their ids
        image_view = findViewById(R.id.image_view);
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);

        //Makes the array of beans we use and the other array are the images
        String[] bean_array = new String[]{"Please Pick A Bean","Kidney Bean", "Black Bean", "Green Bean", "Mung Bean", "Pinto Bean"};
        bean_res_id = new int[]{R.drawable.empty,R.drawable.bean,R.drawable.black_bean,R.drawable.green_bean,R.drawable.mung_bean,R.drawable.pinto};

        //Uses custom image adapter class
        ImageAdapter adapter = new ImageAdapter(this, bean_array,bean_res_id);

        //Sets our spinner to our adapter
        spinner.setAdapter(adapter);


        //When item is selected it sets the name and picture to said item
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                show_image(position);
                if(position>0) {//Makes sure something is selected
                    textView.setText(parent.getItemAtPosition(position).toString());
                } else {
                    textView.setText(" ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        }
     //Quick function to set image
    private void show_image(int position) {
        image_view.setImageResource(bean_res_id[position]);
    }

}
