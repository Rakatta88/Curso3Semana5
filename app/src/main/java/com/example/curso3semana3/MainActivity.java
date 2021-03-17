package com.example.curso3semana3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.curso3semana3.adapter.AdaptadorMascota;
import com.example.curso3semana3.adapter.PageAdapter;
import com.example.curso3semana3.fragment.Perfil;
import com.example.curso3semana3.fragment.RecyclerViewFragment;
import com.example.curso3semana3.pojo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ImageView ivFavorites;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("DEBUGGING", "MainActivity - onCreate");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        androidx.appcompat.widget.Toolbar myActionBar = (Toolbar) findViewById(R.id.myactionbar);
        setSupportActionBar(myActionBar);

        Log.i("DEBUGGING", "MainActivity - Before setting up ViewPager");

        setUpViewPager();

        Log.i("DEBUGGING", "MainActivity - After setting up ViewPager");


        //TODO investigat if this really is correct

        Log.i("DEBUGGING", "MainActivity - Before the Action Toolbar check");

        if (toolbar !=null){
            setSupportActionBar(toolbar);
        }

        Log.i("DEBUGGING", "MainActivity - After the Action Toolbar check");


        ivFavorites = findViewById(R.id.ivFavorites);
        ivFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Top5.class);
                startActivity(i);
            }
        });
        Log.i("DEBUGGING", "MainActivity - After setting onclicklistener");

    }

    private ArrayList<Fragment> agregarFragments(){
        Log.i("DEBUGGING", "MainActivity - Before executing agregarFragments");

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new Perfil());
        Log.i("DEBUGGING", "MainActivity - Before returning fragments");

        return fragments;
    }

    private void setUpViewPager(){

        Log.i("DEBUGGING", "MainActivity - start setUpViewPager");

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Log.i("DEBUGGING", "MainActivity - OptionsMenu");

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.i("DEBUGGING", "MainActivity - OnitemsSelected in options menu");

        switch (item.getItemId()) {
            case R.id.mContacto:

                Intent i = new Intent(MainActivity.this, ContactForm.class);
                startActivity(i);
                break;

            case R.id.mAcercaDe:

                Intent it = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(it);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}