package in.finertia.fisheries.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import in.finertia.fisheries.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityLoginBinding binding;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        rootView = binding.getRoot();
        setContentView(rootView);
        binding.btnLogin.setOnClickListener(this);
        binding.tvReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.btnLogin.getId()) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }else if (view.getId() == binding.tvReg.getId()) {
            Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(i);
        }
    }

}
