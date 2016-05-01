package com.artboard.speranza.artboard;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    MenuItem menuitem;
    Stack<MenuItem> menustack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        menustack = new Stack<MenuItem>();
        final FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
//            @Override
//            public void onBackStackChanged() {
//                int backCount = getSupportFragmentManager().getBackStackEntryCount();
//                Log.e("fragmentstack",String.valueOf(backCount));
//                Log.e("menustack",String.valueOf(menustack.size()));
//                if(backCount == 0){
//                    //Log.e("ddd",fragmentManager.getBackStackEntryAt(backCount-1).getName());
//                    Menu menu = (Menu)findViewById(R.id.menu);
//                    menustack.pop().setChecked(false);
//                    menu.findItem(R.id.home_screen).setChecked(true);
//                }else{
//                    if((menustack.size() - backCount) > 0) {
//                        menustack.pop();
//                    }
//                }
//                Log.e("fragmentstack",String.valueOf(backCount));
//                Log.e("menustack",String.valueOf(menustack.size()));
//
//            }
//        });
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame, new tab_home_screenFragment(),getResources().getString(R.string.home_screen));
        fragmentTransaction.commit();





    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        String tag = null;

        if (id == R.id.home_screen) {
            fragment = new tab_home_screenFragment();

        } else if (id == R.id.baby_shop) {
            //fragment = new twoFragment();

        } else if (id == R.id.my_purse) {

        } else if (id == R.id.record) {
            fragment = new RecordFragment();

        } else if (id == R.id.discussion){

        } else if (id == R.id.QR_code) {

        } else if (id == R.id.babysitter) {

        }

        if(fragment != null) {
            tag = item.toString();
            menustack.push(item);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_frame, fragment,tag);
            fragmentTransaction.addToBackStack(tag);
            fragmentTransaction.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);



        return true;
    }

    public void click(View v){
        Toast.makeText(this,"feed milk",Toast.LENGTH_SHORT).show();
    }
}
