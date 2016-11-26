package com.example.zhangshixian.kkweather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by ZHANGSHIXIAN on 2016/7/16.
 */
public class Search extends AppCompatActivity implements View.OnClickListener{

    Button button0;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;
    Toolbar toolbar;

    AutoCompleteTextView actextview;
    LinearLayout linearLayout;
    List<String> citylist;
    InputMethodManager imm;

    private String[] mBTNNames = new String[16];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        initdata();
        setButtonListen();
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        Intent i=getIntent();
        citylist=i.getStringArrayListExtra("citylist");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(Search.this,android.R.layout.simple_expandable_list_item_1,citylist);
        actextview.setAdapter(adapter);
       // toolbar.inflateMenu(R.menu.toolbarmenu);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initdata() {

        button0=(Button) findViewById(R.id.button0);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);
        button6=(Button) findViewById(R.id.button6);
        button7=(Button) findViewById(R.id.button7);
        button8=(Button) findViewById(R.id.button8);
        button9=(Button) findViewById(R.id.button9);
        button10=(Button) findViewById(R.id.button10);
        button11=(Button) findViewById(R.id.button11);
        button12=(Button) findViewById(R.id.button12);
        button13=(Button) findViewById(R.id.button13);
        button14=(Button) findViewById(R.id.button14);
        button15=(Button) findViewById(R.id.button15);
        button16=(Button) findViewById(R.id.button16);
        actextview=(AutoCompleteTextView) findViewById(R.id.actextview);
        toolbar= (Toolbar) findViewById(R.id.toolbar_search);
    }
    private void setButtonListen(){
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
        button16.setOnClickListener(this);
    }


    private void searchJudge(View v,String mcityname){
         if (!mcityname.equals("")&&citylist.contains(mcityname)) {
             //imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
             Intent intent = new Intent(Search.this, MainActivity.class);
             intent.putExtra("city", mcityname);
             setResult(RESULT_OK, intent);
             finish();
         }else {
             imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
             // Snackbar.make(v,"请重新确认城市名称是否正确", Snackbar.LENGTH_SHORT).show();
             SnackbarUtil.ShortSnackbar(v,"请重新确认城市名称是否正确",SnackbarUtil.Alert).show();
         }
     }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:searchJudge(v,actextview.getText().toString());break;
            case R.id.button1: searchJudge(v,button1.getText().toString());break;
            case R.id.button2: searchJudge(v,button2.getText().toString());break;
            case R.id.button3: searchJudge(v,button3.getText().toString());break;
            case R.id.button4: searchJudge(v,button4.getText().toString());break;
            case R.id.button5: searchJudge(v,button5.getText().toString());break;
            case R.id.button6: searchJudge(v,button6.getText().toString());break;
            case R.id.button7: searchJudge(v,button7.getText().toString());break;
            case R.id.button8: searchJudge(v,button8.getText().toString());break;
            case R.id.button9: searchJudge(v,button9.getText().toString());break;
            case R.id.button10: searchJudge(v,button10.getText().toString());break;
            case R.id.button11: searchJudge(v,button11.getText().toString());break;
            case R.id.button12: searchJudge(v,button12.getText().toString());break;
            case R.id.button13: searchJudge(v,button13.getText().toString());break;
            case R.id.button14: searchJudge(v,button14.getText().toString());break;
            case R.id.button15: searchJudge(v,button15.getText().toString());break;
            case R.id.button16: searchJudge(v,button16.getText().toString());break;
                
        }
        
    }
}
