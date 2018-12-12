package com.example.dl3.lovecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends Activity  implements View.OnClickListener{
    String name1,name2,string,str;
    EditText fname,Sname;
    TextView answer;
    int a,firstValue,secondValue,length,k,b;
    char s;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = (EditText)findViewById(R.id.editText);
        Sname = (EditText)findViewById(R.id.editText2);
        answer = (TextView)findViewById(R.id.ans);
        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {
        name1 = fname.getText().toString();
        name2 = Sname.getText().toString();



        ArrayList<Integer> L = new ArrayList<Integer>(4);

        string = name1 + "love" + name2;
        char[] chars = string.toCharArray();

        //      List<Character> list = Arrays.asList(chars); // this does not compile,
        List<char[]> asList = Arrays.asList(chars); // because this DOES compile.

        List<Character> listC = new ArrayList<Character>();
        for (char c : chars) {
            listC.add(c);
        }

        while(listC.size() > 0){
            int count = 1;
            for(int j= 1;j < listC.size();j++) {
                if(listC.get(0) == listC.get(j)) {
                    count++;
                    listC.remove(j);
                }
            }
            listC.remove(0);
            L.add(count);


        }
        System.out.println(L);
        length = L.size();
        //sLength = L.size(); isko isliye kiya hai taki jb else block me i ki                     value increment hogi toh isko bhi krna padega
        while(length > 3 ){
            int l = 0;
            if(length %2 == 0){ // that means even
                length = L.size();

                for(int i=0; i< (L.size()/2)+l ; i++){
                    length = L.size();
                    k = length-1;
                    a = L.get(i) + L.get(k);
                    if(a < 10){
                        L.add(i,a);
                        L.remove(i+1);
                        L.remove(k);
                        if(L.size()%2 !=0)
                        {l++;}
                    }
                    else{
                        firstValue = a /10;
                        secondValue = a%10;
                        L.add(i,firstValue);
                        L.remove(i+1);
                        i = i+1;
                        L.add(i,secondValue);
                        L.remove(k+1);
                        l = l+1;
                    }

                }
            }
            else{
                for(int i=0; i< (L.size()/2)+l ; i++){
                    length = L.size();
                    k = length-1;
                    a = L.get(i) + L.get(k);
                    if(a < 10){
                        L.add(i,a);
                        L.remove(i+1);
                        L.remove(k);
                        if(L.size()%2 !=0)
                        {l++;}


                    }
                    else{
                        firstValue = a /10;
                        secondValue = a%10;
                        L.add(i,firstValue);
                        L.remove(i+1);
                        i = i+1;
                        L.add(i,secondValue);
                        L.remove(k+1);
                        l = l+1;
                    }

                }

            }
        }
        if(L.size() == 3){
            b = L.get(0) + L.get(L.size()-1);
            L.add(0,b);
            L.remove(1);
            L.remove(L.size()-1);
        }



        str = String.valueOf(L.get(0))+String.valueOf(L.get(1))+"%";
       answer.setText(str);

    }
}
