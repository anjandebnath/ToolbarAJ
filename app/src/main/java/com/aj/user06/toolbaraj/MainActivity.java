package com.aj.user06.toolbaraj;

import android.content.res.Configuration;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout drawerLayout;
    ListView mDrawerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Hamburger icon on toolbar with DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (getSupportActionBar() != null)
        {
            // These lines are needed to display the top-left hamburger button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name)
            {

                public void onDrawerClosed(View view)
                {
                    //supportInvalidateOptionsMenu();
                    //drawerOpened = false;
                }

                public void onDrawerOpened(View drawerView)
                {
                    //supportInvalidateOptionsMenu();
                    //drawerOpened = true;
                }
            };
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            drawerLayout.setDrawerListener(mDrawerToggle);
            mDrawerToggle.syncState();

            // Change the TextView message when ListView item is clicked
            mDrawerListView = (ListView) findViewById(R.id.left_drawer);
            mDrawerListView.setOnItemClickListener(new ListView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
            });
        }




        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Display back button in the toolbar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Display icon in the toolbar
//        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){

        }

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
