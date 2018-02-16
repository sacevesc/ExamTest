package mx.iteso.examtest;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Toast;


public class ActivityMain extends AppCompatActivity {
    Button btn[]= new Button[4] ;
    int last_btn=0;
    ImageButton like;
    Button cart;
    boolean added=false;
     ScrollView scrollview;
    Button save,size;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollview=findViewById(R.id.activity_main_scrollview);
        btn[0]=findViewById(R.id.activity_main_btn_s);
        btn[1]=findViewById(R.id.activity_main_btn_m);
        btn[2]=findViewById(R.id.activity_main_btn_l);
        btn[3]=findViewById(R.id.activity_main_btn_xl);
        cart=findViewById(R.id.activity_main_cart_btn);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 button_cart(scrollview);
                            }
        });

        like=findViewById(R.id.activtiy_main_facebook);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityMain.this, getResources().getString(R.string.like),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            btn[last_btn]=size;
            guardado(added);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
        }
    }

    public void guardado(boolean a){
        if(a){
            cart.setText(getResources().getString(R.string.cart_pressed));
            cart.setBackgroundColor(getResources().getColor(R.color.colorGray_light));

            Snackbar.make(scrollview,getResources().getString(R.string.cart_pressed), Snackbar.LENGTH_INDEFINITE)
                    .setAction("Undo",new View.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            cart.setText(getResources().getString(R.string.cart));
                            added=false;
                            cart.setBackgroundColor(getResources().getColor(R.color.colorGray_dark));
                        }
                    }).show();
        }

    }

    public void onClick(View view){
        reactive();
        switch (view.getId()) {
            case R.id.activity_main_btn_s:
                colorText_btn(0);
                break;
            case R.id.activity_main_btn_m:
                colorText_btn(1);
                break;
            case R.id.activity_main_btn_l:
                colorText_btn(2);
                break;
            case R.id.activity_main_btn_xl:
                colorText_btn(3);
                break;
        }
    }

    public void button_cart(ScrollView scrollview){
        cart.setText(getResources().getString(R.string.cart_pressed));
        cart.setBackgroundColor(getResources().getColor(R.color.colorGray_light));
        if(added) Toast.makeText(ActivityMain.this, getResources().getString(R.string.ready),Toast.LENGTH_SHORT).show();
        added=true;

        Snackbar.make(scrollview,getResources().getString(R.string.cart_pressed), Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo",new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        cart.setText(getResources().getString(R.string.cart));
                        added=false;
                        cart.setBackgroundColor(getResources().getColor(R.color.colorGray_dark));
                    }
                }).show();

    }

    public void colorText_btn(int n){
        btn[n].setTextColor(getResources().getColor(R.color.colorWhite));
        btn[n].setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        size=btn[n];
        last_btn=n;
    }
    public void reactive(){
        btn[last_btn].setTextColor(getResources().getColor(R.color.colorPrimary));
        btn[last_btn].setBackground(getDrawable(R.drawable.size_button));
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.activity_main_white:
                if (checked)
                break;
            case R.id.activity_main_pink:
                if (checked)
                break;
            case R.id.activity_main_brown:
                if (checked)
                break;
            case R.id.activity_main_black:
                if (checked)
                break;

        }
    }



}
