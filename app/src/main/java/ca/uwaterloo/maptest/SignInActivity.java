package ca.uwaterloo.maptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        final EditText et_username = (EditText) findViewById(R.id.editText_username);
        final EditText et_password = (EditText) findViewById(R.id.editText_password);
        Button b_signIn = (Button) findViewById(R.id.button_signIn);
        Button b_signUp = (Button) findViewById(R.id.button_signUp);
        Intent caller = getIntent();
        final String register_username = caller.getStringExtra("username");
        final String register_password = caller.getStringExtra("password");

        b_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                String email_regex = "^[a-z0-9A-Z]+[a-z0-9A-Z_-]*@[a-z0-9A-Z]+[a-z0-9A-Z\\.-]*\\.[a-z0-9A-Z]+$";
                if(username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Username or password is empty. You should fill out all fields.",
                            Toast.LENGTH_SHORT).show();
                } else if(!username.matches(email_regex)) {
                    Toast.makeText(getApplicationContext(),
                            "Invalid email address. Please try again!",
                            Toast.LENGTH_SHORT).show();
                } else if(username.equals(register_username) && password.equals(register_password)) {
                    Intent signInIntent = new Intent(SignInActivity.this, MapsActivity.class);
                    SignInActivity.this.startActivity(signInIntent);
                    //finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Wrong username or password. Try again!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        b_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(SignInActivity.this, RegisterActivity.class);
                SignInActivity.this.startActivity(signUpIntent);
                finish();
            }
        });
    }
}
