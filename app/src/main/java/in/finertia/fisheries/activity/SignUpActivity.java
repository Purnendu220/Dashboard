package in.finertia.fisheries.activity;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import in.finertia.fisheries.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {


    private ActivitySignUpBinding binding;
    private GoogleApiClient apiClient;
    private HintRequest hintRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initSocialLoginData();
        binding.btnCreate.setOnClickListener(this);
        checkPermission();
        binding.mobileNumber.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                openPhoneSelection();
                return true;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (apiClient != null) {
            apiClient.stopAutoManage(this);
            apiClient.disconnect();
        }
    }

    private void initSocialLoginData() {
        if (getIntent().hasExtra("userFBData")) {
            String fbData = getIntent().getExtras().getString("userFBData");
            try {
                JSONObject obj = new JSONObject(fbData);
                binding.fullName.setText(obj.getString("name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if (getIntent().hasExtra("userGEmail")) {
            binding.fullName.setText(getIntent().getExtras().getString("userGName"));
        }
    }

    private boolean isValid() {
        boolean isValid = true;
        if (binding.fullName.getText().toString().isEmpty()) {
            binding.fullName.setError("Enter full name");
            isValid = false;
        } else if (binding.mobileNumber.getText().toString().isEmpty()) {
            binding.mobileNumber.setError("Enter mobile");
            isValid = false;
        }
        return true;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == binding.btnCreate.getId()) {
            if (isValid()) {
                Intent i = new Intent(SignUpActivity.this, OtpActivity.class);
                startActivity(i);
            }
        } else if (view.getId() == binding.rlLogin.getId()) {
            SignUpActivity.this.finish();
        }
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 11);
        }
    }

    private void openPhoneSelection() {
        try {
            if (apiClient == null || !apiClient.isConnected())
                apiClient = new GoogleApiClient.Builder(this)
                        .addConnectionCallbacks(SignUpActivity.this)
                        .enableAutoManage(SignUpActivity.this, SignUpActivity.this)
                        .addApi(Auth.CREDENTIALS_API)
                        .build();
//        apiClient.connect();
            if (hintRequest == null)
                hintRequest = new HintRequest.Builder()
                        .setPhoneNumberIdentifierSupported(true)
                        .build();

            PendingIntent intent = Auth.CredentialsApi.getHintPickerIntent(
                    apiClient, hintRequest);
            try {
                startIntentSenderForResult(intent.getIntentSender(),
                        11, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            Log.e("Error", "While phone number selection! Ex:",e);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11) {
            if (resultCode == RESULT_OK) {
                com.google.android.gms.auth.api.credentials.Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);
                if (credential != null) {
                    binding.mobileNumber.setText(credential.getId());
                } else {
                }
            }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}