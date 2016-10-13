package ca.uwaterloo.maptest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;


public class DisplayActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display);
        String strTitle="Go ENG Girl";
        String strDes="Explore the exciting field of engineering! Go ENG Girl is an exciting opportunity for Grade 7 - 10 girls to visit the University of Waterloo and learn about the wonderful world of engineering. Meet women currently studying engineering, learn about some of the amazing things women engineers are doing, and participate in a cool hands-on activity.";
        String strDate="2016-10-06";
        String strLoc="David Center";
        //set title and description!
        TextView title = (TextView) findViewById(R.id.title);
        TextView des = (TextView) findViewById(R.id.des);
        title.setText(strTitle);
        des.setText(strDes);

        //set date and location
        ListView list = (ListView) findViewById(R.id.MyListView);
        //生成动态数组，并且转载数据
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map_date = new HashMap<String, String>();
        map_date.put("ItemTitle", "Date");
        map_date.put("ItemText", strDate);
        mylist.add(map_date);
        HashMap<String, String> map_location = new HashMap<String, String>();
        map_location.put("ItemTitle", "Location");
        map_location.put("ItemText", strLoc);
        mylist.add(map_location);

        //生成适配器，数组===》ListItem
        SimpleAdapter mSchedule = new SimpleAdapter(this, //没什么解释
                mylist,//数据来源
                R.layout.listview,//ListItem的XML实现

                //动态数组与ListItem对应的子项
                new String[] {"ItemTitle", "ItemText"},

                //ListItem的XML文件里面的两个TextView ID
                new int[] {R.id.ItemTitle,R.id.ItemText});
        //添加并且显示
        list.setAdapter(mSchedule);

        //set toolbar
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_1);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/


    }
}

