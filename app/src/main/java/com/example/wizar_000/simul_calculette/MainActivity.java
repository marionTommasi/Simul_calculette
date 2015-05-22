package com.example.wizar_000.simul_calculette;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import constant.*;


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
    private String onScreen = "0.0";
    enum_feedback enterFeedback = enum_feedback.INVALID_INPUT;

    public MainActivity() {
    }
    CalculationModule calculationModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculationModule = new CalculationModule();
        initSimulKeyboard();
    }

    public void initSimulKeyboard() {
        tv_inputOutput = (TextView)findViewById(R.id.tv_display);
        tv_inputOutput.setText(onScreen);
        btn_back = (ImageButton)findViewById(R.id.ib_back);
        btn_back.setOnClickListener(new ButtonClickedHandler());
        btn_delete = (ImageButton)findViewById(R.id.ib_delete);
        btn_delete.setOnClickListener(new ButtonClickedHandler());
        btn_help = (ImageButton)findViewById(R.id.ib_help);
        btn_help.setOnClickListener(new ButtonClickedHandler());
        btn_vocalCommand = (ImageButton)findViewById(R.id.ib_vocalcommand);
        btn_vocalCommand.setOnClickListener(new ButtonClickedHandler());
        btn_OK = (Button)findViewById(R.id.b_ok);
        btn_OK.setOnClickListener(new ButtonClickedHandler());
        btn_up = (ImageButton)findViewById(R.id.ib_up);
        btn_up.setOnClickListener(new ButtonClickedHandler());
        btn_down=(ImageButton)findViewById(R.id.ib_down);
        btn_down.setOnClickListener(new ButtonClickedHandler());
        btn_left =(ImageButton)findViewById(R.id.ib_left);
        btn_left.setOnClickListener(new ButtonClickedHandler());
        btn_right = (ImageButton)findViewById(R.id.ib_right);
        btn_right.setOnClickListener(new ButtonClickedHandler());
        btn_digit_0 = (Button)findViewById(R.id.b_digit_0);
        btn_digit_0.setOnClickListener(new ButtonClickedHandler());
        btn_digit_1 = (Button)findViewById(R.id.b_digit_1);
        btn_digit_1.setOnClickListener(new ButtonClickedHandler());
        btn_digit_2 = (Button)findViewById(R.id.b_digit_2);
        btn_digit_2.setOnClickListener(new ButtonClickedHandler());
        btn_digit_3 = (Button)findViewById(R.id.b_digit_3);
        btn_digit_3.setOnClickListener(new ButtonClickedHandler());
        btn_digit_4 = (Button)findViewById(R.id.b_digit_4);
        btn_digit_4.setOnClickListener(new ButtonClickedHandler());
        btn_digit_5 = (Button)findViewById(R.id.b_digit_5);
        btn_digit_5.setOnClickListener(new ButtonClickedHandler());
        btn_digit_6 = (Button)findViewById(R.id.b_digit_6);
        btn_digit_6.setOnClickListener(new ButtonClickedHandler());
        btn_digit_7 = (Button)findViewById(R.id.b_digit_7);
        btn_digit_7.setOnClickListener(new ButtonClickedHandler());
        btn_digit_8 = (Button)findViewById(R.id.b_digit_8);
        btn_digit_8.setOnClickListener(new ButtonClickedHandler());
        btn_digit_9 = (Button)findViewById(R.id.b_digit_9);
        btn_digit_9.setOnClickListener(new ButtonClickedHandler());
        btn_opt_comma = (Button)findViewById(R.id.b_digit_star);
        btn_opt_comma.setOnClickListener(new ButtonClickedHandler());
        btn_opt_pound = (Button)findViewById(R.id.b_digit_plus);
        btn_opt_pound.setOnClickListener(new ButtonClickedHandler());

    }

    public class ButtonClickedHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.b_digit_0:
                    enterFeedback = calculationModule.GetInput('0');
                    handleDisplay(enterFeedback, '0');
                    break;
                case R.id.b_digit_1:
                    enterFeedback= calculationModule.GetInput('1');
                    handleDisplay(enterFeedback, '1');
                    break;
                case R.id.b_digit_2:
                    enterFeedback= calculationModule.GetInput('2');
                    handleDisplay(enterFeedback, '2');
                    break;
                case R.id.b_digit_3:
                    enterFeedback= calculationModule.GetInput('3');
                    handleDisplay(enterFeedback, '3');
                    break;
                case R.id.b_digit_4:
                    enterFeedback= calculationModule.GetInput('4');
                    handleDisplay(enterFeedback, '4');
                    break;
                case R.id.b_digit_5:
                    enterFeedback= calculationModule.GetInput('5');
                    handleDisplay(enterFeedback, '5');
                    break;
                case R.id.b_digit_6:
                    enterFeedback= calculationModule.GetInput('6');
                    handleDisplay(enterFeedback, '6');
                    break;
                case R.id.b_digit_7:
                    enterFeedback= calculationModule.GetInput('7');
                    handleDisplay(enterFeedback, '7');
                    break;
                case R.id.b_digit_8:
                    enterFeedback= calculationModule.GetInput('8');
                    handleDisplay(enterFeedback, '8');
                    break;
                case R.id.b_digit_9:
                    enterFeedback= calculationModule.GetInput('9');
                    handleDisplay(enterFeedback, '9');
                    break;
                case R.id.b_digit_star:
                    enterFeedback = calculationModule.GetInput('.');
                    handleDisplay(enterFeedback, '.');
                    break;
                case R.id.ib_down:
                    enterFeedback= calculationModule.GetInput('-');
                    handleDisplay(enterFeedback, '-');
                    break;
                case R.id.ib_up:
                    enterFeedback= calculationModule.GetInput('+');
                    handleDisplay(enterFeedback, '+');
                    break;
                case R.id.ib_left:
                    enterFeedback= calculationModule.GetInput('*');
                    handleDisplay(enterFeedback, '*');
                    break;
                case R.id.ib_right:
                    enterFeedback= calculationModule.GetInput('/');
                    handleDisplay(enterFeedback, '/');
                    break;
                case R.id.ib_delete:
                    enterFeedback= calculationModule.GetInput('B');
                    handleDisplay(enterFeedback, 'B');
                    break;
                case R.id.ib_back:
                    finish();
                    break;
                case R.id.b_ok:
                    enterFeedback= calculationModule.GetInput('=');
                    double result = calculationModule.getResult();
                    if (Math.abs(result) <= Double.MIN_VALUE){
                        Toast.makeText(getApplicationContext(), "Calculator error",
                                Toast.LENGTH_SHORT).show();
                    }else tv_inputOutput.setText(result+"");
                    break;





            }
        }

    }

    private void handleDisplay(enum_feedback enterFeedback, char input) {
        if (onScreen == "0.0")
            onScreen ="";
        switch (enterFeedback){
            case INVALID_INPUT:
                speakOut("Wrong input");
                break;
            case VALID_INPUT:
                onScreen+=input;
                onScreen = calculationModule.getInputQueue();
                tv_inputOutput.setText(onScreen);
                speakOut(input+"");
                break;
            case REQUEST_RESULT:
                tv_inputOutput.setText(onScreen);
                speakOut(onScreen);
                break;
        }
    }

    /**
     * Speak out the result
     * @param onScreen
     */
    private void speakOut(String onScreen) {
        //TODO
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
