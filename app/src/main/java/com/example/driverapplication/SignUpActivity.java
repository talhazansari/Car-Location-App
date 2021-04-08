package com.example.driverapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    EditText etName, etID, etAddress, etCar, etCell;
    Button  btnSignUp2;
    String id, name, address, car, cell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initializer();
        btnSignUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkValidation()) {
                    Intent intent = new Intent();
                    id = etID.getText().toString().trim();
                    name = etName.getText().toString().trim();
                    address = etAddress.getText().toString().trim();
                    car = etCar.getText().toString().trim();
                    cell = etCell.getText().toString().trim();
                    intent.putExtra("keyName", name);
                    intent.putExtra("keyCar", car);
                    intent.putExtra("keyCell", cell);
                    intent.putExtra("keyAddress", address);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    private void initializer() {

            etName = findViewById(R.id.etName2);
            etID = findViewById(R.id.etIDSign);
            etCar = findViewById(R.id.etCarSign);
            etAddress = findViewById(R.id.etAddressSign);
            etCell = findViewById(R.id.etCellSign);
            btnSignUp2 = findViewById(R.id.btnSignUp2);

    }

    private boolean checkValidation()
    {
        boolean flag = true;
        if(etName.getText().toString().isEmpty())
        {
            etName.setError("Name can't be empty");
            flag = false;
        }

        if(etID.getText().toString().isEmpty())
        {
            etID.setError("ID can't be empty");
            flag = false;
        }

        if(etCar.getText().toString().isEmpty())
        {
            etCar.setError("Car Model can't be empty");
            flag = false;
        }

        if(etAddress.getText().toString().isEmpty())
        {
            etAddress.setError("Address can't be empty");
            flag = false;
        }

        if(etCell.getText().toString().isEmpty())
        {
            etCell.setError("Cell can't be empty");
            flag = false;
        }
        return flag;
    }
}