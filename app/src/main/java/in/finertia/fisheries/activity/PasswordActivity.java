package in.finertia.fisheries.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import in.finertia.fisheries.databinding.ActivityPasswordBinding;

public class PasswordActivity extends AppCompatActivity {

    private ActivityPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PasswordActivity.this,PersonDetailsActivity.class);
                startActivity(i);
            }
        });
    }
}