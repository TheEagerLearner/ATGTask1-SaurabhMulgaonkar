package com.example.atgtask1_saurabhmulgaonkar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.atgtask1_saurabhmulgaonkar.Fragment.Home;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout Frame;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    DrawerLayout Drawer;
    NavigationView sideBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Frame=findViewById(R.id.Frame);
        toolbar=findViewById(R.id.Tool);
        Drawer=findViewById(R.id.Drawer);
        sideBar=findViewById(R.id.sideBar);

        setSupportActionBar(toolbar);
        toggle= new ActionBarDrawerToggle(MainActivity.this,Drawer,R.string.Open,R.string.Close);

        Drawer.addDrawerListener(toggle);
        getSupportActionBar().setTitle("Task App");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.Frame, new Home()).commit();
        getSupportActionBar().setTitle("Home");

        sideBar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                Drawer.closeDrawers();

                switch(item.getItemId())
                {
                    case R.id.home: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.Frame, new Home()).commit();
                        getSupportActionBar().setTitle("Home");
                        break;
                    }
                    case R.id.settings: {//getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new Home()).commit();
                        Toast.makeText(MainActivity.this, "Settings tapped", Toast.LENGTH_SHORT).show();
                        getSupportActionBar().setTitle("Setting");
                        break;
                    }
                    case R.id.profile: {
                        //getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new Home()).commit();
                        Toast.makeText(MainActivity.this, "Profile tapped", Toast.LENGTH_SHORT).show();
                        getSupportActionBar().setTitle("Profile");
                        break;
                    }
                    case R.id.about: {
                        //getSupportFragmentManager().beginTransaction().replace(R.id.Frame,new About()).commit();
                        Toast.makeText(MainActivity.this, "About us tapped", Toast.LENGTH_SHORT).show();
                        getSupportActionBar().setTitle("About us");
                        break;
                    }


                }

                return true;
            }

        });

    }
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:

                Drawer.openDrawer(GravityCompat.START);

                return true;

        }



        return super.onOptionsItemSelected(item);

    }
}