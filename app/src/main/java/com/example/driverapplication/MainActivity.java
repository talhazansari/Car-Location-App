package com.example.driverapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etID, etCell,etCarName;
    TextView tvTest;
    String name, car, cell,address;
    Button btnLogin, btnSignUp;
    final int SIGNUP=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializer();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                startActivityForResult(intent,SIGNUP);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkValidation()) {
                    if(etName.getText().toString().equals(name) &&
                    etCell.getText().toString().equals(cell) && etCarName.getText().toString().equals(car))
                    {
                        Intent intent = new Intent(MainActivity.this, DriverRecord.class);
                        String activityName = "ActivityName";
                        intent.putExtra("ActivityName", activityName);
                        intent.putExtra("DriverAddress", address);
                        intent.putExtra("DriverCell", cell);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Wrong Log in details: " +
                                "Remember Sign Up First", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==SIGNUP)
        {
            if(resultCode==RESULT_OK)
            {
                Toast.makeText(this, "You have Succesfully Made Account", Toast.LENGTH_SHORT).show();

                name = data.getStringExtra("keyName");
                cell= data.getStringExtra("keyCell");
                car= data.getStringExtra("keyCar");
                address= data.getStringExtra("keyAddress");


            }
            else if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this, "Account Created Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void intializer()
    {
        etName = findViewById(R.id.etName);
        etID = findViewById(R.id.etCell);
        etCell = findViewById(R.id.etCell);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        etCarName =  findViewById(R.id.etCarName);
    }

    private boolean checkValidation()
    {
        boolean flag = true;
        if(etName.getText().toString().isEmpty() )
        {
            Toast.makeText(this, "Sign Up first before Log-in or Don't Enter Empty" +
                    "", Toast.LENGTH_SHORT).show();
            flag = false;
        }

        if(etCarName.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Sign Up first before Log-in or Don't Enter Empty" +
                    "", Toast.LENGTH_SHORT).show();
            flag = false;
        }

        if(etCell.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Sign Up first before Log-in or Don't Enter Empty" +
                    "", Toast.LENGTH_SHORT).show();
            flag = false;
        }

        return flag;
    }
}