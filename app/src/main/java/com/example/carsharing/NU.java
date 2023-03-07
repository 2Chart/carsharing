package com.example.carsharing;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carsharing.database.AppDatabase;

public class NU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Reg);

        final EditText firstNameInput = findViewById(R.id.addName);
        final EditText lastNameInput = findViewById(R.id.addDescription);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(firstNameInput.getText().toString(), descriptionInput.getText().toString());
            }
        });
    }

    private void saveNewUser(String firstName, String Description){

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.firstName = firstName;
        user.Description = Description;
        db.userDao().insertUser(user);

        finish();

    }

}
