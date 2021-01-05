package com.example.bottomnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipNavigationBar=findViewById(R.id.chipNavigation);

        chipNavigationBar.setItemSelected(R.id.home,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new Home()).commit();
 chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
     @Override
     public void onItemSelected(int i) {
         switch (i){
             case R.id.home:
                 fragment=new Home();
                 break;
             case R.id.search:
                 fragment=new Search();
                break;
             case R.id.profile:
                 fragment=new Profile();
                 break;
         }
         if (fragment!=null){
             getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
         }
     }
 });
    }
}