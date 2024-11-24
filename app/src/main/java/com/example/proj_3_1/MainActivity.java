package com.example.proj_3_1;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
        int[] images = {
                R.drawable.lion,
                R.drawable.tiger,
                R.drawable.monkey,
                R.drawable.dog,
                R.drawable.cat,
                R.drawable.elephant
        };

        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", names[i]);
            item.put("image", images[i]);
            data.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                R.layout.list_item,
                new String[]{"name", "image"},
                new int[]{R.id.item_text, R.id.item_image}
        );

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener((AdapterView<?> parent, android.view.View view, int position, long id) -> {
            String selectedItem = names[position];
            Toast.makeText(MainActivity.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
        });
    }
}
