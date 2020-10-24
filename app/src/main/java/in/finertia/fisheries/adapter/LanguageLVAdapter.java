package in.finertia.fisheries.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import in.finertia.fisheries.R;
import in.finertia.fisheries.activity.LanguageSelectionActivity;
import in.finertia.fisheries.activity.LoginActivity;

public class LanguageLVAdapter extends BaseAdapter {

    private Context context;
    private List<String> langList;

    public LanguageLVAdapter(Context context, List<String> langList) {
        this.context = context;
        this.langList = langList;
    }

    @Override
    public int getCount() {
        return langList.size();
    }

    @Override
    public Object getItem(int i) {
        return langList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.lang_lv_child,null);
        TextView tvName = view.findViewById(R.id.tvLang);
        tvName.setText((String)getItem(i));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, LoginActivity.class);
                context.startActivity(i);
                ((LanguageSelectionActivity)context).finish();
            }
        });
        return view;
    }
}
