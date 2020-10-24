package in.finertia.fisheries.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import in.finertia.fisheries.adapter.LanguageLVAdapter;
import in.finertia.fisheries.databinding.ActivityLanguageSelectionBinding;

public class LanguageSelectionActivity extends AppCompatActivity {

    private ActivityLanguageSelectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLanguageSelectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initLanguageList();
        SharedPreferences pref = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isOneTime", false);
        editor.commit();
    }

    private void initLanguageList() {
        List<String> langList = new ArrayList<>();

        langList.add("Hindi हिन्दी");
        langList.add("English English");
        langList.add("Bengali বাংলা");
        langList.add("Gujarati ગુજરાતી");
        langList.add("Punjabi ਪੰਜਾਬੀ");
        langList.add("Kannada ಕನ್ನಡ");
        langList.add("Urdu اُردُو");
        langList.add("Malayalam മലയാളം");
        langList.add("Tamil தமிழ்");

        LanguageLVAdapter adapter = new LanguageLVAdapter(this,langList);
        binding.lvLang.setAdapter(adapter);
    }


}