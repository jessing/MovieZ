package zh.ou.movie.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import zh.ou.movie.R;
import zh.ou.movie.ui.fragment.MainFragment;

import static zh.ou.movie.util.AppUtil.showAbout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container,new MainFragment()).commit();
    }
    public void menu(View view){
        showAbout(this);
    }
    public void search(View view){
        startActivity(new Intent(this,SearchActivity.class));
    }
}
