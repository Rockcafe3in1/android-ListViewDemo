
/*
 * Copyright (C) 2014 Sony Mobile Communications AB.
 * All rights, including trade secret rights, reserved.
 */

package androidemo.liang.com.android_listviewdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class ListViewDemo extends ListActivity {

    private static final String[] items = {"Washington", "Oregon", "California",
            "Nevada", "Idaho", "Montana", "Utah", "Arizona", "New Mexico", "Texas",
            "North Dakota", "South Dakota", "Nebraska", "kansas", "Oklahoma", "Minnesota",
            "Lowa", "Missouri", "Arkansas", "Louisiana", "Mississippi", "Tennessee",
            "Indiana", "Wisconsin", "Michigan", "Kentucky", "Alabama", "Georgia",
            "South Carolina", "Florida", "North Carolina", "Virginia", "Ohio",
            "West Virginia", "New York"};
    private TextView selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        selection = (TextView) findViewById(R.id.body_header);

        // Practice simple list 1
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items));

        // Practice simple list 2
        // Error: TwoLineListItem cannot be cast to TextView
/*        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_2, items));*/

        // Set choice mode of list view into multiple mode
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, items));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        selection.setText(items[position]);
        super.onListItemClick(l, v, position, id);
    }
}
