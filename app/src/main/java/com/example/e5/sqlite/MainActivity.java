package com.example.e5.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button bt;
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final PersonSQLiteOpenHelper helper=new PersonSQLiteOpenHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button) findViewById(R.id.button);
        bt2=(Button)findViewById(R.id.button2);

        bt.setOnClickListener(new View.OnClickListener() {


            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                try{SQLiteDatabase db=helper.getWritableDatabase();
                    db.execSQL("insert into F(name,number) " +
                            "values(?,?)",new Object[]{4,123456} );
                    Toast.makeText(MainActivity.this, "OK",Toast.LENGTH_SHORT).show();
                    db.close();

                }catch(RuntimeException e){

                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    SQLiteDatabase db=helper.getReadableDatabase();

                    Cursor cu=db.rawQuery("select * from F", null);
                    while(cu.moveToNext()){
                        //Bean bean=new Bean();

                        System.out.println(cu.getInt(0));
                        System.out.println(cu.getInt(1));
                        System.out.println(cu.getInt(2));





                    }

                    cu.close();

                    db.close();
                }

        });
    }
}
