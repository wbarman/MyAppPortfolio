package com.homegadgetry.myappportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private final String toastString = "This button will launch my %s app!";

    Button buttonPopularMovies;
   /* @BindView(R.id.buttonBuildItBigger)
    Button buttonBuildItBigger;
    @BindView(R.id.buttonMakeAppMaterial)
    Button buttonMakeAppMaterial;
    @BindView(R.id.buttonGoUbiquitous)
    Button buttonGoUbiquitous;
    @BindView(R.id.buttonCapstone)
    Button buttonCapstone;
    @BindView(R.id.buttonStockHawk)
    private Button buttonStockHawk;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get rid of boilerplate code - I love this
//        ButterKnife.bind(this);

        // classic way of event handling
        buttonPopularMovies = (Button) findViewById(R.id.buttonPopularMovies);
        buttonPopularMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.format(toastString, getText(R.string.popular_movies)), Toast.LENGTH_LONG).show();
            }
        });

        // ok, my fault, android uses java sdk 1.7, not 1.8, so I cannot use lambdas
        /*Button buttonStockHawk = (Button)findViewById(R.id.buttonStockHawk);
        buttonStockHawk.setOnClickListener(()->{
        });*/

    }

    // tried a new way with Butterknife
    @OnClick({R.id.buttonStockHawk, R.id.buttonBuildItBigger, R.id.buttonMakeAppMaterial, R.id.buttonGoUbiquitous, R.id.buttonCapstone})
    public void onClick(View view) {
        CharSequence appName;

        switch (view.getId()) {
            case R.id.buttonStockHawk:
                appName = getText(R.string.stock_hawk);
                break;
            case R.id.buttonBuildItBigger:
                appName = getText(R.string.build_it_bigger);
                break;
            case R.id.buttonMakeAppMaterial:
                appName = getText(R.string.make_your_app_material);
                break;
            case R.id.buttonGoUbiquitous:
                appName = getText(R.string.go_ubiquitous);
                break;
            case R.id.buttonCapstone:
                appName = getText(R.string.capstone);
                break;
            default:
                appName = "Unknown";
        }
        Toast.makeText(MainActivity.this, String.format(toastString, appName), Toast.LENGTH_LONG)
                .show();
    }
}
