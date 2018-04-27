package unam.fi.mx.mylogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnEntrar;
    EditText edtUsser;
    EditText edtPassword;
    String mainPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEntrar = (Button)findViewById(R.id.acepted);
        edtUsser = (EditText)findViewById(R.id.login);
        edtPassword = (EditText)findViewById(R.id.password);
        mainPassword = "TexRules";

        btnEntrar.setOnClickListener(OnClickEntrar);
    }

    public View.OnClickListener OnClickEntrar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentData = new Intent(getApplicationContext(),CallActivity.class);
            intentData.putExtra(getResources().getString(R.string.var_usser),edtUsser.getText());
            String passUsser = edtPassword.getText().toString();
            if(0 == passUsser.compareTo(mainPassword)){
                Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(intentData);
            }
        }
    };
}
