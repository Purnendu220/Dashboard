package in.finertia.fisheries.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import in.finertia.fisheries.databinding.ActivityOtpBinding;

public class OtpActivity extends AppCompatActivity {

    private ActivityOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnSubmitOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.etOtp.getText().toString().isEmpty()){
                    binding.etOtp.setError("Enter valid OTP");
                }else {
                    Intent i = new Intent(OtpActivity.this, PasswordActivity.class);
                    startActivity(i);
                }
            }
        });
    }


}