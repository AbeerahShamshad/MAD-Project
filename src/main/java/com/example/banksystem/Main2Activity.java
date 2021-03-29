package com.example.banksystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;

public class  Main2Activity extends AppCompatActivity
{
    private SharedPreferences preferences;
    private AppBarConfiguration mAppBarConfiguration;
    private TextView HTemail,HTname;
    private View hviwe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        preferences=getSharedPreferences(Constant.PREF_NAME,MODE_PRIVATE);



//        HTname.setText(us_obj.getName());
//        HTemail.setText(us_obj.getEmail());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setDisplayShowCustomEnabled(true);
//        getSupportActionBar().setCustomView(R.layout.nav_header_main2);
     //   View view = getSupportActionBar().getCustomView();
       //          toolbar = (Toolbar) view.getParent();
     //   toolbar.setContentInsetsAbsolute(0,0);

        Intent ink=getIntent();
        Customer us_obj= (Customer) ink.getSerializableExtra("Serail");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        hviwe=navigationView.getHeaderView(0);
        HTname=hviwe.findViewById(R.id.Hname);
        HTemail=hviwe.findViewById(R.id.Hemail);

        HTname.setText(us_obj.getName());
        HTemail.setText(us_obj.getEmail());
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
          int id=item.getItemId();

          if(id==R.id.action_Logout){
              Log_out();
              return false;
          }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private void Log_out() {
        SharedPreferences.Editor editor=preferences.edit();
        editor.clear();
        editor.commit();

        Intent ink =new Intent(this,MainActivity.class);
        ink.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ink);
        finish();
    }
}
