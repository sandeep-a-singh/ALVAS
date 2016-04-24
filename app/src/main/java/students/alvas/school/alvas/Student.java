package students.alvas.school.alvas;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Student extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);
        FragmentManager fragentManager =getFragmentManager();

        FragmentTransaction ft =fragentManager.beginTransaction();
        ft.add(R.id.fragmentspace,new StudentProfile());
        ft.commit();







    }

    @Override
    public void onBackPressed() {
           int count = getFragmentManager().getBackStackEntryCount();

            if (count == 0) {
                super.onBackPressed();
                //additional code
            } else {
                getFragmentManager().popBackStack();
            }

        Intent intent =new Intent(this, Scanner.class);
        startActivity(intent);
        finish();
         }
}
