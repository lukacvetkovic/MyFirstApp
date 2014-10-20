package com.example.cveki.myfirstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Cveki on 11.10.2014..
 */
public class Menu extends ListActivity{

    String classes[]= {"MyActivity","TextPlay","Email","Camera","Data","Example5","Example6"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese= classes[position];
        Class ourClass = null;
        try {
            ourClass = Class.forName("com.example.cveki.myfirstapp."+cheese);
            Intent ourIntent= new Intent(Menu.this,ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp= getMenuInflater();
        blowUp.inflate(R.menu.cool_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.aboutUs:
                Intent i= new Intent("com.example.cveki.ABOUT");
                startActivity(i);
                break;

            case R.id.preferences:
                Intent p=new Intent("com.example.cveki.PREFS");
                startActivity(p);

                break;

            case R.id.exit:
                finish();

                break;
        }
        return false;
    }
}
