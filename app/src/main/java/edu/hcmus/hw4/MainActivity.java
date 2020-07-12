package edu.hcmus.hw4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements ListView.OnItemClickListener {
    private TextView tvSelect;
    private List<PhoneInfo> phoneInfos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] names = {"Nguyen Van C", "Tran Van B", "Phan Van A"};
        String[] phones = {"0626300342", "0626300342", "0626300342"};
        Integer[] avatars = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};

        for (int i = 0; i < names.length; i++) {
            phoneInfos.add(new PhoneInfo(names[i], phones[i], avatars[i]));
        }
        ListView myList = (ListView) findViewById(R.id.myList);
        CustomAdapter adapter = new CustomAdapter(this, R.layout.custom_row_layout, phoneInfos);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvSelect = findViewById(R.id.tvSelect);
        tvSelect.setText("You choose: " + phoneInfos.get(position).getName());
    }
}