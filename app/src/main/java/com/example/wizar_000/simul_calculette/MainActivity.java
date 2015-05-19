package com.example.wizar_000.simul_calculette;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView tv_inputOutput;
    private ImageButton btn_up;
    private ImageButton btn_down;
    private ImageButton btn_left;
    private ImageButton btn_right;
    private Button btn_OK;
    private ImageButton btn_vocalCommand;
    private ImageButton btn_help;
    private ImageButton btn_back;
    private ImageButton btn_delete;
    private Button btn_digit_1;
    private Button btn_digit_2;
    private Button btn_digit_3;
    private Button btn_digit_4;
    private Button btn_digit_5;
    private Button btn_digit_6;
    private Button btn_digit_7;
    private Button btn_digit_8;
    private Button btn_digit_9;
    private Button btn_digit_0;
    private Button btn_opt_comma;
    private Button btn_opt_pound;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initSimulKeyboard();
    }

    public void initSimulKeyboard() {
        tv_inputOutput = (TextView)findViewById(R.id.tv_display);
        btn_back = (ImageButton)findViewById(R.id.ib_back);
        btn_delete = (ImageButton)findViewById(R.id.ib_delete);
        btn_help = (ImageButton)findViewById(R.id.ib_help);
        btn_vocalCommand = (ImageButton)findViewById(R.id.ib_vocalcommand);
        btn_OK = (Button)findViewById(R.id.b_ok);
        btn_up = (ImageButton)findViewById(R.id.ib_up);
        btn_down=(ImageButton)findViewById(R.id.ib_down);
        btn_left =(ImageButton)findViewById(R.id.ib_left);
        btn_right = (ImageButton)findViewById(R.id.ib_right);
        btn_digit_0 = (Button)findViewById(R.id.b_digit_0);
        btn_digit_1 = (Button)findViewById(R.id.b_digit_1);
        btn_digit_2 = (Button)findViewById(R.id.b_digit_2);
        btn_digit_3 = (Button)findViewById(R.id.b_digit_3);
        btn_digit_4 = (Button)findViewById(R.id.b_digit_4);
        btn_digit_5 = (Button)findViewById(R.id.b_digit_5);
        btn_digit_6 = (Button)findViewById(R.id.b_digit_6);
        btn_digit_7 = (Button)findViewById(R.id.b_digit_7);
        btn_digit_8 = (Button)findViewById(R.id.b_digit_8);
        btn_digit_9 = (Button)findViewById(R.id.b_digit_9);
        btn_opt_comma = (Button)findViewById(R.id.b_digit_star);
        btn_opt_pound = (Button)findViewById(R.id.b_digit_plus);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
