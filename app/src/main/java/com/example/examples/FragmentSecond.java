package com.example.examples;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentSecond extends Fragment {
    View view;
    private EditText objA;
    private EditText objB;
    public TextView resText;
    public String resultText;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonUmn;
    DBHelper dbHelper;




    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        dbHelper=new DBHelper(getActivity());



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);

        objA=view.findViewById(R.id.inputA);
        objB=view.findViewById(R.id.inputB);
        resText=view.findViewById(R.id.textResult2);
        buttonPlus=view.findViewById(R.id.buttonPlus);
        if(resultText!=null){
            resText.setText(resultText);
        }
        buttonPlus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ClickPlus();

                    }
                }
        );
        buttonMinus=view.findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ClickMinus();

                    }
                }
        );
        buttonUmn=view.findViewById(R.id.buttonUmn);
        buttonUmn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ClickUmn();

                    }
                }
        );

        return view;
    }

    public void ClickPlus(){
        Integer A=Integer.parseInt(objA.getText().toString());
        Integer B=Integer.parseInt(objB.getText().toString());

        resultText=Integer.toString(A+B);
        SQLiteDatabase database=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBHelper.KEY_PROGRAMS,"2");
        contentValues.put(DBHelper.KEY_RESULT,resultText);
        database.insert(DBHelper.TABLE_RESULT,null,contentValues);
        resText.setText(resultText);
        MainActivity parent = (MainActivity)getActivity();
        historyItem history=new historyItem("Результат 2 фрагмента:"+resultText);

        parent.addHistory(history);
    }
    public void ClickMinus(){
        Integer A=Integer.parseInt(objA.getText().toString());
        Integer B=Integer.parseInt(objB.getText().toString());
        resultText=Integer.toString(A-B);
        SQLiteDatabase database=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBHelper.KEY_PROGRAMS,"2");
        contentValues.put(DBHelper.KEY_RESULT,resultText);
        database.insert(DBHelper.TABLE_RESULT,null,contentValues);
        resText.setText(resultText);
        MainActivity parent = (MainActivity)getActivity();
        historyItem history=new historyItem("Результат 2 фрагмента:"+resultText);
        parent.addHistory(history);
    }
    public void ClickUmn(){
        Integer A=Integer.parseInt(objA.getText().toString());
        Integer B=Integer.parseInt(objB.getText().toString());
        resultText=Integer.toString(A*B);
        SQLiteDatabase database=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DBHelper.KEY_PROGRAMS,"2");
        contentValues.put(DBHelper.KEY_RESULT,resultText);
        database.insert(DBHelper.TABLE_RESULT,null,contentValues);
        resText.setText(resultText);
        MainActivity parent = (MainActivity)getActivity();
        historyItem history=new historyItem("Результат 2 фрагмента:"+resultText);

        parent.addHistory(history);
    }
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("result2",resultText);



    }

}