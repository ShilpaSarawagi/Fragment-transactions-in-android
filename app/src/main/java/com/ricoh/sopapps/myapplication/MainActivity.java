package com.ricoh.sopapps.myapplication;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    FragmentManager manager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addfragmentA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentA, "fragA");
        transaction.commit();
    }

    public void remfragmentA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentA != null){
            transaction.remove(fragmentA);
            transaction.commit();
        }
        else{
            Toast.makeText(getApplicationContext(), "Fragment A not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void addfragmentB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }

    public void remfragmentB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentB !=null){
            transaction.remove(fragmentB);
            transaction.commit();
        }
        else{
            Toast.makeText(getApplicationContext(), "Fragment B not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceByFragmentA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentA , "fragA");
        transaction.commit();
    }

    public void replaceByFragmentB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragmentB, "fragB");
        transaction.commit();
    }
}
