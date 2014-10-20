package com.example.cveki.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Cveki on 13.10.2014..
 */
public class OpenedClass extends Activity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{

    TextView question, test;
    Button returnData;
    RadioGroup selectionList;
    String gotBread;
    String setData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();
        /*Bundle gotBasket= getIntent().getExtras();
        gotBread=gotBasket.getString("key");
        question.setText(gotBread);*/

    }

    private void initialize() {
        question=(TextView) findViewById(R.id.tvQuestion);
        test=(TextView) findViewById(R.id.tvTest);
        returnData=(Button)findViewById(R.id.bReturn);
        returnData.setOnClickListener(this);
        selectionList= (RadioGroup) findViewById(R.id.rgAnswers);
        selectionList.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent person= new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answer",setData);
        person.putExtras(backpack);
        setResult(RESULT_OK,person);
        finish();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rCrazy:
                setData = "Probably righ!";
                break;
            case R.id.rSexy:
                setData = "Definitely righ!";
                break;
            case R.id.rBoth:
                setData = "Spot on!";
                break;
        }

        test.setText(setData);
    }



}
