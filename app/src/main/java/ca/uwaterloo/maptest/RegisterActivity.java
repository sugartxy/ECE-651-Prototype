package ca.uwaterloo.maptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final int maxPasswordLength = 16;
        final EditText et_username = (EditText) findViewById(R.id.editText_username);
        final EditText et_password = (EditText) findViewById(R.id.editText_password);
        final EditText et_cmPassword = (EditText) findViewById(R.id.editText_cmPassword);
        Button b_register = (Button) findViewById(R.id.button_register);

        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String cmPassword = et_cmPassword.getText().toString();
                String email_regex = "^[a-z0-9A-Z]+[a-z0-9A-Z_-]*@[a-z0-9A-Z]+[a-z0-9A-Z\\.-]*\\.[a-z0-9A-Z]+$";
                if(username.isEmpty() || password.isEmpty() || cmPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Some fields are empty. You should fill out all the fields.",
                            Toast.LENGTH_SHORT).show();
                } else if(!username.matches(email_regex)) {
                    Toast.makeText(getApplicationContext(),
                            "Invalid email address. Please try again!",
                            Toast.LENGTH_SHORT).show();
                } else if(password.length() > maxPasswordLength) {
                    Toast.makeText(getApplicationContext(),
                            "Your password is too long. The maximum length of password is 16 characters. Try again!",
                            Toast.LENGTH_SHORT).show();
                }else if(password.equals(cmPassword)) {
                    Intent goToSignInActivity = new Intent(RegisterActivity.this, SignInActivity.class);
                    goToSignInActivity.putExtra("username", username);
                    goToSignInActivity.putExtra("password", password);
                    RegisterActivity.this.startActivity(goToSignInActivity);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "The passwords you've typed are not matched. Try again!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
